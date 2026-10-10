package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import jakarta.xml.bind.JAXBElement;

import javax.xml.namespace.QName;

import bpmn.TActivity;
import bpmn.TCategory;
import bpmn.TCollaboration;
import bpmn.TComplexGateway;
import bpmn.TFlowElement;
import bpmn.TFlowNode;
import bpmn.TMessageFlow;
import bpmn.TProcess;
import bpmn.TSequenceFlow;
import bpmn.TStandardLoopCharacteristics;
import helpers.Branch;
import helpers.Comms;
import helpers.Node;
import helpers.Pair;
import helpers.Solution;

public class AlgorithmService {

	private String algorithm;

	private boolean fromGeneratedFile;

	private int strategy;
	private double temperature;
	private double coolingRate;
	private double rtb;

	private int stablelizingIteration = 1;
	private int totalIterations;
	private double maxCostExchangingMessages;
	private double maxRisk;

	public static Random rng = new Random();

	private JAXBElement<?> jaxb;
	private List<TProcess> processes;
	private List<TCollaboration> collaborations;
	private Map<String, TFlowNode> flowNodes;
	private Map<String, TSequenceFlow> sequenceFlows;

	private List<TCategory> categories;

	private HashMap<String, Node> allNodes;

	private HashMap<String, Node> aCopy;

	private ArrayList<Node> algorithmNodes;

	private HashMap<String,ArrayList<String>> processNodes;

	private List<TCategory> originalCategories;

	private ArrayList<Solution> bestSolutions;

	private double initialRisk;

	private double initialCost;

	private int initialCommsNumber;

	public AlgorithmService(String diagram_file, String configuration_file, boolean fromGeneratedFile) {
		this.fromGeneratedFile = fromGeneratedFile;

		initializeAlgorithm();
		readConfigurationFile(configuration_file);

		if (fromGeneratedFile)
			createGraphFromGeneratedFile(diagram_file);
		else {
			loadFile(diagram_file);
			createGraph();

		}

		preProcessDiagram();
	}

	private void initializeAlgorithm() {
		allNodes = new HashMap<>();
		flowNodes = new HashMap<>();
		sequenceFlows = new HashMap<>();
		algorithmNodes = new ArrayList<>();
	}

	private void createGraphFromGeneratedFile(String diagram_file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(diagram_file));
			String line = null;
			String[] words = null;

			processes = new ArrayList<TProcess>();
			TProcess process = new TProcess();
			categories = new ArrayList<TCategory>();
			Node n;

			ArrayList<Comms> comms = new ArrayList<Comms>();
			Comms comm = new Comms();

			int nProcesses = Integer.parseInt(br.readLine());
			for (int j = 0; j < nProcesses; j++) {
				line = br.readLine();
				words = line.split(",");
				process = new TProcess();
				process.setId(words[0]);
				String[] outgoings = words[1].split("=");
				if (outgoings.length > 1) {
					outgoings = outgoings[1].split(";");
					comms = new ArrayList<Comms>();
					for (String out : outgoings) {
						comm = new Comms();
						String[] o = out.split("-");
						comm.setReliability(Double.parseDouble(o[0]));
						comm.setCost(Double.parseDouble(o[1]));
						comm.setParticipantRef(o[2]);
						comms.add(comm);
					}
					process.setOutgoing(comms);
				}
				String[] incomings = words[2].split("=");
				if (incomings.length > 1) {
					incomings = incomings[1].split(";");
					comms = new ArrayList<Comms>();
					for (String in : incomings) {
						comm = new Comms();
						String[] i = in.split("-");
						comm.setReliability(Double.parseDouble(i[0]));
						comm.setCost(Double.parseDouble(i[1]));
						comm.setParticipantRef(i[2]);
						comms.add(comm);
					}
					process.setIncoming(comms);
				}
				processes.add(process);
			}

			int nCategories = Integer.parseInt(br.readLine());
			for (int i = 0; i < nCategories; i++) {
				line = br.readLine();
				words = line.split(",");
				TCategory c = new TCategory();
				c.setId(words[0]);
				c.setName(words[1]);
				if (!words[2].equals("null")) {
					for (TCategory cat : categories) {
						if (cat.getId().equals(words[2])) {
							c.setSuperCategory(cat);
							cat.getSubCategories().add(c);
						}
						break;
					}
				}
				c.setComponentValue("Rely", Double.parseDouble(words[3]));
				c.setComponentValue("BV", Double.parseDouble(words[4]));
				c.setComponentValue("Risk", Double.parseDouble(words[5]));

				categories.add(c);
			}

			originalCategories = cloneCategories(categories);

			processes.get(0).setCategories(categories);

			int nNodes = Integer.parseInt(br.readLine());
			for (int j = 0; j < nNodes; j++) {
				line = br.readLine();
				words = line.split(",");
				n = new Node(words[0], words[1]);
				n.setName(words[2]);
				for (TCategory cat2 : categories) {
					if (cat2.getId().equals(words[3])) {
						n.setCategoryValue(cat2);
						break;
					}
				}
				n.setProcess(words[4]);
				if (!words[5].equals("null"))
					n.setProbability(new BigDecimal(Double.parseDouble(words[6])));
				n.setCondition(Integer.parseInt(words[6]));

				String[] outgoing = words[7].split("=");
				if (outgoing.length > 1) {
					outgoing = outgoing[1].split("/");
					for (String out : outgoing) {
						n.addOutgoingNode(allNodes.get(out));
						allNodes.get(out).addIncomingNode(n);
					}
				}

				n.setMutable(Boolean.valueOf(words[8]));

				String[] reliabilities_string = words[9].split("=");
				HashMap<String, BigDecimal> reliabilities = new HashMap<String, BigDecimal>();
				reliabilities_string = reliabilities_string[1].split("/");
				for (String reliability : reliabilities_string) {
					String[] splited = reliability.split("-");
					reliabilities.put(splited[0], new BigDecimal(Double.parseDouble(splited[1])));
				}

				n.setReliabilities(reliabilities);

				n.setBusinessValue(Double.parseDouble(words[10]));
				n.setRiskValue(Double.parseDouble(words[11]));

				String[] costs_string = words[12].split("=");
				HashMap<String, Double> costs = new HashMap<String, Double>();
				costs_string = costs_string[1].split("/");
				for (String cost : costs_string) {
					String[] splited = cost.split("-");
					costs.put(splited[0], Double.parseDouble(splited[1]));
				}
				n.setCosts(costs);

				n.setReliability(n.getReliabilityForProcess(n.getProcess()));
				n.setEnergyCost(n.getCostForProcess(n.getProcess()));

				allNodes.put(words[0], n);
			}

