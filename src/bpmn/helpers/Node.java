package helpers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import bpmn.TCategory;

public class Node implements Cloneable {

	private String id;

	private String type;

	private String name;

	private List<Node> incoming;

	private List<Node> outgoing;

	private BigDecimal reliability;
	private double businessValue;
	private double riskValue;
	private double energyCost;
	private String process;
	private boolean mutable;

	private BigDecimal probability;

	private TCategory categoryValue;

	private int condition;

	private HashMap<String, BigDecimal> reliabilities;
	private HashMap<String, Double> costs;

	public Node(String id, String type) {
		this.id = id;
		this.type = type;
		incoming = new ArrayList<>();
		outgoing = new ArrayList<>();
		reliabilities = new HashMap<>();
		costs = new HashMap<>();
		probability = new BigDecimal(-1);

	}

	public void addIncomingNode(Node n) {
		incoming.add(n);
	}

	public void addOutgoingNode(Node n) {
		outgoing.add(n);
	}

	public boolean incomingContains(Node n) {
		for (Node inc : incoming)
			if (inc.getId().equals(n.getId()))
				return true;
		return false;
	}

	public boolean outgoingContains(Node n) {
		for (Node out : outgoing)
			if (out.getId().equals(n.getId()))
				return true;
		return false;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Node> getIncoming() {
		return incoming;
	}

	public List<Node> getOutgoing() {
		return outgoing;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIncomingSize() {
		return incoming.size();
	}

	public int getOutgoingSize() {
		return outgoing.size();
	}

	public void removeFromIncoming(Node node) {
		incoming.remove(node);
	}

	public void removeFromOutgoing(Node node) {
		outgoing.remove(node);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getReliability() {
		if (reliability.doubleValue() >= 0)
			return reliability;
		else return new BigDecimal(1);
	}

	public TCategory getCategoryValue() {
		return categoryValue;
	}

	public double getBusinessValue() {
		return businessValue;
	}

	public double getRiskValue() {
		return riskValue;
	}

	public double getEnergyCost() {
		return energyCost;
	}

	public void setReliability(BigDecimal reliability) {
		this.reliability = reliability;
	}

	public void setBusinessValue(double businessValue) {
		this.businessValue = businessValue;
	}

	public void setRiskValue(double riskValue) {
		this.riskValue = riskValue;
	}

	public void setEnergyCost(double energyCost) {
		this.energyCost = energyCost;

	}

	public void setCategoryValue(TCategory categoryValue2) {
		this.categoryValue = categoryValue2;
	}

	public BigDecimal getProbability() {
		return probability;
	}

	public void setProbability(BigDecimal probability) {
		this.probability = probability;
	}

	public int getCondition() {
		return condition;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public void setNodeProcessRandomly() {
		List<Map.Entry<String, BigDecimal>> allowed = reliabilities.entrySet().stream()
                .filter(e -> e.getKey().compareTo(process) != 0)
                .collect(Collectors.toList());

        Random r = new Random();
        process = allowed.get(r.nextInt(allowed.size())).getKey();
        reliability = getReliabilityForProcess(process);
	}

	public boolean isOnSameProcess(Node node) {
		return java.util.Objects.equals(process, node.process);
	}

	public Node getFirstIncomingNode() {
		return incoming.get(0);
	}

	public Node getFirstOutgoingNode() {
		if (outgoing.isEmpty())
			System.out.println("error");
		return outgoing.get(0);
	}

	public void setReliabilities(HashMap<String, BigDecimal> reliabilities) {
		this.reliabilities = reliabilities;
	}

	public BigDecimal getReliabilityForProcess(String process) {
			return reliabilities.get(process);
	}

	public double getCostForProcess(String process) {
		return costs.get(process);
}

	public void setProcessAndReliability(String process, BigDecimal reliability) {
		if (reliabilities.containsKey(process))
			reliabilities.replace(process, reliability);
		else
			reliabilities.put(process, reliability);
	}

	public void setProcessAndCosts(String process, double cost) {
		if (costs.containsKey(process))
			costs.replace(process, cost);
		else
			costs.put(process, cost);
	}

	public void setCosts(HashMap<String,Double> costs) {
		this.costs = costs;
	}

	public boolean isMutable() {
		return mutable;
	}

	public void setMutable(boolean mutable) {
		this.mutable = mutable;
	}

	@Override
	public String toString() {
		if (name != null)
			return getName();
		return id;
	}

	@Override
	public Node clone() throws CloneNotSupportedException {
		Node node = (Node) super.clone();

		node.id = id;
		node.type = type;
		node.name = name;
		node.process = process;
		node.incoming = new ArrayList<>();
		node.outgoing = new ArrayList<>();
		node.reliability = reliability;
		node.businessValue = businessValue;
		node.riskValue = riskValue;
		node.categoryValue = categoryValue;
		node.probability = probability;
		node.condition = condition;
		node.reliabilities = reliabilities;
		node.costs = costs;

		return node;
	}

	public void removeAllIncoming() {
		incoming = new ArrayList<>();
	}

	public void removeAllOutgoing() {
		outgoing = new ArrayList<>();
	}

	public HashMap<String, BigDecimal> getReliabilities() {
		return reliabilities;
	}

	public HashMap<String, Double> getCosts() {
		return costs;
	}

	public String findPattern() {
		String oldPattern;
		String patternType = null;
		if (this.getOutgoingSize() == 1
				&& (this.getFirstOutgoingNode().getIncomingSize() == 1
				|| (!(this.getFirstOutgoingNode().getType().contains("Gateway") || this.getFirstOutgoingNode().getType().contains("TReceiveTask")) && this.getFirstOutgoingNode().getIncomingSize() > 1)
				)
				&& !(this.getType().contains("Gateway") && this.getIncomingSize() > 1)
				&& !this.getFirstOutgoingNode().outgoingContains(this)
				&& this.getCategoryValue().getId().equals(this.getFirstOutgoingNode().getCategoryValue().getId())) {
			patternType  = "Sequential";
		}
		if ((this.getType().equals("TParallelGateway") || this.getType().equals("TEventBasedGateway") || this.getType().equals("TInclusiveGateway"))
				&& this.getOutgoingSize() > 1) {
			patternType = "Parallel";
		}
		if (this.getType().equals("TExclusiveGateway") && this.getOutgoingSize() > 1) {
			patternType = "Conditional";
		}
		if (this.getOutgoingSize() == 1 && this.getIncomingSize() > 1 && !this.getType().contains("Gateway") && !this.getType().contains("Receive")) {
			oldPattern = patternType;
			patternType = "Loop";
			for (Node in : this.getIncoming()) {
				if (!this.getCategoryValue().getId().equals(in.getCategoryValue().getId()) || !this.getFirstOutgoingNode().getType().equals("TExclusiveGateway")) {
					patternType = oldPattern;
					break;
				}
			}

		}
		if (this.getType().equals("TComplexGateway") && this.getOutgoingSize() > 1 && this.getIncomingSize() <= 1) {
			patternType = "FaultTolerant";
		}
		return patternType;
	}

	public Branch createBranchFromElement() {
		String patternType = this.findPattern();

		List<Node> branches = new ArrayList<Node>();
		for (Node branch : this.getOutgoing()) {

			branches.add(branch);
		}
		Branch branch = new Branch(this, patternType, branches);
		return branch;
	}

	public double getComponentValue(String componentToCompute) {
		switch (componentToCompute) {
			case "Rely":
				return this.getReliability().doubleValue();
			case "BV":
				return this.getBusinessValue();
			case "Risk":
				return this.getRiskValue();
			default:
				return -1.0;
		}
	}

	public boolean containsTaskType (String type) {
		for (Node in : this.incoming) {
			if (in.getType().contains(type)) {
				return true;
			}
		}
		return false;
	}
}
