package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bpmn.TProcess;
import helpers.Node;
import helpers.Solution;
import services.AlgorithmService;

public class MainRunAlgorithm {

	private static ArrayList<ArrayList<Solution>> runSolutions;
	private static ArrayList<Solution> bestFound;

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(args[0]);
		File diagramsDirectory = path.toFile();
		if (!diagramsDirectory.isDirectory())
			throw new Exception(diagramsDirectory + " must be a directory!");
		runSolutions = new ArrayList<>();
		bestFound = new ArrayList<>();

		AlgorithmService as = null;

		HashMap<String, Integer> initialConfig = null;

		HashMap<String, String> initialMutableTasks = null;

		HashMap<String, Node> initialTasks = null;

		Solution initial_value = null;

		int initMutsIoT = 1;

		long elapsedTime = 0;

		BufferedWriter bw2;

		BufferedWriter bw4;

		ArrayList<Solution> bestSolutions = new ArrayList<Solution>();

		boolean dominated;

		int j;

		bw4 = csvOutputFile2(diagramsDirectory.getName()+"_summary.csv");

		double osn = 0;
		double avgdev = 0;

		double osnRun = 0;
		double avgdevRun = 0;
		double distance = 0;
		double maxDistance = 0;

		double falseOptimalRun = 0;
		double falseOptimal = 0;

		double countFile = 0;

		long runTimeRun = 0;
		long stabItSum = 0;
		long totalIterations = 0;
		long runTime = 0;

		int uniqueSolsNumber = 0;
		int avgUniqueSolsNumber = 0;