			br.close();
		} catch (IOException e) {
			System.out.println("Problem reading diagram file: " + diagram_file);
			e.printStackTrace();
		}
	}

	private void loadFile(String diagram) {
		try {
			jaxb = DiagramService.XMLUnmarshal(diagram);
			processes = DiagramService.getProcesses(jaxb);
			categories = DiagramService.getCategories(jaxb);
			collaborations = DiagramService.getCollaborations(jaxb);
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + diagram);
		}
	}

	private void createGraph() {
		fillCategoryInfo();

		ArrayList<Node> starterNodes = new ArrayList<>();
		processNodes = new HashMap<String, ArrayList<String>>();

		for (TProcess process : processes) {
			ArrayList<String> nodes = new ArrayList<String>();
			List<JAXBElement<? extends TFlowElement>> diagramElements = process.getFlowElement();
			for (JAXBElement<? extends TFlowElement> elem : diagramElements) {
				TFlowElement tfe = elem.getValue();
				String id = tfe.getId();
				if (TFlowNode.class.isInstance(tfe)) {
					TFlowNode tfn = (TFlowNode) tfe;
					flowNodes.put(id, tfn);
					nodes.add(tfn.getId());
					if (tfn.getIncoming().isEmpty()) {
						Node newStarter = new Node(id, tfn.getClass().getSimpleName());
						newStarter.setProcess(process.getId());
						fillNodeExtensionInfo(newStarter, tfn);
						starterNodes.add(newStarter);
					}
				} else if (TSequenceFlow.class.isInstance(tfe)) {
					TSequenceFlow tsf = (TSequenceFlow) tfe;
					sequenceFlows.put(id, tsf);
				}
			}
			processNodes.put(process.getId(), nodes);
		}

		for (Node node : starterNodes)
			addNeighbourNodes(node, null);

		for (TCollaboration collaboration : collaborations) {
			List<TMessageFlow> msgFlows = collaboration.getMessageFlow();
			for (TMessageFlow msgFlow : msgFlows) {
				QName sourceRef = msgFlow.getSourceRef();
				QName targetRef = msgFlow.getTargetRef();
				Node source = allNodes.get(sourceRef.toString());
				Node target = allNodes.get(targetRef.toString());
				if (source != null && target != null) {
					source.addOutgoingNode(target);
					target.addIncomingNode(source);
					source.setType("TSendTask");
					target.setType("TReceiveTask");
				}
			}
		}
	}

	private void addNeighbourNodes(Node node, Node previous) {

		if (previous != null && !node.incomingContains(previous)) {
			node.addIncomingNode(previous);
		}

		if (!allNodes.containsKey(node.getId()))
			allNodes.put(node.getId(), node);

		TFlowNode tfn = flowNodes.get(node.getId());

		for (QName qName : tfn.getOutgoing()) {
			TSequenceFlow tsf = sequenceFlows.get(qName.getLocalPart());
			TFlowNode tfnNext = (TFlowNode) tsf.getTargetRef();
			Node n = allNodes.get(tfnNext.getId());
			if (n == null) {
				n = new Node(tfnNext.getId(), tfnNext.getClass().getSimpleName());
				for (String p : processNodes.keySet()) {
					if (processNodes.get(p).contains(n.getId())) {
						n.setProcess(p);
						break;
					}
				}
				fillNodeExtensionInfo(n, tfnNext);
			}
			if (!node.outgoingContains(n)) {
				node.addOutgoingNode(n);
				addNeighbourNodes(n, node);
			}
		}
	}

	private void fillNodeExtensionInfo(Node newNode, TFlowNode tfn) {

		newNode.setName(tfn.getName());

		String reliabilityValuesString = DiagramService.getParameterByName(tfn, DiagramService.RELIABILITYVALUE);
		if (!reliabilityValuesString.equals("-1"))
			reliabilityValuesString = reliabilityValuesString.substring(0, reliabilityValuesString.length()-1);
		String businessValuesString = DiagramService.getParameterByName(tfn, DiagramService.BUSINESSVALUE);
		String riskValuesString = DiagramService.getParameterByName(tfn, DiagramService.RISKVALUE);
		String energyCostString = DiagramService.getParameterByName(tfn, DiagramService.COSTVALUE);
		if (!energyCostString.equals("-1"))
			energyCostString = energyCostString.substring(0, energyCostString.length()-1);
		String mutable = DiagramService.getParameterByName(tfn, DiagramService.MUTABLE);

		newNode.setMutable(Boolean.valueOf(mutable));

		TCategory categoryValue = null;
		if(!tfn.getCategoryValueRef().isEmpty()) {
			categoryValue = categories.get(getCategoryIndexByName(tfn.getCategoryValueRef().get(tfn.getCategoryValueRef().size()-1)));
		}
		else {
			categoryValue = categories.get(0);
		}

		HashMap<String,BigDecimal> reliabilityValues = new HashMap<String, BigDecimal>();
		if (reliabilityValuesString.equals("-1")) {
			for (TProcess p : processes) {
				reliabilityValues.put(p.getId(), new BigDecimal(1.0));
			}
		}
		else {
			for (String reliesP : reliabilityValuesString.split(";")) {
				reliabilityValues.put(reliesP.split("-")[0], new BigDecimal(reliesP.split("-")[1]));
			}
		}

		HashMap<String,Double> energyCosts = new HashMap<String, Double>();
		if (energyCostString.equals("-1")) {
			for (TProcess p : processes) {
				energyCosts.put(p.getId(), 0.0);
			}
		}
		else {
			for (String costsP : energyCostString.split(";")) {
				energyCosts.put(costsP.split("-")[0], Double.parseDouble(costsP.split("-")[1]));
			}
		}

		businessValuesString = businessValuesString.replace(",", ".");
		riskValuesString = riskValuesString.replace(",", ".");

		if (!reliabilityValues.isEmpty())
			newNode.setReliabilities(reliabilityValues);

		if (newNode.isMutable()) {
			for (TProcess p : processes) {
				if (!newNode.getReliabilities().containsKey(p.getId()))
					newNode.setProcessAndReliability(p.getId(), new BigDecimal(1.0));
			}
		}

		if (businessValuesString.equals("") || businessValuesString.equals("-1"))
			newNode.setBusinessValue(0);
		else
			newNode.setBusinessValue(Double.parseDouble(businessValuesString));

		if (riskValuesString.equals("") || riskValuesString.equals("-1"))
			newNode.setRiskValue(-1);
		else
			newNode.setRiskValue(Double.parseDouble(riskValuesString));

		if (!energyCosts.isEmpty())
			newNode.setCosts(energyCosts);

		if (newNode.isMutable()) {
			for (TProcess p : processes) {
				if (!newNode.getCosts().containsKey(p.getId()))
					newNode.setProcessAndCosts(p.getId(), 0);
			}
		}

		newNode.setReliability(newNode.getReliabilityForProcess(newNode.getProcess()));
		newNode.setEnergyCost(newNode.getCostForProcess(newNode.getProcess()));

		newNode.setCategoryValue(categoryValue);

		for (Map.Entry<String, TSequenceFlow> entry : sequenceFlows.entrySet()) {
			TSequenceFlow tsf = entry.getValue();
			TFlowNode tfnNext = (TFlowNode) tsf.getTargetRef();
			if (tfnNext.getId().equals(newNode.getId())) {
				newNode.setProbability(
						new BigDecimal(Double.parseDouble(DiagramService.getParameterByName(tfnNext, DiagramService.PROBABILITY))));
				break;
			}
		}

		if (newNode.getType().equals("TComplexGateway")) {
			TComplexGateway tcg = (TComplexGateway) tfn;
			if (tcg.getActivationCondition() != null) {
				int condition = Integer.parseInt((String) tcg.getActivationCondition().getContent().get(0));
				newNode.setCondition(condition);
			}
		}

		if (TActivity.class.isInstance(tfn)) {
			TActivity ta = (TActivity) tfn;
			if (ta.getLoopCharacteristics() != null) {
				TStandardLoopCharacteristics tslc = (TStandardLoopCharacteristics) ta.getLoopCharacteristics()
						.getValue();
				int loopCondition = tslc.getLoopMaximum().intValue();
				newNode.setReliability(new BigDecimal(Math.pow(newNode.getReliability().doubleValue(), loopCondition)));
			}
		}

		if (newNode.getType().equals("TReceiveTask")
				&& DiagramService.getParameterByName(tfn, DiagramService.RELIABILITYVALUE).equals("-1"))
			newNode.setReliability(new BigDecimal(1));

		if (newNode.getType().equals("TEventBasedGateway"))
			newNode.setType("TParallelGateway");

		if (newNode.getType().equals("TParallelGateway")
				&& DiagramService.getParameterByName(tfn, DiagramService.RELIABILITYVALUE).equals("-1"))
			newNode.setReliability(new BigDecimal(1));
	}

	private void fillCategoryInfo() {
		if (categories.size() == 0 || !categories.get(0).getId().equals("rootCategory")) {
			TCategory rootCategory = new TCategory();
			rootCategory.setId("rootCategory");
			rootCategory.setName("rootCategory");
			rootCategory.setComponentValue("Rely", processes.get(0).getComponent("Rely"));
			rootCategory.setComponentValue("BV", processes.get(0).getComponent("BV"));
			rootCategory.setComponentValue("Risk", processes.get(0).getComponent("Risk"));
			categories.add(0, rootCategory);
		}
		else {
			categories.get(0).setComponentValue("Rely", processes.get(0).getComponent("Rely"));
			categories.get(0).setComponentValue("BV", processes.get(0).getComponent("BV"));
			categories.get(0).setComponentValue("Risk", processes.get(0).getComponent("Risk"));
		}
		processes.get(0).setCategories(categories);
		for (TCategory category : categories) {
			for (TCategory category2 : categories) {
				if (category2.getId().equals(category.getCategoryValueRef()) && !category2.getSubCategories().contains(category)) {
					category2.getSubCategories().add(category);
					category.setSuperCategory(category2);
					break;
				}
			}
		}
	}

	private int getCategoryIndexByName(QName cv) {
		for (TCategory category : categories) {
			if (!category.getCategoryValue().isEmpty() && category.getCategoryValue().get(0).getId().equals(cv.getLocalPart())) {
				return categories.indexOf(category);
			}
		}
		return -1;

	}

	private void readConfigurationFile(String configuration_file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(configuration_file));
			algorithm = br.readLine();
			if (algorithm.equals("SA")) {
				strategy = Integer.parseInt(br.readLine());
				temperature = Double.parseDouble(br.readLine());
				coolingRate = Double.parseDouble(br.readLine());
				rtb = Double.parseDouble(br.readLine());
			}

			br.close();
		} catch (IOException e) {
			System.out.println("Error reading realiabilities.");
			e.printStackTrace();
		}
	}

	private void preProcessDiagram() {
		ArrayList<Node> toRemove;
		for (Node node : allNodes.values()) {
			toRemove = new ArrayList<Node>();
			if (node.getReliabilities().size() > 1)
				algorithmNodes.add(node);
			if (node.getType().contains("Send") && node.getOutgoingSize() > 1) {
				for (Node out : node.getOutgoing()) {
					if (out.getType().contains("Receive") && out.getIncomingSize() > 1) {
						toRemove.add(out);
						out.removeFromIncoming(node);
					}
				}
				for (Node remove : toRemove) {
					node.removeFromOutgoing(remove);
				}
			}
		}

		for (Node node : allNodes.values()) {
			if (node.getType().contains("Send")) {
				node.setMutable(true);
				if (node.getOutgoingSize() == 1) {
					node.setType("nop");
				}
				else {
					for (TProcess p : processes) {
						node.setProcessAndReliability(p.getId(), new BigDecimal(1.0));
						node.setProcessAndCosts(p.getId(), 0.0);
					}
					node.setReliability(new BigDecimal(1));
					node.setEnergyCost(0);
					node.setType("TParallelGateway");
					algorithmNodes.add(node);
				}
			}
			if (node.getType().contains("Receive")) {
				node.setMutable(true);
				if(node.getIncomingSize() == 1) {
					node.setType("nop");
				}
				else {
					for (TProcess p : processes) {
						node.setProcessAndReliability(p.getId(), new BigDecimal(1.0));
						node.setProcessAndCosts(p.getId(), 0.0);
					}
					node.setReliability(new BigDecimal(1));
					node.setEnergyCost(0);
					node.setType("TParallelGateway");
					algorithmNodes.add(node);
				}
			}
		}

		toRemove = new ArrayList<Node>();

		for (Node node : allNodes.values()) {
			if (node.getType().contains("nop")
					&& node.getIncomingSize() == 1
					&& node.getOutgoingSize() == 1) {
				toRemove.add(node);

				if (!node.getFirstIncomingNode().getType().contains("Exclusive")) {
					if (node.getFirstIncomingNode().getProbability().doubleValue() == -1) {
						node.getFirstIncomingNode().setProbability(node.getProbability());
					}
				}
				else {
					if (node.getFirstOutgoingNode().getProbability().doubleValue() == -1) {
						node.getFirstOutgoingNode().setProbability(node.getProbability());
					}
				}

	            node.getFirstIncomingNode().addOutgoingNode(node.getFirstOutgoingNode());
	            node.getFirstIncomingNode().removeFromOutgoing(node);

	            node.getFirstOutgoingNode().addIncomingNode(node.getFirstIncomingNode());
	            node.getFirstOutgoingNode().removeFromIncoming(node);

	            node.removeFromIncoming(node.getFirstIncomingNode());
				node.removeFromOutgoing(node.getFirstOutgoingNode());
			}
		}

		for (Node remove : toRemove) {
			allNodes.remove(remove.getId());
		}

		aCopy = cloneNodes(allNodes);
	}

	private Solution reduceDiagram(String riskComponent) {

		double costOfMessagesExchanged = 0.0;
		HashMap<String, Node> nodesCopy = cloneNodes(allNodes);
		graphCommsModifier();
		int numComs = numComs();
		HashMap<String, Node> solGraph = cloneNodes(allNodes);
		double processRisk = computeRisk(processes.get(0), riskComponent);
		if (allNodes.values().size() != 1)
			System.out.println("erro");
		else {
			for (Node last: allNodes.values())
				costOfMessagesExchanged = last.getEnergyCost();

		}

		HashMap<String, ArrayList<ArrayList<String>>> nodes = new HashMap<String, ArrayList<ArrayList<String>>>();
		HashMap<String,Double> cats = new HashMap<String, Double>();
		Map<String, ArrayList<String>> perProcessNodes = new HashMap<String, ArrayList<String>>();

		for (TProcess p : processes) {
			perProcessNodes.put(p.getId(), new ArrayList<>());
		}

		for (Node n : solGraph.values()) {
			perProcessNodes.get(n.getProcess()).add(n.getName());
		}

		for (TProcess p : processes) {
			nodes.computeIfAbsent(p.getId(), t -> new ArrayList<>())
	           .add(perProcessNodes.get(p.getId()));
		}

		for (TCategory cat : processes.get(0).getCategories().get(0).getSubCategories()) {
			cats.put(cat.getId(),cat.getComponent("Risk"));
		}

		allNodes = cloneNodes(nodesCopy);

		Solution s = new Solution(nodes, processRisk, costOfMessagesExchanged, numComs, cats);
		return s;

	}

	private Solution mutateAndReduce() {

		return reduceDiagram("Risk");
	}

	private void mutate(String nodeName, String p) {
		Node node;
		if (algorithmNodes.size() > 0) {
			node = allNodes.get(nodeName);

			if (!node.getProcess().equals(p)) {
				if (!fromGeneratedFile) {
					processes = DiagramService.getProcesses(jaxb);
					categories = DiagramService.getCategories(jaxb);
					collaborations = DiagramService.getCollaborations(jaxb);

					fillCategoryInfo();
				}
				else {

					categories = cloneCategories(originalCategories);

					processes.get(0).setCategories(categories);
	    			processes.get(0).setComponentValue("Risk", -1);

				}

				node.setProcess(p);

				node.setReliability(node.getReliabilityForProcess(node.getProcess()));
				node.setEnergyCost(node.getCostForProcess(node.getProcess()));

			}
			else {
				node.setReliability(node.getReliabilityForProcess(node.getProcess()));
				node.setEnergyCost(node.getCostForProcess(node.getProcess()));
			}

		}
	}

	private void graphCommsModifier() {
		Map<Node, ArrayList<Node>> remove = new HashMap<Node,ArrayList<Node>>();
		Map<Node, ArrayList<Node>> add = new HashMap<Node,ArrayList<Node>>();

		ArrayList<Node> removeFromNode = new ArrayList<>();
		ArrayList<Node> addToNode = new ArrayList<>();

		ArrayList<Node> addToGraph = new ArrayList<>();

		int optionsNumber;
		BigDecimal totalProb = new BigDecimal(0);

		for (Node n : allNodes.values()) {
			for (Node out : n.getOutgoing()) {
				if (!n.getProcess().equals(out.getProcess())) {
						Node sendTask = new Node("SendTask: " + n.getId() + " -> " + out.getId(), "TSendTask");
						sendTask.setName("SendTask: " + n.toString() + " -> " + out.toString());
						Node receiveTask = new Node("ReceiveTask: " + n.getId() + " -> " + out.getId(),
						"TReceiveTask");
						receiveTask.setName("ReceiveTask: " + n.toString() + " -> " + out.toString());
						sendTask.setProcess(n.getProcess());
						receiveTask.setProcess(out.getProcess());
						sendTask.setCategoryValue(n.getCategoryValue());
						receiveTask.setCategoryValue(out.getCategoryValue());

						for (TProcess p : processes) {
							if (p.getId().equals(sendTask.getProcess())) {
								for (Comms comm : p.getOutgoing()) {
									if (comm.getParticipantRef().equals(receiveTask.getProcess())) {
										sendTask.setReliability(new BigDecimal(comm.getReliability()));
										sendTask.setProcessAndReliability(sendTask.getProcess(), new BigDecimal(comm.getReliability()));
										sendTask.setEnergyCost(comm.getCost());
										sendTask.setProcessAndCosts(sendTask.getProcess(), comm.getCost());
										break;
									}
								}
							}
						}

						for (TProcess p : processes) {
							if (p.getId().equals(receiveTask.getProcess())) {
								for (Comms comm : p.getIncoming()) {
									if (comm.getParticipantRef().equals(sendTask.getProcess())) {
										receiveTask.setReliability(new BigDecimal(comm.getReliability()));
										receiveTask.setProcessAndReliability(receiveTask.getProcess(), new BigDecimal(comm.getReliability()));
										receiveTask.setEnergyCost(comm.getCost());
										receiveTask.setProcessAndCosts(receiveTask.getProcess(), comm.getCost());
										break;
									}
								}
							}
						}

						sendTask.setProbability(out.getProbability());

						sendTask.setBusinessValue(n.getBusinessValue());
						receiveTask.setBusinessValue(out.getBusinessValue());

						removeFromNode.add(out);
						addToNode.add(sendTask);
						remove.put(n, removeFromNode);
						add.put(n, addToNode);

						sendTask.addIncomingNode(n);
						sendTask.addOutgoingNode(receiveTask);
						receiveTask.addIncomingNode(sendTask);
						receiveTask.addOutgoingNode(out);
						out.removeFromIncoming(n);
						out.addIncomingNode(receiveTask);

						addToGraph.add(sendTask);
						addToGraph.add(receiveTask);
				}
			}

			for (Node node :remove.keySet()) {
				for (Node n2 : remove.get(node)) {
					node.removeFromOutgoing(n2);
				}
			}
			for (Node node :add.keySet()) {
				for (Node n2 : add.get(node)) {
					n.addOutgoingNode(n2);
				}
			}

			remove.clear();
			add.clear();

			removeFromNode.clear();
			addToNode.clear();

			optionsNumber = 0;
			totalProb = new BigDecimal(0);
			if (n.getType().contains("Exclusive")) {
				for (Node o: allNodes.get(n.getId()).getOutgoing()) {
					if (!o.getType().contains("Exclusive")) {
						if (o.getProbability().doubleValue() > 0) {
							totalProb = totalProb.add(o.getProbability());
						}
						else
							optionsNumber ++;
					}
				}

				for (Node o: allNodes.get(n.getId()).getOutgoing()) {
					if (!o.getType().contains("Exclusive")) {
						if (o.getProbability().doubleValue() < 0)
							o.setProbability(new BigDecimal(new BigDecimal(1).subtract(totalProb).doubleValue()).divide(new BigDecimal(optionsNumber)));
					}
				}
			}

		}

		for (Node node : addToGraph) {
			allNodes.put(node.getId(), node);
		}
	}

	public ArrayList<Solution> runAlgorithm() {

		ArrayList<Solution> bestSolutions = null;

		maxCostExchangingMessages = calculateMaxCost();

		if (!fromGeneratedFile) {
			processes = DiagramService.getProcesses(jaxb);
			categories = DiagramService.getCategories(jaxb);
			collaborations = DiagramService.getCollaborations(jaxb);

			fillCategoryInfo();
		}
		else {

			categories = cloneCategories(originalCategories);

			processes.get(0).setCategories(categories);
			processes.get(0).setComponentValue("Risk", -1);

		}

		Solution initialSolution = reduceDiagram("Risk");

		if (algorithm.equals("SA")) {
			try {
				bestSolutions = runSA(initialSolution);
			} catch (IOException e) {

				e.printStackTrace();
			}
			}

		return bestSolutions;
	}

	private ArrayList<Solution> runSA(Solution currentSolution) throws IOException {

		int numberIterations = 1;
		Solution newSolution = null;
		boolean dominated;
		bestSolutions = new ArrayList<Solution>();
		bestSolutions.add(currentSolution);

        initialRisk = currentSolution.getRisk();
        initialCost = currentSolution.getCostOfMessages();
        initialCommsNumber = currentSolution.getNumberCommunications();

        int noNewSols = 0;
        double sigma = 1 - coolingRate;

        int randomSolution;

        int nodeIndex;

        Iterator<Solution> sol;

        int graphCount;
        Map<String, List<String>> graph;

		while (temperature > 0.000001) {

			if(jaxb != null) {
    			processes = DiagramService.getProcesses(jaxb);
    			categories = DiagramService.getCategories(jaxb);
    			collaborations = DiagramService.getCollaborations(jaxb);

    			fillCategoryInfo();
    		}
    		else {
    			categories = cloneCategories(originalCategories);

    			processes.get(0).setCategories(categories);
    			processes.get(0).setComponentValue("Risk", -1);

    		}

			if (noNewSols == rtb) {
				randomSolution = rng.nextInt(bestSolutions.size());
				currentSolution = bestSolutions.get(randomSolution);
				noNewSols = 0;

			}

			algorithmNodes = new ArrayList<Node> ();

			for (Node node : allNodes.values()) {
				if (node.getReliabilities().size() > 1)
					algorithmNodes.add(node);
			}
			nodeIndex = rng.nextInt(algorithmNodes.size());
			algorithmNodes.get(nodeIndex).setNodeProcessRandomly();

			for (Node mutable : algorithmNodes) {
				mutate(mutable.getId(), mutable.getProcess());
			}

			newSolution = mutateAndReduce();
			dominated = false;

			if (dominates(newSolution, currentSolution)) {

			}

			sol = bestSolutions.iterator();
			while (sol.hasNext()) {
				Solution s = sol.next();
				if (!s.equals(newSolution)) {
					if (dominates(s, newSolution)) {
						dominated = true;
						break;
					}
					if (dominates(newSolution, s))
						sol.remove();
				}
				else {
					dominated = true;

					graphCount = newSolution.getNodes().values().iterator().next().size();

					for (int i = 0; i < graphCount; i++) {

						graph = new HashMap<String, List<String>>();
				        for (TProcess p : processes) {
				            graph.put(p.getId(), newSolution.getNodes().get(p.getId()).get(i));
				        }

				        if (!graphExists(s.getNodes(), graph)) {
				            for (TProcess p : processes) {
				                s.getNodes().computeIfAbsent(p.getId(), t -> new ArrayList<>())
				                    .add(new ArrayList<>(graph.get(p.getId())));
				            }
				        }
					}
					break;
				}
			}

			noNewSols++;

			if (dominated) {

				if (!currentSolution.equals(newSolution) && acceptanceProbability(currentSolution, newSolution, temperature) > Math.random()) {

			        currentSolution = newSolution;

				}

			}
			else {
				bestSolutions.add(newSolution);
				stablelizingIteration = numberIterations;

				currentSolution = newSolution;

			}

			temperature *= sigma;
			numberIterations++;
		}

		totalIterations	= numberIterations;

		return bestSolutions;
	}

	public boolean graphExists(
	        Map<String, ArrayList<ArrayList<String>>> map,
	        Map<String, List<String>> graph
	) {

	    int graphCount = map.values().iterator().next().size();

	    for (int i = 0; i < graphCount; i++) {
	        boolean same = true;

	        for (TProcess p : processes) {
	            if (!map.get(p.getId()).get(i).equals(graph.get(p.getId()))) {
	                same = false;
	                break;
	            }
	        }

	        if (same) return true;
	    }
	    return false;
	}

	public static List<Pair<String, Integer>> getAllPairs(ArrayList<Node> algorithmNodes2, HashSet<Integer> lanes2) {
		List<Pair<String, Integer>> result = new ArrayList<Pair<String, Integer>>();

        for (Integer yi : lanes2) {
            for (Node xi : algorithmNodes2) {
                result.add(new Pair<String, Integer>(xi.getId(), yi));
            }
        }

        return result;
    }

    public static List<List<Pair<String, Integer>>> getCombinations(List<Pair<String, Integer>> pairs, int combinationSize) {
    	List<List<Pair<String, Integer>>> result = new ArrayList<>();
        generateCombinations(pairs, combinationSize, 0, new ArrayList<Pair<String, Integer>>(), new ArrayList<String>(),result);
        return result;
    }

    private static void generateCombinations(List<Pair<String, Integer>> pairs, int combinationSize, int startIndex,
    		List<Pair<String, Integer>> currentCombination, List<String> usedNode, List<List<Pair<String, Integer>>> result) {

        if (currentCombination.size() == combinationSize) {
            result.add(new ArrayList<Pair<String, Integer>>(currentCombination));
            return;
        }

        for (int i = startIndex; i < pairs.size(); i++) {
        	if (!usedNode.contains(pairs.get(i).getFirst())) {
        		currentCombination.add(pairs.get(i));
        		usedNode.add(pairs.get(i).getFirst());
	            generateCombinations(pairs, combinationSize, i + 1, currentCombination, usedNode, result);
	            currentCombination.remove(currentCombination.size() - 1);
	            usedNode.remove(pairs.get(i).getFirst());
        	}
        }
    }

	public ArrayList<Solution> getBestSolutions () {
		return bestSolutions;
	}

	private boolean dominates(Solution sol1, Solution sol2) {
		return (sol1.getCostOfMessages() <= sol2.getCostOfMessages() && sol1.getRisk() < sol2.getRisk())
				|| (sol1.getCostOfMessages() < sol2.getCostOfMessages()	&& sol1.getRisk() <= sol2.getRisk());
	}

	private List<TCategory> cloneCategories(List<TCategory> categories2) {
		List<TCategory> categoriesCopy = new ArrayList<TCategory>();
		TCategory category;

		for (TCategory ogCategory : categories2) {
			category = new TCategory();
			category.setId(ogCategory.getId());
			category.setName(ogCategory.getName());
			category.setSuperCategory(ogCategory.getSuperCategory());
			if(!ogCategory.getSubCategories().isEmpty())
				category.setSubCategories(cloneCategories(cloneCategories(ogCategory.getSubCategories())));
			category.setComponentValue("Rely", ogCategory.getComponent("Rely"));
			category.setComponentValue("BV", ogCategory.getComponent("BV"));
			category.setComponentValue("Risk", ogCategory.getComponent("Risk"));

			categoriesCopy.add(category);
		}

		return categoriesCopy;
	}

	private HashMap<String, Node> cloneNodes(HashMap<String, Node> theNodes) {
		if (this.getcategoryRisk("root") == -1)
			System.out.println("erro");

		HashMap<String, Node> nodesCopy = new HashMap<>();
		for (Node node : theNodes.values()) {
			try {
				nodesCopy.put(node.getId(), node.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println("Something went wrong while cloning the nodes.");
				e.printStackTrace();
			}
		}

		for (Node node : nodesCopy.values()) {
			Node original = theNodes.get(node.getId());
			for (Node incoming : original.getIncoming()) {
				node.addIncomingNode(nodesCopy.get(incoming.getId()));
			}
			for (Node outgoing : original.getOutgoing()) {
				node.addOutgoingNode(nodesCopy.get(outgoing.getId()));
			}
		}

		return nodesCopy;
	}

	public double acceptanceProbability(Solution s1, Solution s2, double temperature) {
		switch (strategy) {
		case 0:

			double s2diff = ((s2.getRisk() - s1.getRisk())/maxRisk) + ((s2.getCostOfMessages() - s1.getCostOfMessages())/maxCostExchangingMessages);
			if (s2diff <= 0)
				return 1;
			else
				return Math.exp(-s2diff*1000/temperature);
		case 1:
			return Math.min(1, (Math.exp(-((s2.getRisk() - s1.getRisk())) / temperature) *
					Math.exp(-((s2.getCostOfMessages() - s1.getCostOfMessages())) / temperature)));
		}
		return 1;
	}

	private double calculateMaxCost() {
		double cost = 0;
		for (Node n : allNodes.values()) {
			cost+=n.getCostForProcess((String) n.getCosts().keySet().toArray()[n.getCosts().keySet().size()-1]);
			if (n.getReliabilities().size() > 1) {
				cost+=processes.get(processes.size() - 1).getOutgoing().get(processes.get(processes.size() - 1).getOutgoing().size() - 1).getCost();
				cost+=processes.get(processes.size() - 1).getIncoming().get(processes.get(processes.size() - 1).getIncoming().size() - 1).getCost();
			}
		}

		return cost;
	}

	private double calculateWorstRisk(HashMap<String, Node> elements) {
		double worstRisk = 0;
		for (Node n : aCopy.values()) {
			worstRisk = Math.max(worstRisk, n.getBusinessValue());
		}
		for (TCategory c : categories) {
			worstRisk = Math.max(worstRisk, c.getComponent("BV"));
		}

		return worstRisk;
	}

	public double getMaxRisk () {
		return maxRisk;
	}

	public double getMaxCost () {
		return maxCostExchangingMessages;
	}

	public String complexity() {
		BigInteger comp = new BigInteger("1");
		for (Node node : allNodes.values())
			comp = comp.multiply(new BigInteger("" + node.getReliabilities().size()));

		return comp.toString();
	}

	public HashMap<String, Integer> tasksPerLane() {
		HashMap<String, Integer> hm = new HashMap<>();
		for (Node node : allNodes.values()){

			if (hm.containsKey(node.getProcess()))
				hm.put(node.getProcess(), hm.get(node.getProcess()) + 1);
			else
				hm.put(node.getProcess(), 1);
		}
		return hm;
	}

	public HashMap<String, Integer> tasksPerLane(HashMap<String, Node> map) {
		HashMap<String, Integer> hm = new HashMap<>();
		for (Node node : map.values()) {

			if (hm.containsKey(node.getProcess()))
				hm.put(node.getProcess(), hm.get(node.getProcess()) + 1);
			else
				hm.put(node.getProcess(), 1);
		}
		return hm;
	}

	public int numGateways() {
		int gate = 0;
		for (Node node : allNodes.values())
			if (node.getType().contains("Gateway"))
				gate++;

		return gate;
	}

	public int numGatewaysFT() {
		int gate = 0;
		for (Node node : allNodes.values())
			if (node.getType().contains("ComplexGateway"))
				gate++;

		return gate;
	}

	public int numComs() {
		int comm = 0;
		for (Node node : allNodes.values())
			if (node.getType().contains("Send") || node.getType().contains("Receive"))
				comm++;
		return comm;
	}

	public void changeComsReliability(double reliabilityValue) {
		for (Node node : aCopy.values())
			if (node.getType().contains("Receive")) {
				allNodes.get(node.getId()).setReliability(new BigDecimal(reliabilityValue));
			}

	}

	public int stabilizingIteration() {
		return stablelizingIteration;
	}

	public int totalIterations() {
		return totalIterations;
	}

	public Solution initialValue() {

		HashMap<String, ArrayList<ArrayList<String>>> nodes = new HashMap<String, ArrayList<ArrayList<String>>>();
		HashMap<String,Double> cats = new HashMap<String, Double>();
		Map<String, ArrayList<String>> perProcessNodes = new HashMap<String, ArrayList<String>>();

		for (TProcess p : processes) {
			perProcessNodes.put(p.getId(), new ArrayList<>());
		}

		for (Node n : aCopy.values()) {
			perProcessNodes.get(n.getProcess()).add(n.getName());
		}

		for (TProcess p : processes) {
			nodes.computeIfAbsent(p.getId(), t -> new ArrayList<>())
	           .add(perProcessNodes.get(p.getId()));
		}

		for (TCategory cat : processes.get(0).getCategories().get(0).getSubCategories()) {
			cats.put(cat.getId(),cat.getComponent("Risk"));
		}

		Solution s = new Solution(nodes, initialRisk, initialCost, initialCommsNumber, cats);
		return s;
	}
	
	public Solution initialValueV2() {

		HashMap<String, ArrayList<ArrayList<String>>> nodes = new HashMap<String, ArrayList<ArrayList<String>>>();
		HashMap<String,Double> cats = new HashMap<String, Double>();
		Map<String, ArrayList<String>> perProcessNodes = new HashMap<String, ArrayList<String>>();

		for (TProcess p : processes) {
			perProcessNodes.put(p.getId(), new ArrayList<>());
		}

		for (Node n : aCopy.values()) {
			perProcessNodes.get(n.getProcess()).add(n.getName());
		}

		for (TProcess p : processes) {
			nodes.computeIfAbsent(p.getId(), t -> new ArrayList<>())
	           .add(perProcessNodes.get(p.getId()));
		}

		for (TCategory cat : processes.get(0).getCategories().get(0).getSubCategories()) {
			cats.put(cat.getId(),cat.getComponent("Risk"));
		}

		Solution s = reduceDiagram("Risk");
		return s;
	}

	private List<SortedSet<Integer>> getCombinations(int size, int kValue) {
		List<SortedSet<Integer>> combinations = new ArrayList<>();
	    int[] elements = new int[size];
	    for (int i = 0; i < size; i++) {
	        elements[i] = i;
	    }

	    int total = 1 << size;
	    for (int mask = 0; mask < total; mask++) {
	        SortedSet<Integer> subset = new TreeSet<>();
	        for (int bit = 0; bit < size; bit++) {
	            if ((mask & (1 << bit)) != 0) {
	                subset.add(elements[bit]);
	            }
	        }
	        if (subset.size() >= kValue) {
	            combinations.add(subset);
	        }
	    }
	    return combinations;
	}

	private BigDecimal getCombinationsReliability(List<SortedSet<Integer>> comb, List<Node> nodes) {
		BigDecimal value = new BigDecimal(0);
		BigDecimal count;
		for (SortedSet<Integer> c : comb) {
			count = new BigDecimal(1);
			for (int i = 0; i < nodes.size(); i++) {
				BigDecimal reliability = nodes.get(i).getReliability();
				if (c.contains(i))
					count = count.multiply(reliability);
				else
					count = count.multiply(new BigDecimal(1).subtract(reliability));
			}
			value = value.add(count);
		}
		return value;
	}

	public double computeRisk(TProcess p, String riskComponent) {
		TCategory rootCategory = p.getRootCategory();
		reduceCategory(rootCategory, riskComponent);

		return rootCategory.getComponent(riskComponent);
	}

	public void reduceCategory(TCategory c, String componentToCompute) {

		String initialComponentToCompute = null;
		Node lastNode = null;
		HashMap<String, Node> categoryElements = c.getElements(allNodes);

		if (c.getComponent(componentToCompute) != -1.0) {

			reduceCategoryToOneElement(c);
			categoryElements = c.getElements(allNodes);
			lastNode = categoryElements.values().iterator().next();
			lastNode.setCategoryValue(c.getSuperCategory());

		}
		else {
			if (componentToCompute.equals("Risk") && c.getComponent("Rely") != -1.0 && c.getComponent("BV") != -1.0) {
				reduceCategoryToOneElement(c);
				categoryElements = c.getElements(allNodes);
				categoryElements.values().iterator().next().setCategoryValue(c.getSuperCategory());
				calculateRisk(c, categoryElements.values().iterator().next());
			}
			else {
				if (componentToCompute.equals("Risk") && c.getComponent("Rely") != -1.0 && c.getComponent("BV") == -1.0) {
					componentToCompute = "BV";
					initialComponentToCompute = "Risk";
				}
				if (componentToCompute.equals("Risk") && c.getComponent("Rely") == -1.0 && c.getComponent("BV") != -1.0) {
					componentToCompute = "Rely";
					initialComponentToCompute = "Risk";
				}

				for (TCategory subCategory : c.getSubCategories()) {
					reduceCategory(subCategory, componentToCompute);
				}

				if (c.getId().equals("rootCategory") && maxRisk == 0.0)
					maxRisk = calculateWorstRisk(c.getElements(allNodes));

				categoryElements = c.getElements(allNodes);

				Node firstElement = null;

				for (Node element : categoryElements.values()) {

					if (element.getIncomingSize() == 0
							|| !element.getCategoryValue().getId().equals(element.getFirstIncomingNode().getCategoryValue().getId()) ) {
						firstElement = element;
					}

					if (firstElement != null)
						break;
				}

				if (firstElement == null)
					System.out.println(c.getId() + ": Categoria estranha!");

				Branch subProcess = firstElement.createBranchFromElement();

				reduceSubProcess(subProcess, componentToCompute);
				categoryElements = c.getElements(allNodes);
				lastNode = categoryElements.values().iterator().next();
				lastNode.setName(c.getName());
				lastNode.setCategoryValue(c.getSuperCategory());

				c.setComponentValue(componentToCompute, lastNode.getComponentValue(componentToCompute));
				}
			if ("Risk".equals(initialComponentToCompute)) {
				calculateRisk(c, lastNode);
			}

		}
	}

	public void calculateRisk(TCategory c, Node lastNode) {
		double finalRisk = (1 - c.getComponent("Rely")) * c.getComponent("BV");

		c.setComponentValue("Risk", finalRisk);
		lastNode.setBusinessValue(c.getComponent("BV"));

		lastNode.setReliability(new BigDecimal(c.getComponent("Rely")));
		lastNode.setRiskValue(finalRisk);
	}

	public void reduceSubProcess(Branch subProcess, String componentToCompute) {

		Branch branch = null;

		if (subProcess.getPattern() != null) {
			if (!subProcess.canBeReduced()) {
				for (Node element : subProcess.getBranches()) {
					if (element.getCategoryValue().getId().equals(subProcess.getBranch().getCategoryValue().getId())) {
						branch = element.createBranchFromElement();
						reduceSubProcess(branch, componentToCompute);
					}
				}
			}
			reducePatternAndCompute(subProcess, componentToCompute);
		}
	}

	public void reducePatternAndCompute(Branch subProcess, String componentToCompute) {
		Node newElement = null;
		Branch newSubProcess;
		if (subProcess.getPattern().equals("Sequential")) {
			newElement = computeSequential(subProcess, componentToCompute);
			for (Node in : subProcess.getBranch().getIncoming()) {
				newElement.addIncomingNode(in);
				in.getOutgoing().remove(subProcess.getBranch());
				in.addOutgoingNode(newElement);
			}
			for (Node out : subProcess.getBranch().getFirstOutgoingNode().getOutgoing()) {
				newElement.addOutgoingNode(out);
				out.getIncoming().remove(subProcess.getBranch().getFirstOutgoingNode());
				out.addIncomingNode(newElement);
			}

			allNodes.remove(subProcess.getBranch().getId());
			allNodes.remove(subProcess.getBranch().getFirstOutgoingNode().getId());
			allNodes.put(newElement.getId(), newElement);

		}
		if (subProcess.getPattern().equals("Parallel")) {
			if (isFaultTolerant(subProcess)) {
				subProcess.changePattern("FaultTolerant");
			}
			else {
				newElement = computeParallel(subProcess, componentToCompute);
				reduceGatewayPattern(subProcess, newElement);
			}
		}
		if (subProcess.getPattern().equals("Conditional")) {
			newElement = computeConditional(subProcess, componentToCompute);
			reduceGatewayPattern(subProcess, newElement);
		}
		if (subProcess.getPattern().equals("Loop")) {
			newElement = computeLoop(subProcess, componentToCompute);
			if (subProcess.getBranch().getIncomingSize() > 0) {
				newElement.addIncomingNode(subProcess.getBranch().getFirstIncomingNode());
				subProcess.getBranch().getFirstIncomingNode().removeAllOutgoing();
				subProcess.getBranch().getFirstIncomingNode().addOutgoingNode(newElement);
			}
			if (subProcess.getBranch().getFirstOutgoingNode().getOutgoingSize() > 0) {
				newElement.addOutgoingNode(subProcess.getBranch().getFirstOutgoingNode().getFirstOutgoingNode());
				subProcess.getBranch().getFirstOutgoingNode().getFirstOutgoingNode().removeAllIncoming();
				subProcess.getBranch().getFirstOutgoingNode().getFirstOutgoingNode().addIncomingNode(newElement);
			}

			allNodes.remove(subProcess.getBranch().getId());
			allNodes.remove(subProcess.getBranch().getFirstOutgoingNode().getId());
			allNodes.put(newElement.getId(), newElement);
		}
		if (subProcess.getPattern().equals("FaultTolerant")) {
			newElement = computeFaultTolerant(subProcess, componentToCompute);
			reduceGatewayPattern(subProcess, newElement);
		}

		if(subProcess.getPattern().equals("Sequential") || subProcess.getPattern().equals("Loop")) {
			newElement.setCategoryValue(subProcess.getBranch().getCategoryValue());
			newSubProcess = newElement.createBranchFromElement();

			reduceSubProcess(newSubProcess, componentToCompute);
		}
		else {

			subProcess.changePattern(subProcess.getBranch().findPattern());
			reduceSubProcess(subProcess, componentToCompute);
		}
	}

	private boolean isFaultTolerant(Branch subProcess) {
		int gatewayCounter = 0;
		for (Node out : subProcess.getBranch().getOutgoing()) {
			if (out.getFirstOutgoingNode().getType().equals("TComplexGateway") || out.getType().equals("TComplexGateway"))
				gatewayCounter++;
		}
		if (gatewayCounter > 1) {
			return true;
		}
		else {
			return false;
		}

	}

	private Node computeFaultTolerant(Branch subProcess, String componentToCompute) {
		Node endGateway = null;
		List<Node> toRemove = new ArrayList<>();
		List<SortedSet<Integer>> combinations;
		String newID="";
		String newName="";
		double result = 0.0;
		Double energyCost = 0.0;
		for (Node out : subProcess.getBranch().getOutgoing()) {
			if (out.getType().equals("TComplexGateway"))
				endGateway = out;
			if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
				newID += out.getId()+"+";
				newName += out.getName()+"+";
				toRemove.add(out);
				endGateway = out.getFirstOutgoingNode();

				combinations = getCombinations(toRemove.size(), endGateway.getCondition());

				energyCost += out.getEnergyCost();
			}

		}
		Node element = new Node(newID.substring(0, newID.length()-1), "TTask");
		element.setName(newName.substring(0, newName.length()-1));
		element.setEnergyCost(energyCost);
		if (componentToCompute.equals("Rely")) {
			combinations = getCombinations(toRemove.size(), endGateway.getCondition());
			result = getCombinationsReliability(combinations, toRemove).doubleValue();

			element.setReliability(new BigDecimal(result));
		}
		if (componentToCompute.equals("BV")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (out.getBusinessValue() > result) {
					result = out.getBusinessValue() * out.getProbability().doubleValue();
				}
			}
			element.setBusinessValue(result);
		}
		if (componentToCompute.equals("Risk")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (out.getRiskValue() == -1)
					out.setRiskValue((1 - out.getReliability().doubleValue()) * out.getBusinessValue());
				if (out.getRiskValue() > result) {
					result = out.getRiskValue() * out.getProbability().doubleValue();
				}
			}
			element.setRiskValue(result);

		}

		return element;
	}

	private Node computeLoop(Branch subProcess, String componentToCompute) {
		String newID;
		String newName;
		Double result;

		Double energyCost = ((1 - subProcess.getBranch().getFirstOutgoingNode().getProbability().doubleValue()) * subProcess.getBranch().getEnergyCost()) / (1 - subProcess.getBranch().getFirstOutgoingNode().getProbability().doubleValue() * subProcess.getBranch().getEnergyCost());
		newID = subProcess.getBranch().getId()+subProcess.getBranch().getFirstOutgoingNode().getId();
		newName = subProcess.getBranch().getName()+subProcess.getBranch().getFirstOutgoingNode().getName();
		Node element = new Node(newID, "TTask");
		element.setName(newName);
		element.setEnergyCost(energyCost);
		if (componentToCompute.equals("Rely")) {
			result = ((1 - subProcess.getBranch().getFirstOutgoingNode().getProbability().doubleValue()) * subProcess.getBranch().getReliability().doubleValue()) / (1 - subProcess.getBranch().getFirstOutgoingNode().getProbability().doubleValue() * subProcess.getBranch().getReliability().doubleValue());

			element.setReliability(new BigDecimal(result));
		}
		if (componentToCompute.equals("BV")) {
			result = subProcess.getBranch().getBusinessValue();
			element.setBusinessValue(result);
		}
		if (componentToCompute.equals("Risk")) {
			if (subProcess.getBranch().getRiskValue() == -1)
				subProcess.getBranch().setRiskValue((1 - subProcess.getBranch().getReliability().doubleValue()) * subProcess.getBranch().getBusinessValue());
			result = subProcess.getBranch().getRiskValue();
			element.setRiskValue(result);

		}

		return element;
	}

	private Node computeConditional(Branch subProcess, String componentToCompute) {
		String newID="";
		String newName="";
		Double result = 0.0;
		Double energyCost = 0.0;
		Double totalProb = 0.0;

		for (Node out : subProcess.getBranch().getOutgoing()) {
			if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
				newID += out.getId()+"+";
				newName += out.getName()+"+";

				energyCost += out.getEnergyCost()*out.getProbability().doubleValue();
			}
		}
		Node element = new Node(newID.substring(0, newID.length()-1), "TTask");
		element.setName(newName.substring(0, newName.length()-1));
		element.setEnergyCost(energyCost);
		if (componentToCompute.equals("Rely")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					result += out.getReliability().multiply(out.getProbability()).doubleValue();
					totalProb += out.getProbability().doubleValue();
				}
			}
			if (totalProb < 1.0) {
				result += 1.0 * (1.0 - totalProb);
			}

			element.setReliability(new BigDecimal(result));
		}
		if (componentToCompute.equals("BV")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					if (out.getBusinessValue() * out.getProbability().doubleValue() > result) {
						result = out.getBusinessValue() * out.getProbability().doubleValue();
					}
				}
			}
			element.setBusinessValue(result);
		}
		if (componentToCompute.equals("Risk")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					if (out.getRiskValue() == -1)
						out.setRiskValue((1 - out.getReliability().doubleValue()) * out.getBusinessValue());
					if (out.getRiskValue()  * out.getProbability().doubleValue() > result) {
						result = out.getRiskValue() * out.getProbability().doubleValue();
					}
				}
			}
			element.setRiskValue(result);

		}

		return element;
	}

	public Node computeParallel(Branch subProcess, String componentToCompute) {
		String newID = "";
		String newName = "";
		Double result = 1.0;
		Double energyCost = 0.0;
		for (Node out : subProcess.getBranch().getOutgoing()) {
			if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
				newID += out.getId()+"+";
				newName += out.getName()+"+";

				energyCost += out.getEnergyCost();
			}
		}
		Node element = new Node(newID.substring(0, newID.length()-1), "TTask");
		element.setName(newName.substring(0, newName.length()-1));
		element.setEnergyCost(energyCost);
		if (componentToCompute.equals("Rely")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					result = new BigDecimal(result).multiply(out.getReliability()).doubleValue();
				}
			}

			element.setReliability(new BigDecimal(result));
		}
		if (componentToCompute.equals("BV")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					if (out.getBusinessValue() > result) {
						result = out.getBusinessValue();
					}
				}
			}
			element.setBusinessValue(result);
		}
		if (componentToCompute.equals("Risk")) {
			for (Node out : subProcess.getBranch().getOutgoing()) {
				if (!out.getType().equals("TEndEvent") && !out.getType().contains("Gateway")) {
					if (out.getRiskValue() == -1)
						out.setRiskValue((1 - out.getReliability().doubleValue()) * out.getBusinessValue());
					if (out.getRiskValue() > result) {
						result = out.getRiskValue();
					}
				}
			}
			element.setRiskValue(result);

		}

		return element;
	}

	public void reduceGatewayPattern(Branch subProcess, Node newElement) {
		Node endGateway = null;

		for (Node mid : subProcess.getBranch().getOutgoing()) {
			if (!mid.getType().contains("Gateway")) {

				endGateway = mid.getFirstOutgoingNode();

				allNodes.remove(mid.getId());
			}
			else {
				endGateway = mid;
			}
		}

		subProcess.getBranch().removeAllOutgoing();
		subProcess.getBranch().addOutgoingNode(newElement);
		newElement.addIncomingNode(subProcess.getBranch());

		endGateway.removeAllIncoming();
		endGateway.addIncomingNode(newElement);
		newElement.addOutgoingNode(endGateway);

		newElement.setCategoryValue(subProcess.getBranch().getCategoryValue());
		allNodes.put(newElement.getId(), newElement);
	}

	public Node computeSequential(Branch subProcess, String componentToCompute) {
		String newID;
		String newName;
		Node element;
		Double result;
		Double energyCost = 0.0;

		energyCost = subProcess.getBranch().getEnergyCost() + subProcess.getBranch().getFirstOutgoingNode().getEnergyCost();

		newID = subProcess.getBranch().getId()+"+"+subProcess.getBranch().getFirstOutgoingNode().getId();
		newName = subProcess.getBranch().getName()+"+"+subProcess.getBranch().getFirstOutgoingNode().getName();
		if (subProcess.getBranch().getFirstOutgoingNode().getOutgoingSize() > 1)
			element = new Node(newID, subProcess.getBranch().getFirstOutgoingNode().getType());
		else
			element = new Node(newID, "TTask");
		element.setName(newName);
		element.setEnergyCost(energyCost);
		element.setProbability(subProcess.getBranch().getProbability());
		if (componentToCompute.equals("Rely")) {
			result = subProcess.getBranch().getReliability().multiply(subProcess.getBranch().getFirstOutgoingNode().getReliability()).doubleValue();

			element.setReliability(new BigDecimal(result));
		}
		if (componentToCompute.equals("BV")) {
			if (subProcess.getBranch().getBusinessValue() > subProcess.getBranch().getFirstOutgoingNode().getBusinessValue()) {
				result = subProcess.getBranch().getBusinessValue();
			}
			else {
				result = subProcess.getBranch().getFirstOutgoingNode().getBusinessValue();
			}
			element.setBusinessValue(result);
		}
		if (componentToCompute.equals("Risk")) {
			if (subProcess.getBranch().getRiskValue() == -1.0)
				subProcess.getBranch().setRiskValue((1 - subProcess.getBranch().getReliability().doubleValue()) * subProcess.getBranch().getBusinessValue());
			if (subProcess.getBranch().getFirstOutgoingNode().getRiskValue() == -1.0)
				subProcess.getBranch().getFirstOutgoingNode().setRiskValue((1 - subProcess.getBranch().getFirstOutgoingNode().getReliability().doubleValue()) * subProcess.getBranch().getFirstOutgoingNode().getBusinessValue());
			if (subProcess.getBranch().getRiskValue() > subProcess.getBranch().getFirstOutgoingNode().getRiskValue()) {
				result = subProcess.getBranch().getRiskValue();
			}
			else {
				result = subProcess.getBranch().getFirstOutgoingNode().getRiskValue();
			}

			element.setRiskValue(result);
		}

		return element;
	}

	public void reduceCategoryToOneElement(TCategory category) {
		for (TCategory subCategory : category.getSubCategories()) {
			reduceCategoryToOneElement(subCategory);
			HashMap<String, Node> categoryElements = subCategory.getElements(allNodes);
			categoryElements.values().iterator().next().setCategoryValue(subCategory.getSuperCategory());
		}
		Node firstElement = null;
		Node lastElement = null;
		HashMap<String, Node> categoryElements = category.getElements(allNodes);
		for (Node element : categoryElements.values()) {
			if (element.getIncomingSize() == 0
					|| !element.getCategoryValue().equals(element.getFirstIncomingNode().getCategoryValue())) {
				firstElement = element;
			}
			if (element.getOutgoingSize() == 0 ||
					!element.getCategoryValue().equals(element.getFirstOutgoingNode().getCategoryValue())) {
				lastElement = element;
			}
			if (firstElement != null && lastElement != null)
				break;
		}

		Node newElement = new Node(category.getId(), "TTask");
		newElement.setName(category.getName());

		for (Node in:firstElement.getIncoming()) {
			if (!in.getCategoryValue().getId().equals(firstElement.getCategoryValue().getId())) {
				newElement.addIncomingNode(in);
			}

		}
		if (lastElement.getOutgoingSize() != 0) {
			lastElement.getFirstOutgoingNode().getIncoming().remove(lastElement);
			lastElement.getFirstOutgoingNode().addIncomingNode(newElement);

			newElement.addOutgoingNode(lastElement.getFirstOutgoingNode());
		}

		newElement.setBusinessValue(category.getComponent("BV"));

		newElement.setReliability(new BigDecimal(category.getComponent("Rely")));
		newElement.setRiskValue(category.getComponent("Risk"));
		newElement.setProbability(firstElement.getProbability());

		newElement.setCategoryValue(category);

		for (Node in2:firstElement.getIncoming()) {
			in2.getOutgoing().remove(firstElement);
			in2.addOutgoingNode(newElement);
		}

		for (Node categoryElement : category.getElements(allNodes).values()) {
			allNodes.remove(categoryElement.getId());

		}
		allNodes.put(newElement.getId(), newElement);
	}

	public HashMap<String, Node> getNodes() {
		HashMap<String, Node> hm = new HashMap<>();
		for (Node node : allNodes.values()){
				hm.put(node.getName(), node);
		}
		return hm;
	}

	public double getcategoryRisk(String categoryName) {
		for (TCategory c : categories)
			if (categoryName.equals(c.getName()))
				return c.getComponent("Risk");
		return 0;
	}

	public HashMap<String, String> getMutableTasksInfo() {
		HashMap<String, String> hm = new HashMap<>();
		for (Node node : allNodes.values()){
			if(node.getReliabilities().size() > 1)
				hm.put(node.getName(), node.getProcess());
		}
		return hm;
	}

	public HashMap<String, String> getMutableTasksIoTInfo() {
		HashMap<String, String> hm = new HashMap<>();
		for (Node node : allNodes.values()){
			if(node.getReliabilities().size() > 1 && !node.getProcess().equals(processes.get(0).getId()))
				hm.put(node.getName(), node.getProcess());
		}
		return hm;
	}

	public HashMap<String, String> getMutableTasksInfo(HashMap<String, Node> nodes) {
		HashMap<String, String> hm = new HashMap<>();
		for (Node node : nodes.values()){
			if(node.getReliabilities().size() > 1)
				hm.put(node.getName(), node.getProcess());
		}
		return hm;
	}

	public List<TProcess> getProcesses () {
		return processes;
	}
}
