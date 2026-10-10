package helpers;

import java.util.List;

public class Branch {

	private Node element;
	private String pattern;
	private List<Node> branches;

	public Branch(Node firstElement, String patternType, List<Node> branches) {
		this.element = firstElement;
		this.pattern = patternType;
		this.branches = branches;
	}

	public Node getBranch() {
		return this.element;
	}

	public String getPattern() {
		return this.pattern;
	}

	public List<Node> getBranches() {
		return this.branches;
	}

	public boolean canBeReduced() {
		if (this.pattern.equals("Sequential") && this.element.getOutgoingSize() == 1
				&& this.element.getFirstOutgoingNode().getIncomingSize() == 1) {
			return true;
		}
		if (this.pattern.equals("Parallel") && (this.element.getType().equals("TParallelGateway") || this.element.getType().equals("TEventBasedGateway") || this.element.getType().equals("TInclusiveGateway"))
				&& (this.element.getOutgoingSize() >= 1 && this.element.getIncomingSize() <= 1)) {
			return viablePatternEnd(this.element);
		}
		if (this.pattern.equals("Conditional") && this.element.getType().equals("TExclusiveGateway") && this.element.getOutgoingSize() >= 1 && this.element.getIncomingSize() <= 1) {
			return viablePatternEnd(this.element);
		}
		if (this.pattern.equals("Loop") && this.element.getOutgoingSize() == 1 && this.element.getIncomingSize() > 1
				&& this.element.getFirstOutgoingNode().outgoingContains(this.element)) {
			return true;
		}
		if (this.pattern.equals("FaultTolerant") && this.element.getType().equals("TComplexGateway") && this.element.getOutgoingSize() >= 1 && this.element.getIncomingSize() <= 1) {
			return viablePatternEnd(this.element);
		}
		return false;
	}

	public boolean viablePatternEnd(Node element) {
		Node endGateway = null;
		for (Node out : this.element.getOutgoing()) {
			if (out.getOutgoingSize() == 1 && element.getCategoryValue().getId().equals(out.getCategoryValue().getId())) {
				if (out.getFirstOutgoingNode().getType().contains("Gateway")) {
					if (endGateway == null) {
						endGateway = out;
					}
					else {
						if (!endGateway.equals(out) || !endGateway.getCategoryValue().getId().equals(element.getCategoryValue().getId())) {
							return false;
						}
					}
				}
				else if (!out.getFirstOutgoingNode().getType().equals("TEndEvent") || element.getCategoryValue().getId().equals(out.getCategoryValue().getId())) {
					return false;
				}
			}
		}
		return true;
	}

	public void changePattern(String pattern) {
		this.pattern = pattern;

	}
}
