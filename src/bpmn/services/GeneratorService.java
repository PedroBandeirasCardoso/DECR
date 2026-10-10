package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;

import bpmn.TCategory;
import helpers.Comms;
import helpers.DoubleInterval;
import helpers.Node;
import helpers.Pair;

public class GeneratorService {

	private final String TASK_NAME = "Task_";
	private final String TASK_TYPE = "TTask";

	private final String SEND_TASK_NAME = "SendTask_";
	private final String SEND_TASK_TYPE = "TSendTask";

	private final String RECEIVE_TASK_NAME = "ReceiveTask_";
	private final String RECEIVE_TASK_TYPE = "TReceiveTask";

	private final String COLLABORATION_NAME = "Collaboration_";

	private final String PROCESS_NAME = "Process_";

	private final String PARTICIPANT_NAME = "Participant_";
	private int PARTICIPANT_ID = 1;

	private final String MESSAGE_FLOW_NAME = "MessageFlow_";
	private int MESSAGE_FLOW_ID = 1;

	private final String SEQUENCE_FLOW_NAME = "SequenceFlow_";
	private int SEQUENCE_FLOW_ID = 1;

	private final String FORMAL_EXPRESSION_NAME = "FormalExpression_";
	private int FORMAL_EXPRESSION_ID = 1;

	private final String ITEM_DEFINITION_NAME = "_ItemDefinition_";
	private int ITEM_DEFINITION_ID = 1;

	private final String EXTENSION_NAME = "doit";

	private final String[][] GATEWAYS = { { "ParallelGateway_", "TParallelGateway" },
			{ "ExclusiveGateway_", "TExclusiveGateway" }, { "ComplexGateway_", "TComplexGateway" } };

	private final int MIN_FLOWS_PER_GATEWAY = 2;
	private final int MAX_FLOWS_PER_GATEWAY = 5;
	private final int MIN_ELEMENTS_PER_FLOW = 1;

	private ArrayList<String> itemDefinitions;
	private HashMap<String, String> sequenceFlows;

	private int id;
	private int sendId;
	private int receiveId;
	private Random rng;
	private ArrayList<String> processes;
	private int nodes;
	private int precision;
	public static DecimalFormat df;
	private double categoryOpenProbability;
	private double categoryCloseProbability;

	private HashMap<String,DoubleInterval> relysPerProcess;

	private DoubleInterval categoriesBusinessValue;
	private double seqProbability;
	private HashMap<String, ArrayList<Comms>> outgoings;
	private HashMap<String, ArrayList<Comms>> incomings;
	private int categoryNumber;
	private HashMap<TCategory, String> categoriesMap;
	private TCategory rootCategory;
	private HashMap<String, Node> nodesMap;
	private int patternLevel;
	private double reliabilityProbability;
	private double businessValueProbability;
	private DoubleInterval deltaRely;
	private DoubleInterval deltaCost;
	private HashMap<String,DoubleInterval> energyCostsPerProcess;
	private boolean fixedExists;
	private double fixedIoTprobability;
	private double mutableProbability;
	private HashMap<String,Integer> nodesPerProcess;

	public GeneratorService(String configurationFilePath) {
		id = 0;
		sendId = 0;
		receiveId = 0;
		rng = new Random();
		processes = new ArrayList<String>();
		nodesMap = new LinkedHashMap<>();
		categoriesMap = new LinkedHashMap<>();
		categoryNumber = 1;
		fixedExists = false;
		nodesPerProcess = new HashMap<String, Integer>();
		relysPerProcess = new HashMap<String, DoubleInterval>();
		energyCostsPerProcess = new HashMap<String, DoubleInterval>();

		readConfigurationFile(configurationFilePath);
	}