		File[] directoryListing = diagramsDirectory.listFiles();
		for (File diagram : directoryListing) {
			bestSolutions = new ArrayList<Solution>();
			countFile ++;

			runTimeRun = 0;

			stabItSum = 0;
			totalIterations = 0;

			uniqueSolsNumber = 0;
			avgUniqueSolsNumber = 0;

			if (args[3].equals("r")) {
				as = new AlgorithmService(diagram.toString(), args[1], Boolean.parseBoolean(args[2]));

				initial_value = as.initialValueV2();

				System.out.println("Process cost is " + initial_value.getCostOfMessages());
				System.out.println("Process risk is " + initial_value.getRisk());
			}
			if (args[3].equals("d")) {
				File runDir2 = new File("results" + File.separator + diagram.getName());
				if (!runDir2.exists()) {
					runDir2.mkdirs();
				}

				bw2 = new BufferedWriter(new FileWriter(new File(runDir2,diagram.getName() + "_bestSolutionsInfo.csv")));
				bw2.write("Name;ExecutTime;StabIt;TotalIt;#Participants;#MutNodes;#Nodes;#Splits;Init#Comms;Optimal#Comms;#OptimalSols;InitRisk;InitCost;OptimalRisk;OptimalCost;CatsRisks;");

				for (int i = 1; i<=3; i++) {
					bw2.write("Participant "+i+";");
				}

				bw2.write("\n");

				falseOptimalRun = 0;
				avgdevRun = 0;
				distance = 0;
				maxDistance = 0;
				for (int i = 0; i<Integer.parseInt(args[4]); i++) {
					j=i+1;

					File runDir = new File("results" + File.separator + diagram.getName() + File.separator + j);
					if (!runDir.exists()) {
						runDir.mkdirs();
					}

					double riskSum = 0;
					ArrayList<Double> squaredDeviations = new ArrayList<Double> ();

					as = new AlgorithmService(diagram.toString(), args[1], Boolean.parseBoolean(args[2]));

					initialConfig = as.tasksPerLane();
					initialMutableTasks = as.getMutableTasksInfo();
					initialTasks = as.getNodes();
					initMutsIoT = 0;
			        for (String node : initialMutableTasks.values()){
			        	if(!node.equals(as.getProcesses().get(0).getId()))
			        		initMutsIoT++;
					}

					List<Solution> solutions = new ArrayList<Solution>();

					long startTime = System.currentTimeMillis();
					solutions= as.runAlgorithm();
					long stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;

					initial_value = as.initialValue();

					avgUniqueSolsNumber += uniqueSolsNumber;

					for (Solution solution : as.getBestSolutions()) {

						dominated = false;

						Iterator<Solution> sol = bestSolutions.iterator();
						int graphCount;
				        Map<String, List<String>> graph;
						while (sol.hasNext()) {
							Solution s = sol.next();
							if (!s.equals(solution)) {
								if (dominates(s, solution)) {
									dominated = true;
									break;
								}
								if (dominates(solution, s))
									sol.remove();
							}
							else {
								dominated = true;
								graphCount = solution.getNodes().values().iterator().next().size();

								for (int k = 0; k < graphCount; k++) {

									graph = new HashMap<String, List<String>>();
							        for (TProcess p : as.getProcesses()) {
							            graph.put(p.getId(), solution.getNodes().get(p.getId()).get(k));
							        }

							        if (!as.graphExists(s.getNodes(), graph)) {
							            for (TProcess p : as.getProcesses()) {
							                s.getNodes().computeIfAbsent(p.getId(), t -> new ArrayList<>())
							                    .add(new ArrayList<>(graph.get(p.getId())));
							            }
							        }
								}
								break;
							}
						}

						if (!dominated)
							bestSolutions.add(solution);

					}

					ArrayList<Solution> thisRunSolutions = new ArrayList<>();
					runSolutions.add(thisRunSolutions);
					for (Solution s : solutions) {

						riskSum = riskSum + s.getRisk();
						squaredDeviations.add(s.getRisk());

						addSolutionOrderly(thisRunSolutions, s);
						Solution best_existing = null;
						for (Iterator<Solution> iterator = bestFound.iterator(); iterator.hasNext();) {
							best_existing = iterator.next();
							if (dominates(s, best_existing))
								iterator.remove();
						}

						int numberOfDominatingSolutions = 0;
						for (Solution existing : bestFound)
							if (dominates(existing, s)) {
								numberOfDominatingSolutions++;
								break;
							}

						if (numberOfDominatingSolutions == 0)
							bestFound.add(s);
					}

					double bestRisk = 0;
					double bestMC = 0;
					int countR = 0;
					int countM = 0;
					for (Solution s: bestSolutions) {
						if (bestRisk < s.getRisk()) {
							bestRisk = s.getRisk();
							countR = 1;
						}
						else if(bestRisk == s.getRisk())
							countR++;

						if (bestMC < s.getCostOfMessages()) {
							bestMC = s.getCostOfMessages();
							countM = 1;
						}
						else if(bestMC == s.getCostOfMessages())
							countM++;
					}

					double deviationsSum = 0;
					for (double deviation : squaredDeviations)
						deviationsSum = deviationsSum + deviation;

					System.out.println(i+1 + ": " + diagram.getName().toString());

					runTimeRun += elapsedTime;

					stabItSum += as.stabilizingIteration();
					totalIterations = as.totalIterations();
				}

				runTime += elapsedTime;

				osn += bestSolutions.size();
				osnRun = bestSolutions.size();

				double minimumRisk = initial_value.getRisk();
				double minimumCost = initial_value.getCostOfMessages();
				String bestSolutionsBuilder ="(";

				bestSolutions.sort(Comparator.comparingDouble(Solution::getRisk).reversed());

				Collection<ArrayList<ArrayList<String>>> values;
				ArrayList<ArrayList<ArrayList<String>>> valueLists;
				int size;

				Solution currSol2 = bestSolutions.get(0);
				for (Solution sol2 : bestSolutions) {
					values = sol2.getNodes().values();
					valueLists = new ArrayList<ArrayList<ArrayList<String>>>(values);
					size = valueLists.get(0).size();
					if (size > 10) {
						size = 10;
					}
					for (int i = 0; i < size; i++) {
						bw2.write(diagram.getName() + ";"
								+ runTimeRun/Double.parseDouble(args[4]) + ";"
								+ stabItSum/Double.parseDouble(args[4]) + ";"
								+ as.totalIterations() + ";"
								+ initialConfig.keySet().size() + ";"
								+ initialMutableTasks.size() + ";"
								+ initialTasks.size() + ";"
								+ as.numGateways()/2 + ";"
								+ initial_value.getNumberCommunications() + ";"
								+ sol2.getNumberCommunications() + ";"
								+ bestSolutions.size() + ";"
								+ initial_value.getRisk() + ";"
								+ initial_value.getCostOfMessages() + ";"
								+ sol2.getRisk() + ";"
								+ sol2.getCostOfMessages() + ";"
								+ sol2.getCats().toString() + ";");

						for (ArrayList<ArrayList<String>> process : valueLists) {
						    bw2.write(process.get(i) + ";");
						}

						bw2.write("\n");
					}

					double riskDist = Math.abs(dist(normalise(currSol2.getRisk(),as.getMaxRisk()),normalise(sol2.getRisk(),as.getMaxRisk())));
					double costDist = Math.abs(dist(normalise(currSol2.getCostOfMessages(),as.getMaxCost()),normalise(sol2.getCostOfMessages(),as.getMaxCost())));

					double tradeoff = (normalise(sol2.getRisk(),as.getMaxRisk()) - normalise(initial_value.getRisk(),as.getMaxRisk())) + (normalise(currSol2.getCostOfMessages(),as.getMaxCost()) - normalise(initial_value.getCostOfMessages(),as.getMaxCost()));

					bw4.write(diagram.getName() + ";"
							+ runTimeRun/Double.parseDouble(args[4]) + ";"
							+ stabItSum/Double.parseDouble(args[4]) + ";"
							+ as.totalIterations() + ";"
							+ initialConfig.keySet().size() + ";"
							+ initialMutableTasks.size() + ";"
							+ initialTasks.size() + ";"
							+ as.numGateways()/2 + ";"
							+ initial_value.getNumberCommunications() + ";"
							+ sol2.getNumberCommunications() + ";"
							+ bestSolutions.size() + ";"
							+ initial_value.getRisk() + ";"
							+ initial_value.getCostOfMessages() + ";"
							+ sol2.getRisk() + ";"
							+ sol2.getCostOfMessages() + ";"
							+ sol2.getNodes().values().iterator().next().size() + ";"
							+ riskDist + ";"
							+ costDist + ";"
							+ tradeoff + ";"
									+ "\n");

					if (sol2.equals(initial_value)) {
						falseOptimalRun++;
						falseOptimal++;
					}

					if (sol2.getRisk()<minimumRisk)
						minimumRisk=sol2.getRisk();

					if (sol2.getCostOfMessages()<minimumCost)
						minimumCost=sol2.getCostOfMessages();

					avgdevRun += Math.sqrt(Math.pow(Math.abs(currSol2.getRisk() - sol2.getRisk()), 2) + Math.pow(Math.abs(currSol2.getCostOfMessages() - sol2.getCostOfMessages()), 2));

					bestSolutionsBuilder +=sol2.toString()+",";

					currSol2 = sol2;
				}

				bestSolutionsBuilder = bestSolutionsBuilder.substring(0, bestSolutionsBuilder.length()-1);
				bestSolutionsBuilder +=")";

				bw2.close();

				avgdev += avgdevRun/Double.parseDouble(args[4]);
			}
		}