	private void readConfigurationFile(String configurationFilePath) {
		DoubleInterval commsRely;
		DoubleInterval sendCosts;
		DoubleInterval receiveCosts;

		try {
			BufferedReader br = new BufferedReader(new FileReader(configurationFilePath));
			String[] words = null;

			energyCostsPerProcess = new HashMap<String,DoubleInterval>();
			int processesSize = Integer.parseInt(br.readLine());
			for (int i = 1; i <= processesSize; i++) {
				processes.add("Process_"+i);
			}
			nodes = Integer.parseInt(br.readLine());
			precision = Integer.parseInt(br.readLine());
			df = new DecimalFormat(generateDecimalFormatString(precision), DecimalFormatSymbols.getInstance(Locale.US));
			categoryOpenProbability = Double.parseDouble(br.readLine());
			categoryCloseProbability = Double.parseDouble(br.readLine());
			mutableProbability = Double.parseDouble(br.readLine());
			fixedIoTprobability = 1-mutableProbability;

			reliabilityProbability = 0;

			for (String p : processes) {
				words = br.readLine().split("-");
				relysPerProcess.put(p, new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1])));
			}

			businessValueProbability = 1;
			words = br.readLine().split("-");
			categoriesBusinessValue = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));
			seqProbability = Double.parseDouble(br.readLine());

			words = br.readLine().split("-");
			deltaRely = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));
			words = br.readLine().split("-");
			deltaCost = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));

			words = br.readLine().split("-");
			commsRely = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));

			outgoings = new HashMap<String, ArrayList<Comms>>();
			incomings = new HashMap<String, ArrayList<Comms>>();
			Comms out = new Comms();
			Comms in = new Comms();
			ArrayList<Comms> outs = new ArrayList<Comms>();
			ArrayList<Comms> ins = new ArrayList<Comms>();
			for (String p : processes) {

				words = br.readLine().split("-");
				sendCosts = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));

				words = br.readLine().split("-");
				receiveCosts = new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1]));

				outs = new ArrayList<Comms>();
				ins = new ArrayList<Comms>();
				for (int i=0; i < processes.size(); i++) {
					if (!p.equals(processes.get(i))) {
						out = new Comms();
						in = new Comms();

						out.setReliability(1);
						out.setCost(sendCosts.getRandomFromInterval());
						out.setParticipantRef(processes.get(i));

						in.setReliability(commsRely.getRandomFromInterval());
						in.setCost(receiveCosts.getRandomFromInterval());
						in.setParticipantRef(processes.get(i));

						outs.add(out);
						ins.add(in);
					}
				}
				outgoings.put(p, outs);
				incomings.put(p, ins);
			}

			for (String p : processes) {
				words = br.readLine().split("-");
				energyCostsPerProcess.put(p, new DoubleInterval(Double.parseDouble(words[0]), Double.parseDouble(words[1])));
			}

			br.close();
		} catch (Exception e) {
			System.err.println("Error reading generator configuration file (" + configurationFilePath + ").");
		}
	}

	private String generateDecimalFormatString(int decimalPlaces) {
		StringBuilder sb = new StringBuilder("#.");
		for (int i = 0; i < decimalPlaces; i++)
			sb.append("#");
		return sb.toString();
	}

	public void generateDiagram() {

		rootCategory = initialiseCategory("rootCategory");
		patternLevel = 0;

		for (String p : processes)
			nodesPerProcess.put(p, 0);

		generateBlock(null, nodes, true);
		categoriesMap.replaceAll((key, value) -> "closed");
	}

	private TCategory initialiseCategory(String idCategory) {
		TCategory category = new TCategory();

		category.setId(idCategory);
		category.setName(idCategory);

		category.setComponentValue("Risk", -1);
		category.setComponentValue("Rely", -1);
		category.setComponentValue("BV", -1);

		if (!idCategory.equals("rootCategory")) {
			category.setSuperCategory(getNewestOpenCategory());

			String componentRequired = getComponentRequired(getNewestOpenCategory());

			switch (componentRequired) {
				case "Risk":
					if (Math.random() <= reliabilityProbability) {
						category.setComponentValue("Rely", relysPerProcess.get(processes.get(0)).getRandomFromInterval());
						category.setName("BV");
					}
					if (Math.random() <= businessValueProbability) {
							category.setComponentValue("BV", categoriesBusinessValue.getRandomFromInterval());
							category.setName("Rely");
					}
					if (category.getComponent("Rely") == -1.0 && category.getComponent("BV") == -1.0) {
						category.setName("Risk");
					}
					break;
				case "Rely":
					if (Math.random() <= reliabilityProbability) {
						category.setComponentValue("Rely", relysPerProcess.get(processes.get(0)).getRandomFromInterval());
						category.setName("BV");
					}
					else {
						category.setName("Rely");
					}
					break;
				case "BV":
					if (Math.random() <= businessValueProbability) {
						category.setComponentValue("BV", categoriesBusinessValue.getRandomFromInterval());
						category.setName("Rely");
					}
					else {
						category.setName("BV");
					}
					break;
				default:
					category.setName("");
				}
		}
		else {
			category.setName("Risk");

		}

		categoriesMap.put(category, "open" + patternLevel);

		return category;
	}

	private void generateBlock(Node last, int availableNodes, boolean canDiverge) {
		if (availableNodes > 0) {

			nodes = availableNodes;

			if (Math.random() <= categoryOpenProbability && getNewestOpenCategory().equals(rootCategory)) {
				initialiseCategory("Category_" + categoryNumber++);

			}

			int minThresholdToCreateGateway = 2 + MIN_FLOWS_PER_GATEWAY * MIN_ELEMENTS_PER_FLOW;
			if (nodesMap.size() > 0 && Math.random() > seqProbability && availableNodes >= minThresholdToCreateGateway) {

				Pair<Node, Node> gatewayPair = generateRandomGatewayPair(last);

				if(gatewayPair.getFirst().getReliabilities().size() > 1)
					availableNodes--;
				if(gatewayPair.getSecond().getReliabilities().size() > 1)
					availableNodes--;

				nodesMap.put(gatewayPair.getFirst().getId(), gatewayPair.getFirst());

				Pair<Integer, int[]> flowsInfo = generateFlows(availableNodes, true);
				Node startOfGateway = gatewayPair.getFirst();
				Node endOfGateway = gatewayPair.getSecond();

				for (int i = 0; i < flowsInfo.getSecond().length; i++) {
					patternLevel++;

					generateBlock(startOfGateway, flowsInfo.getSecond()[i], false);
					Node lastNodeInFlow = startOfGateway.getOutgoing().get(i);

					System.out.println(Integer.valueOf(categoriesMap.get(getNewestOpenCategory()).substring(4)));

					if (Integer.valueOf(categoriesMap.get(getNewestOpenCategory()).substring(4)) == patternLevel)
						categoriesMap.replace(getNewestOpenCategory(), "closed");
					while (lastNodeInFlow.getOutgoingSize() > 0) {
						lastNodeInFlow = lastNodeInFlow.getFirstOutgoingNode();
					}
					connectNodes(lastNodeInFlow, endOfGateway);

					patternLevel--;
				}

				if (Math.random() <= categoryCloseProbability && !getNewestOpenCategory().getId().equals("rootCategory")
						&& Integer.valueOf(categoriesMap.get(getNewestOpenCategory()).substring(4)) == patternLevel)
					categoriesMap.replace(getNewestOpenCategory(), "closed");

				nodesMap.put(endOfGateway.getId(), endOfGateway);

				if (startOfGateway.getType().equals("TComplexGateway"))
					endOfGateway.setCondition(1 + rng.nextInt(startOfGateway.getOutgoingSize() - 1));

				if (availableNodes - flowsInfo.getFirst() < 0)
					System.out.println();
				generateBlock(endOfGateway, availableNodes - flowsInfo.getFirst(), canDiverge);

				if (gatewayPair.getFirst().getType().equals("TExclusiveGateway"))
					generateFlowsProbability(gatewayPair.getFirst());

				return;
			}

			Node task = generateRandomTaskNode(last);

			if(task.getReliabilities().size() > 1)
				availableNodes--;

			generateBlock(task, availableNodes, canDiverge);
		}

	}

	private Pair<Integer, int[]> generateFlows(int availableNodes, boolean reserveSome) {
		int numberFlows = MIN_FLOWS_PER_GATEWAY
				+ rng.nextInt(Math.min(MAX_FLOWS_PER_GATEWAY, availableNodes) - MIN_FLOWS_PER_GATEWAY + 1);
		int[] nodesPerFlow = new int[numberFlows];
		int total = 0;

		availableNodes -= numberFlows * MIN_ELEMENTS_PER_FLOW;

		if (reserveSome)
			availableNodes -= rng.nextInt(availableNodes + 1);

		for (int i = 0; i < nodesPerFlow.length; i++) {
			int extra = rng.nextInt(availableNodes + 1);
			nodesPerFlow[i] = MIN_ELEMENTS_PER_FLOW + extra;
			availableNodes -= extra;
			total += nodesPerFlow[i];
		}

		if (!reserveSome) {
			nodesPerFlow[nodesPerFlow.length - 1] += availableNodes;
			total += availableNodes;
		}

		return new Pair<Integer, int[]>(total, nodesPerFlow);
	}

	private void generateFlowsProbability(Node startOfGateway) {
		double distributeProbability = 1;
		for (Node outgoing : startOfGateway.getOutgoing()) {
			double prob = distributeProbability * Math.random();
			outgoing.setProbability(new BigDecimal(prob));
			distributeProbability -= prob;
		}
		startOfGateway.getFirstOutgoingNode()
				.setProbability(new BigDecimal(startOfGateway.getFirstOutgoingNode().getProbability().doubleValue() + distributeProbability));
	}

	private Node generateRandomTaskNode(Node last) {
		Node node = new Node(TASK_NAME + id++, TASK_TYPE);

		TCategory newestOpenCategory = getNewestOpenCategory();

		initializeNodeInformationRandomly(node);
		node.setCategoryValue(getNewestOpenCategory());

		if (last != null) {
			connectNodes(last, node);
			if (last.getCategoryValue().getId().equals(newestOpenCategory.getId())
					&& !newestOpenCategory.getId().equals("rootCategory")
					&& Integer.valueOf(categoriesMap.get(getNewestOpenCategory()).substring(4)) == patternLevel)
				if (Math.random() <= categoryCloseProbability)
					categoriesMap.replace(newestOpenCategory, "closed");
		}

		nodesMap.put(node.getId(), node);

		return node;
	}

	private String getComponentRequired(TCategory category) {
		switch (category.getName()) {
		case "Risk":
			if (category.getComponent("Risk") == -1.0)
				return "Risk";
		case "Rely":
			if (category.getComponent("Rely") == -1.0)
				return "Rely";
		case "BV":
			if (category.getComponent("BV") == -1.0)
				return "BV";
		default:
			return "";
		}
	}

	private TCategory getNewestOpenCategory() {
		TCategory category = null;
		for (Entry<TCategory,String> entry : categoriesMap.entrySet())
			if (entry.getValue().contains("open"))
				category = entry.getKey();
		return category;

	}

	private Pair<Node, Node> generateRandomGatewayPair(Node last) {
		int index = rng.nextInt(GATEWAYS.length);

		Node start = new Node(GATEWAYS[index][0] + id, GATEWAYS[index][1]);

		initializeNodeInformationRandomly(start);

		Node end = new Node(GATEWAYS[index][0] + (id++) + "_END", GATEWAYS[index][1]);

		start.setCategoryValue(getNewestOpenCategory());
		end.setCategoryValue(getNewestOpenCategory());

		initializeNodeInformationRandomly(end);

		connectNodes(last, start);

		return new Pair<>(start, end);
	}

	private void connectNodes(Node start, Node end) {
		if (start != null && end != null)
			if (start.getProcess().equals(end.getProcess())) {
				start.addOutgoingNode(end);
				end.addIncomingNode(start);
			} else
				makeReceive(makeSend(start, end), end);
	}

	private Node makeSend(Node start, Node end) {
		Node sendTask = new Node(SEND_TASK_NAME + sendId++, SEND_TASK_TYPE);
		sendTask.setProcess(start.getProcess());
		sendTask.setCategoryValue(start.getCategoryValue());
		for (Comms c : outgoings.get(sendTask.getProcess())) {
			if (c.getParticipantRef().equals(end.getProcess())) {
				sendTask.setReliability(new BigDecimal(c.getReliability()));
				sendTask.setEnergyCost(c.getCost());
			}
		}

		sendTask.setBusinessValue(categoriesBusinessValue.getRandomFromInterval());

		sendTask.setRiskValue(-1.0);
		HashMap<String, BigDecimal> reliabilities = new HashMap<String, BigDecimal>();
		reliabilities.put(sendTask.getProcess(), sendTask.getReliability());
		sendTask.setReliabilities(reliabilities);
		HashMap<String, Double> costs = new HashMap<String, Double>();
		costs.put(sendTask.getProcess(), sendTask.getEnergyCost());
		sendTask.setCosts(costs);
		start.addOutgoingNode(sendTask);
		sendTask.addIncomingNode(start);
		nodesMap.put(sendTask.getId(), sendTask);
		return sendTask;
	}

	private Node makeReceive(Node send, Node end) {
		Node receiveTask = new Node(RECEIVE_TASK_NAME + receiveId++, RECEIVE_TASK_TYPE);
		receiveTask.setProcess(end.getProcess());
		receiveTask.setCategoryValue(end.getCategoryValue());
		for (Comms c : incomings.get(receiveTask.getProcess())) {
			if (c.getParticipantRef().equals(send.getProcess())) {
				receiveTask.setReliability(new BigDecimal(c.getReliability()));
				receiveTask.setEnergyCost(c.getCost());
			}
		}

		receiveTask.setBusinessValue(categoriesBusinessValue.getRandomFromInterval());

		receiveTask.setRiskValue(-1.0);
		HashMap<String, BigDecimal> reliabilities = new HashMap<String, BigDecimal>();
		reliabilities.put(receiveTask.getProcess(), receiveTask.getReliability());
		receiveTask.setReliabilities(reliabilities);
		HashMap<String, Double> costs = new HashMap<String, Double>();
		costs.put(receiveTask.getProcess(), receiveTask.getEnergyCost());
		receiveTask.setCosts(costs);
		send.addOutgoingNode(receiveTask);
		receiveTask.addIncomingNode(send);
		receiveTask.addOutgoingNode(end);
		end.addIncomingNode(receiveTask);
		nodesMap.put(receiveTask.getId(), receiveTask);
		return receiveTask;
	}

	private void initializeNodeInformationRandomly(Node node) {

		node.setProcess(processes.get(rng.nextInt(processes.size())));

		if (node.getType().contains("Gateway") || (fixedExists && rng.nextDouble() > fixedIoTprobability)
				|| (nodesMap.size() == 0 && rng.nextDouble() > fixedIoTprobability)) {
			node.setMutable(true);

			node.setProcess(processes.get(0));

			fixedIoTprobability += 0.025;
		}
		else {
			if (nodesPerProcess.get(processes.get(1)) == 0) {
				node.setProcess(processes.get(1));
				nodesPerProcess.replace(processes.get(1), nodesPerProcess.get(processes.get(1))+1);
				fixedIoTprobability -= 0.025;
			}
			else {
				for (String p : nodesPerProcess.keySet()) {
					if (nodesPerProcess.get(p) == 0) {
						node.setProcess(p);
						nodesPerProcess.replace(p, nodesPerProcess.get(p)+1);
						fixedIoTprobability -= 0.025;
						break;
					}
				}
			}
		}

		fixedExists = true;
		for (String p : nodesPerProcess.keySet()) {
			if (nodesPerProcess.get(p) == 0) {
				fixedExists = false;
				break;
			}
		}

		String componentRequired = getComponentRequired(getNewestOpenCategory());

		switch (componentRequired) {
			case "Risk":
				generateRandomNodeReliabilities(node);
				node.setBusinessValue(categoriesBusinessValue.getRandomFromInterval());
				node.setRiskValue(-1.0);

				break;
			case "Rely":
				generateRandomNodeReliabilities(node);
				break;
			case "BV":
				node.setBusinessValue(categoriesBusinessValue.getRandomFromInterval());
				break;
			default:
				break;
		}
		generateRandomNodeCosts(node);
	}

	private void generateRandomNodeReliabilities(Node node) {
		HashMap<String, BigDecimal> reliabilities = new HashMap<String, BigDecimal>();
		node.setReliability(new BigDecimal(relysPerProcess.get(node.getProcess()).getRandomFromInterval()));
		if (node.isMutable()) {
			for (String p : processes) {
				if (p.equals(node.getProcess())) {
					reliabilities.put(p, node.getReliability());
				}
				else {
					reliabilities.put(p,new BigDecimal(node.getReliability().doubleValue()-deltaRely.getRandomFromInterval()));
				}

			}
		}
		else {
			reliabilities.put(node.getProcess(), node.getReliability());
		}
		node.setReliabilities(reliabilities);
	}

	private void generateRandomNodeCosts(Node node) {
		HashMap<String, Double> costs = new HashMap<String, Double>();
		node.setEnergyCost(energyCostsPerProcess.get(node.getProcess()).getRandomFromInterval());
		if (node.isMutable()) {
			for (String p : processes) {
				if (p.equals(node.getProcess())) {
					costs.put(p, node.getEnergyCost());
				}
				else {
					if (nodesMap.size() == 0)
						costs.put(p, node.getEnergyCost()+deltaCost.getMax());
					else
						costs.put(p, node.getEnergyCost()+deltaCost.getMin());
				}

			}
		}
		else {
			costs.put(node.getProcess(), node.getEnergyCost());
		}
		node.setCosts(costs);
	}

	public HashMap<String, Node> getDiagram() {
		return nodesMap;
	}

	public void saveToFile(String filename) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(processes.size() + "\n");

			StringBuilder sb3 = new StringBuilder();
			for (String p : processes) {
				sb3.append(p + ",");
				sb3.append("out=");
				for (Comms c : outgoings.get(p)) {
					sb3.append(df.format(c.getReliability()) +"-"+df.format(c.getCost())+"-"+c.getParticipantRef()+";");
				}

				sb3.setCharAt(sb3.length() - 1, ',');

				sb3.append("in=");
				for (Comms c : incomings.get(p)) {
					sb3.append(df.format(c.getReliability()) +"-"+df.format(c.getCost())+"-"+c.getParticipantRef()+";");
				}

				sb3.setCharAt(sb3.length() - 1, '\n');
			}

			bw.write(sb3.toString());

			bw.write(categoriesMap.keySet().size() + "\n");

			StringBuilder sb2 = new StringBuilder();
			for (TCategory c : categoriesMap.keySet()) {
				sb2.append(c.getId() + ",");
				sb2.append(c.getId() + ",");
				if (c.getSuperCategory() != null)
					sb2.append(c.getSuperCategory().getId() + ",");
				else
					sb2.append(null + ",");

				sb2.append(df.format(c.getComponent("Rely")) + ",");
				sb2.append(df.format(c.getComponent("BV")) + ",");
				sb2.append(df.format(c.getComponent("Risk")) + ",");

				sb2.setCharAt(sb2.length() - 1, '\n');
			}

			bw.write(sb2.toString());

			bw.write(nodesMap.values().size() + "\n");

			StringBuilder sb = new StringBuilder();
			List<Node> reverseOrderedNodes = new ArrayList<Node>(nodesMap.values());
			Collections.reverse(reverseOrderedNodes);
			for (Node n : reverseOrderedNodes) {
				sb.append(n.getId() + ",");
				sb.append(n.getType() + ",");
				sb.append(n.toString() + ",");
				if (n.getCategoryValue() == null)
					System.out.println(n.getId());
				sb.append(n.getCategoryValue().getId() + ",");
				sb.append(n.getProcess() + ",");
				sb.append(n.getProbability() + ",");
				sb.append(n.getCondition() + ",");

				sb.append("out=");
				for (Node outgoing : n.getOutgoing())
					sb.append(outgoing.getId() + "/");
				sb.setCharAt(sb.length() - 1, ',');

				sb.append(n.isMutable() + ",");

				sb.append("reliabilities=");
				for (Entry<String, BigDecimal> entry : n.getReliabilities().entrySet())
					sb.append(entry.getKey() + "-" + df.format(entry.getValue()) + "/");

				sb.setCharAt(sb.length() - 1, ',');

				sb.append(df.format(n.getBusinessValue()) + ",");
				sb.append(df.format(n.getRiskValue()) + ",");
				sb.append("costs=");
				for (Entry<String, Double> entry : n.getCosts().entrySet())
					sb.append(entry.getKey() + "-" + df.format(entry.getValue()) + "/");

				sb.setCharAt(sb.length() - 1, '\n');
			}

			bw.write(sb.toString());

			bw.close();
		} catch (IOException e) {
			System.out.println("Problem saving diagram to file.");
			e.printStackTrace();
		}

	}

	public void saveToFileAsXML(String filename) {
		try {
			itemDefinitions = new ArrayList<>();
			HashMap<String, ArrayList<String>> processes = new HashMap<>();
			HashMap<String, ArrayList<String>> collaborations = new HashMap<>();
			sequenceFlows = new HashMap<>();

			for (Node node : nodesMap.values())
				if (!node.getType().equals("TSendTask"))
					for (Node out : node.getOutgoing()) {
						String p = node.getProcess();
						if (!processes.containsKey(p))
							processes.put(p, new ArrayList<String>());
						sequenceFlows.put(node.getId() + "-" + out.getId(), SEQUENCE_FLOW_NAME + SEQUENCE_FLOW_ID);
						ArrayList<String> process = processes.get(node.getProcess());
						StringBuilder sb = new StringBuilder("<bpmn2:sequenceFlow id=\""
								+ SEQUENCE_FLOW_NAME + (SEQUENCE_FLOW_ID++) + "\" "
								+ "sourceRef=\"" + node.getId() + "\" "
								+ "targetRef=\"" + out.getId() + "\"");
						if (node.getType().equals("TExclusiveGateway")) {
							sb.append("><bpmn2:extensionElements>"
									+ "<doit:ReliabilityInformation xsi:type=\"xs:anyType\">"
									+ "<doit:probability xsi:type=\"xs:anyType\">" + out.getProbability()
									+ "</doit:probability>"
									+ "</doit:ReliabilityInformation>"
									+ "</bpmn2:extensionElements>");
							sb.append("</bpmn2:sequenceFlow>");
						} else
							sb.append(" />");
						process.add(sb.toString());
					}

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<bpmn2:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
					+ "xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" "
					+ "xmlns:doit=\"http://www.fc.ul.pt/doit\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" "
					+ "xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:ext=\"http://org.eclipse.bpmn2/ext\" "
					+ "xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" id=\"Definitions_1\" exporter=\"org.eclipse.bpmn2.modeler.core\" "
					+ "exporterVersion=\"1.4.2.Final-v20171109-1930-B1\" targetNamespace=\"http://org.eclipse.bpmn2/default/collaboration\">\r\n");

			for (Node node : nodesMap.values()) {
				String p = node.getProcess();
				ArrayList<String> process = processes.get(p);

				StringBuilder sb = formatNodeXML(node);

				if (node.getType().equals("TSendTask")) {
					Node receive = node.getFirstOutgoingNode();
					String collabKey = getCollabId(p, receive.getProcess());
					if (!collaborations.containsKey(collabKey))
						collaborations.put(collabKey, new ArrayList<String>());
					ArrayList<String> collab = collaborations.get(collabKey);
					collab.add("<bpmn2:messageFlow id=\"" + MESSAGE_FLOW_NAME + (MESSAGE_FLOW_ID++) + "\" "
							+ "sourceRef=\"" + node.getId() + "\" "
							+ "targetRef=\"" + receive.getId() + "\"/>");

					addIncomingFlows(sb, node);
				} else if (node.getType().equals("TReceiveTask")) {

					addOutgoingFlows(sb, node);
				} else {

					addIncomingFlows(sb, node);

					addOutgoingFlows(sb, node);
				}
				process.add(sb.toString() + getEndDelimiter(node));
			}

			for (String itemDef : itemDefinitions)
				bw.write(itemDef);

			for (Entry<String, ArrayList<String>> entry : collaborations.entrySet()) {

				bw.write("<bpmn2:collaboration id=\"" + COLLABORATION_NAME + entry.getKey()
						+ "\" name=\"" + COLLABORATION_NAME + entry.getKey()
						+ "\">");

				String[] participants = entry.getKey().split("_");
				bw.write("<bpmn2:participant id=\"" + PARTICIPANT_NAME + (PARTICIPANT_ID++)
						+ "\" name=\"" + PROCESS_NAME + participants[0]
						+ "\" processRef=\"" + PROCESS_NAME + participants[0]
						+ "\"/>");
				bw.write("<bpmn2:participant id=\"" + PARTICIPANT_NAME + (PARTICIPANT_ID++)
						+ "\" name=\"" + PROCESS_NAME + participants[1]
						+ "\" processRef=\"" + PROCESS_NAME + participants[1]
						+ "\"/>");

				for (String messageFlow : entry.getValue())
					bw.write(messageFlow);

				bw.write("</bpmn2:collaboration>");
			}

			for (Entry<String, ArrayList<String>> entry : processes.entrySet()) {
				bw.write("<bpmn2:process id=\"" + PROCESS_NAME + entry.getKey() + "\" "
						+ " name=\"" + PROCESS_NAME + entry.getKey() + "\" "
						+ " isExecutable=\"false\">\r\n");

				for (String elem : entry.getValue())
					bw.write(elem);

				bw.write("</bpmn2:process>");
			}
			bw.write("</bpmn2:definitions>");
			bw.close();
		} catch (IOException e) {
			System.out.println("Problem saving diagram to file.");
			e.printStackTrace();
		}
	}

	private void addIncomingFlows(StringBuilder sb, Node node) {
		for (Node in : node.getIncoming())
			sb.append("<bpmn2:incoming>" + sequenceFlows.get(in.getId() + "-" + node.getId()) + "</bpmn2:incoming>");
	}

	private void addOutgoingFlows(StringBuilder sb, Node node) {
		for (Node out : node.getOutgoing())
			sb.append("<bpmn2:outgoing>" + sequenceFlows.get(node.getId() + "-" + out.getId()) + "</bpmn2:outgoing>");
	}

	private String getCollabId(String p, String string) {

		return string + "_" + p;
	}

	private StringBuilder formatNodeXML(Node node) {
		StringBuilder sb = new StringBuilder(getStartDelimiter(node));
		sb.append("id=\"" + node.getId() + "\" ");
		sb.append("name=\"" + node.getId() + "\" ");
		if (node.getType().contains("Gateway"))
			if (node.getOutgoingSize() > 1)
				sb.append("gatewayDirection=\"Diverging\"");
			else
				sb.append("gatewayDirection=\"Converging\"");
		sb.append(">");

		if (node.getType().equals("TComplexGateway")) {
			sb.append("<bpmn2:activationCondition xsi:type=\"bpmn2:tFormalExpression\" "
					+ "id=\"" + FORMAL_EXPRESSION_NAME + (FORMAL_EXPRESSION_ID++) + "\" "
					+ "evaluatesToTypeRef=\"" + ITEM_DEFINITION_NAME + ITEM_DEFINITION_ID + "\">"
					+ node.getCondition()
					+ "</bpmn2:activationCondition>");
			itemDefinitions.add("<bpmn2:itemDefinition id=\""
					+ ITEM_DEFINITION_NAME + (ITEM_DEFINITION_ID++)
					+ "\" isCollection=\"false\" structureRef=\"xs:short\"/>");
		}

		sb.append("<bpmn2:extensionElements>");

		if (node.getReliabilities().size() > 0) {
			sb.append("<" + EXTENSION_NAME + ":ReliabilityInformation xsi:type=\"xs:anyType\">");
			sb.append("<" + EXTENSION_NAME + ":reliability xsi:type=\"xs:anyType\">");
			for (Entry<String, BigDecimal> e : node.getReliabilities().entrySet())
				sb.append(e.getKey() + "-" + e.getValue() + ",");
			sb.deleteCharAt(sb.length() - 1);
			sb.append("</" + EXTENSION_NAME + ":reliability>");
			sb.append("</" + EXTENSION_NAME + ":ReliabilityInformation>");
		}

		sb.append("<" + EXTENSION_NAME + ":LaneInformation xsi:type=\"xs:anyType\">");
		sb.append("<" + EXTENSION_NAME + ":lane xsi:type=\"xs:anyType\">" + node.getProcess()
				+ "</" + EXTENSION_NAME + ":lane>");

		if (node.getReliabilities().size() > 0) {
			sb.append("<" + EXTENSION_NAME + ":lanes xsi:type=\"xs:anyType\">");
			for (String p : node.getReliabilities().keySet())
				sb.append(p + ",");
			sb.deleteCharAt(sb.length() - 1);
			sb.append("</" + EXTENSION_NAME + ":lanes>");
		}

		sb.append("</" + EXTENSION_NAME + ":LaneInformation>");

		sb.append("</bpmn2:extensionElements>");
		return sb;
	}

	private String getEndDelimiter(Node node) {
		switch (node.getType()) {
		case "TParallelGateway":
			return "</bpmn2:parallelGateway>";
		case "TExclusiveGateway":
			return "</bpmn2:exclusiveGateway>";
		case "TComplexGateway":
			return "</bpmn2:complexGateway>";
		case "TSendTask":
			return "</bpmn2:sendTask>";
		case "TReceiveTask":
			return "</bpmn2:receiveTask>";
		default:
			if (node.getOutgoingSize() == 0)
				return "</bpmn2:endEvent>";
			if (node.getIncomingSize() == 0)
				return "</bpmn2:startEvent>";
			return "</bpmn2:task>";
		}
	}

	private String getStartDelimiter(Node node) {
		switch (node.getType()) {
		case "TParallelGateway":
			return "<bpmn2:parallelGateway ";
		case "TExclusiveGateway":
			return "<bpmn2:exclusiveGateway ";
		case "TComplexGateway":
			return "<bpmn2:complexGateway ";
		case "TSendTask":
			return "<bpmn2:sendTask ";
		case "TReceiveTask":
			return "<bpmn2:receiveTask ";
		default:
			if (node.getOutgoingSize() == 0)
				return "<bpmn2:endEvent ";
			if (node.getIncomingSize() == 0)
				return "<bpmn2:startEvent ";
			return "<bpmn2:task ";
		}
	}
}