		bw4.close();

	}

	public static double dist(double init, double finalV) {
        double dx = init - finalV;
        return dx;
    }

	public static double dist2(double riskInit, double riskFinal, double costInit, double costFinal) {
        double dx = riskInit - riskFinal;
        double dy = costInit - costFinal;
        return Math.sqrt(dx*dx + dy*dy);
    }

	public static double[] spread(ArrayList<Solution> bestSols, AlgorithmService as) {
        double min1 = Double.POSITIVE_INFINITY, max1 = Double.NEGATIVE_INFINITY;
        double min2 = Double.POSITIVE_INFINITY, max2 = Double.NEGATIVE_INFINITY;
        for (Solution s : bestSols) {
            min1 = Math.min(min1, normalise(s.getRisk(),as.getMaxRisk())); max1 = Math.max(max1, normalise(s.getRisk(),as.getMaxRisk()));
            min2 = Math.min(min2, normalise(s.getCostOfMessages(),as.getMaxCost())); max2 = Math.max(max2, normalise(s.getCostOfMessages(),as.getMaxCost()));
        }
        return new double[] { max1 - min1, max2 - min2 };
    }

	public static double DistToUtopia(Solution sol, ArrayList<Solution> pareto, AlgorithmService as) {
        if (pareto == null || pareto.isEmpty()) return 0.0;

        double minRisk = Double.POSITIVE_INFINITY;
        double minCost = Double.POSITIVE_INFINITY;
        for (Solution s : pareto) {
            if (normalise(s.getRisk(),as.getMaxRisk()) < minRisk) minRisk = normalise(s.getRisk(),as.getMaxRisk());
            if (normalise(s.getCostOfMessages(),as.getMaxCost()) < minCost) minCost = normalise(s.getCostOfMessages(),as.getMaxCost());
        }

        double totalDist = 0.0;
    	double dRisk = normalise(sol.getRisk(),as.getMaxRisk()) - minRisk;
        double dCost = normalise(sol.getCostOfMessages(),as.getMaxCost()) - minCost;
		totalDist = Math.sqrt(dRisk * dRisk + dCost * dCost);

        return totalDist;
    }

	public static double avgDistToUtopia(ArrayList<Solution> pareto, AlgorithmService as) {
        if (pareto == null || pareto.isEmpty()) return 0.0;

        double minRisk = Double.POSITIVE_INFINITY;
        double minCost = Double.POSITIVE_INFINITY;
        for (Solution s : pareto) {
        	if (normalise(s.getRisk(),as.getMaxRisk()) < minRisk) minRisk = normalise(s.getRisk(),as.getMaxRisk());
            if (normalise(s.getCostOfMessages(),as.getMaxCost()) < minCost) minCost = normalise(s.getCostOfMessages(),as.getMaxCost());
        }

        double totalDist = 0.0;
        for (Solution s : pareto) {
        	double dRisk = normalise(s.getRisk(),as.getMaxRisk()) - minRisk;
            double dCost = normalise(s.getCostOfMessages(),as.getMaxCost()) - minCost;
			totalDist += Math.sqrt(dRisk * dRisk + dCost * dCost);

        }

        return totalDist / pareto.size();
    }

	private static double normalise(double objValue, double maxObjRef) {
		return objValue / maxObjRef;

	}

	private static BufferedWriter csvOutputFile2(String output_file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("results",output_file)));
		bw.write("Name;ExecutTime;StabIt;TotalIt;#Participants;#MutNodes;#Nodes;#Splits;Init#Comms;Optimal#Comms;#OptimalSols;InitRisk;InitCost;OptimalRisk;OptimalCost;#Configs;RiskDist;CostDist;MonetaryTradeoff\n");
		return bw;
	}

	private static String tasksPerLane(HashMap<Integer, Integer> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, Integer> e : map.entrySet())
			sb.append(e.getKey() + "=" + e.getValue() + " // ");
		sb.delete(sb.length() - 4, sb.length());
		return sb.toString();
	}

	private static void addSolutionOrderly(ArrayList<Solution> thisRunSolutions, Solution sol) {
		int i = 0;
		while (i < thisRunSolutions.size()) {
			if (thisRunSolutions.get(i).getRisk() < sol.getRisk())
				break;
			i++;
		}
		thisRunSolutions.add(i, sol);
	}

	private static boolean dominates(Solution sol1, Solution sol2) {
		return (sol1.getCostOfMessages() <= sol2.getCostOfMessages() && sol1.getRisk() < sol2.getRisk())
				|| (sol1.getCostOfMessages() < sol2.getCostOfMessages()
						&& sol1.getRisk() <= sol2.getRisk());
	}
}
