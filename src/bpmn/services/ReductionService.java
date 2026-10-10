package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import helpers.Node;
import helpers.NodeSet;

public class ReductionService {

	private static final String TTASK = "TTask";

	private ArrayList<ArrayList<Node>> history;

	private int sequentialReductionNumber = 0;
	private int parallelReductionNumber = 0;
	private int contidionalReductionNumber = 0;
	private int faultTolerantReductionNumber = 0;

	public ReductionService(ArrayList<ArrayList<Node>> history) {
		this.history = history;
	}

	public boolean canBeSequentiallyReduced(Node node) {
		return node.getIncomingSize() <= 1 && node.getOutgoingSize() == 1
				&& node.getFirstOutgoingNode().getOutgoingSize() <= 1 && node.getFirstOutgoingNode().getIncomingSize() <= 1;
	}

	public int canBeParallelReduced(Node node) {
		if (node.getType().equals("TParallelGateway") || node.getType().equals("TEventBasedGateway")
				|| node.getType().equals("TInclusiveGateway")) {
			if (node.getOutgoingSize() >= 1 && node.getIncomingSize() <= 1) {

				Node endOfGateway;
				try {
					endOfGateway = node.getFirstOutgoingNode().getFirstOutgoingNode();
				} catch (IndexOutOfBoundsException e) {
					endOfGateway = null;
				}

				for (Node next : node.getOutgoing()) {
					if (next.getOutgoingSize() != 1
							|| !next.getFirstOutgoingNode().getId().equals(endOfGateway.getId()))
						return -1;
				}
				return 0;
			}

			if (node.getIncomingSize() >= 1 && node.getOutgoingSize() <= 1) {

				Node startOfGateway;
				try {
					startOfGateway = node.getFirstIncomingNode().getFirstIncomingNode();
				} catch (IndexOutOfBoundsException e) {
					startOfGateway = null;
				}

				for (Node previous : node.getIncoming()) {
					if (previous.getIncomingSize() != 1
							|| !previous.getFirstIncomingNode().getId().equals(startOfGateway.getId()))
						return -1;
				}
				return 1;
			}
		}
		return -1;
	}

	public boolean canBeConditionallyReduced(Node node) {
		if (node.getType().equals("TExclusiveGateway")) {
			if (node.getIncomingSize() > 1)
				return false;
			else {

				if (node.getOutgoingSize() <= 1)
					return false;

				Node endOfGateway;
				try {
					endOfGateway = node.getFirstOutgoingNode().getFirstOutgoingNode();
				} catch (Exception e) {
					endOfGateway = null;
				}

				for (Node next : node.getOutgoing())
					if (next.getOutgoingSize() != 1
							|| !next.getFirstOutgoingNode().getId().equals(endOfGateway.getId()))
						return false;
				return true;
			}
		}
		return false;
	}

	public boolean canBeFaulTolerantReduced(Node node) {

		if (node.getType().equals("TComplexGateway") && node.getIncomingSize() > 1) {

			int comparableSize = node.getFirstIncomingNode().getIncomingSize();

			if (comparableSize > 1)
				return false;

			Node startOfGateway;

			try {
				startOfGateway = node.getFirstIncomingNode().getFirstIncomingNode();
			} catch (Exception e) {
				startOfGateway = null;
			}

			for (Node previous : node.getIncoming()) {
				if (previous.getIncomingSize() != 1
						|| !previous.getFirstIncomingNode().getId().equals(startOfGateway.getId()))
					return false;
			}
			return true;
		}
		return false;
	}

	private void printMessage(String string, Node node, NodeSet nodeSet) {

	}

	public void sequentialReduction(Node node) {

		Node nextNode = node.getFirstOutgoingNode();
		List<Node> toRemove = new ArrayList<>();
		toRemove.add(node);
		toRemove.add(nextNode);

		NodeSet nodeSet = new NodeSet("SequentialReduction_" + sequentialReductionNumber++, TTASK);
		nodeSet.setSetName(nodeSetName(toRemove));

		nodeSet.addNode(node);
		nodeSet.addNode(nextNode);

		for (Node previous : node.getIncoming()) {
			previous.removeFromOutgoing(node);
			previous.addOutgoingNode(nodeSet);
			nodeSet.addIncomingNode(previous);
		}

		for (Node next : nextNode.getOutgoing()) {
			next.removeFromIncoming(nextNode);
			next.addIncomingNode(nodeSet);
			nodeSet.addOutgoingNode(next);
		}

		nodeSet.setReliability(node.getReliability().multiply(nextNode.getReliability()));
		nodeSet.setProbability(node.getProbability());
		createNextIteration(toRemove, nodeSet);

		printMessage("SequentialReduction: ", node, nodeSet);
	}

	public void parallelReduction(Node node, int type) {
		if (type == 0)
			parallelDivergentReduction(node);
		else
			parallelConvergentReduction(node);
	}

	private void parallelConvergentReduction(Node node) {
		List<Node> toRemove = new ArrayList<>();
		BigDecimal reliability = new BigDecimal(1);
		NodeSet nodeSet = new NodeSet("ParallelReduction_" + parallelReductionNumber++, TTASK);
		nodeSet.addNode(node);
		toRemove.add(node);
		reliability = reliability.multiply(node.getReliability());

		for (Node previous : node.getIncoming()) {
			nodeSet.addNode(previous);
			toRemove.add(previous);
			reliability = reliability.multiply(previous.getReliability());
		}

		for (Node next : node.getOutgoing()) {
			next.removeFromIncoming(node);
			next.addIncomingNode(nodeSet);
			nodeSet.addOutgoingNode(next);
		}

		node.removeAllOutgoing();

		try {
			Node begginingOfGateway = node.getFirstIncomingNode().getFirstIncomingNode();
			if (begginingOfGateway.getType().equals("TParallelGateway")) {
				nodeSet.addNode(begginingOfGateway);
				toRemove.add(begginingOfGateway);
				for (Node beforeGateway : begginingOfGateway.getIncoming()) {
					beforeGateway.removeFromOutgoing(begginingOfGateway);
					beforeGateway.addOutgoingNode(nodeSet);
					nodeSet.addIncomingNode(beforeGateway);
				}
				begginingOfGateway.removeAllIncoming();
				nodeSet.setProbability(begginingOfGateway.getProbability());
			} else {
				for (Node next : begginingOfGateway.getOutgoing())
					next.removeFromIncoming(begginingOfGateway);
				begginingOfGateway.removeAllOutgoing();
				begginingOfGateway.addOutgoingNode(nodeSet);
				nodeSet.addIncomingNode(begginingOfGateway);
			}
		} catch (Exception e) {

		}

		nodeSet.setSetName(nodeSetName(toRemove));
		nodeSet.setReliability(reliability);
		createNextIteration(toRemove, nodeSet);

		printMessage("ConvergentParallelReduction: ", node, nodeSet);
	}

	private void parallelDivergentReduction(Node node) {

		List<Node> toRemove = new ArrayList<>();
		BigDecimal reliability = new BigDecimal(1);
		NodeSet nodeSet = new NodeSet("ParallelReduction_" + parallelReductionNumber++, TTASK);
		nodeSet.addNode(node);
		toRemove.add(node);
		reliability = reliability.multiply(node.getReliability());

		for (Node next : node.getOutgoing()) {
			nodeSet.addNode(next);
			toRemove.add(next);
			Node in = null;
			List<Node> update = new ArrayList<>();
			reliability = reliability.multiply(next.getReliability());
			for (Node previous : next.getIncoming()) {
				if (!previous.getName().equals(node.getName())) {
					try {
						in = previous.clone();
					} catch (CloneNotSupportedException e) {

						e.printStackTrace();
					}
					for (Node incoming : previous.getIncoming()) {
						in.addIncomingNode(incoming);
					}
					for (Node outgoing : previous.getOutgoing()) {
						in.addOutgoingNode(outgoing);
					}
					in.removeFromOutgoing(next);
					in.addOutgoingNode(nodeSet);
					nodeSet.addIncomingNode(in);
					update.add(in);
				}
			}
			next.removeAllIncoming();
			for (Node incoming : update) {
				nodeSet.addIncomingNode(incoming);
				List<Node> updateHistory = history.get(history.size() - 1);
				for (Node oldNode : updateHistory) {
					if (oldNode.getName().equals(incoming.getName())) {
						updateHistory.remove(oldNode);
						updateHistory.add(incoming);
						break;
					}
				}
			}
		}

		for (Node previous : node.getIncoming()) {
			previous.removeFromOutgoing(node);
			previous.addOutgoingNode(nodeSet);
			nodeSet.addIncomingNode(previous);
		}

		node.removeAllIncoming();

		try {
			Node endOfGateway = node.getFirstOutgoingNode().getFirstOutgoingNode();
			if (endOfGateway.getType().equals("TParallelGateway") || endOfGateway.getType().equals("TInclusiveGateway")) {
				nodeSet.addNode(endOfGateway);
				toRemove.add(endOfGateway);
				for (Node afterGateway : endOfGateway.getOutgoing()) {
					afterGateway.removeFromIncoming(endOfGateway);
					afterGateway.addIncomingNode(nodeSet);
					nodeSet.addOutgoingNode(afterGateway);
				}
				endOfGateway.removeAllOutgoing();
			} else {
				for (Node previous : endOfGateway.getIncoming())
					previous.removeFromOutgoing(endOfGateway);
				endOfGateway.removeAllIncoming();
				endOfGateway.addIncomingNode(nodeSet);
				nodeSet.addOutgoingNode(endOfGateway);
			}
		} catch (Exception e) {

		}

		nodeSet.setProbability(node.getProbability());
		nodeSet.setSetName(nodeSetName(toRemove));
		nodeSet.setReliability(reliability);
		createNextIteration(toRemove, nodeSet);

		printMessage("DivergentParallelReduction: ", node, nodeSet);
	}

	public void conditionalReduction(Node node) {
		List<Node> toRemove = new ArrayList<>();
		BigDecimal reliability = new BigDecimal(0);

		NodeSet nodeSet = new NodeSet("ConditionalReduction_" + contidionalReductionNumber++, TTASK);

		for (Node next : node.getOutgoing()) {
			toRemove.add(next);
			nodeSet.addNode(next);
			reliability = reliability.add(next.getReliability().multiply(next.getProbability()));
		}

		toRemove.add(node);
		nodeSet.addNode(node);

		if (node.getFirstOutgoingNode().getOutgoingSize() == 1) {
			Node endOfGateway = node.getFirstOutgoingNode().getFirstOutgoingNode();

			if (endOfGateway.getType().equals("TExclusiveGateway")) {
				toRemove.add(endOfGateway);
				nodeSet.addNode(endOfGateway);

				for (Node next : endOfGateway.getOutgoing()) {
					next.removeFromIncoming(endOfGateway);
					next.addIncomingNode(nodeSet);
					nodeSet.addOutgoingNode(next);
				}
				endOfGateway.removeAllOutgoing();
			} else {
				for (Node previous : endOfGateway.getIncoming())
					previous.removeFromOutgoing(endOfGateway);
				endOfGateway.removeAllIncoming();
				endOfGateway.addIncomingNode(nodeSet);
				nodeSet.addOutgoingNode(endOfGateway);
			}
		}

		for (Node previous : node.getIncoming()) {
			previous.removeFromOutgoing(node);
			previous.addOutgoingNode(nodeSet);
			nodeSet.addIncomingNode(previous);
		}

		nodeSet.setProbability(node.getProbability());
		nodeSet.setSetName(nodeSetName(toRemove));
		nodeSet.setReliability(reliability);
		createNextIteration(toRemove, nodeSet);

		printMessage("Conditional: ", node, nodeSet);
	}

	public void faultTolerantReduction(Node node) {
		List<Node> toRemove = new ArrayList<>();

		NodeSet nodeSet = new NodeSet("FaultTolerantReduction_" + faultTolerantReductionNumber++, TTASK);

		for (Node n : node.getIncoming()) {
			toRemove.add(n);
			nodeSet.addNode(n);
		}

		List<SortedSet<Integer>> combinations = getCombinations(toRemove.size(), node.getCondition());

		double reliability = getCombinationsReliability(combinations, toRemove);

		toRemove.add(node);
		nodeSet.addNode(node);

		if (node.getFirstIncomingNode().getIncomingSize() == 1) {
			Node startOfGateway = node.getFirstIncomingNode().getFirstIncomingNode();

			toRemove.add(startOfGateway);
			nodeSet.addNode(startOfGateway);
			nodeSet.setProbability(startOfGateway.getProbability());
			if (startOfGateway.getIncomingSize() == 1) {
				Node beforeStart = startOfGateway.getFirstIncomingNode();
				beforeStart.removeFromOutgoing(startOfGateway);
				beforeStart.addOutgoingNode(nodeSet);
				startOfGateway.removeFromIncoming(beforeStart);
			}
		}

		for (Node next : node.getOutgoing()) {
			next.removeFromIncoming(node);
			next.addIncomingNode(nodeSet);
			nodeSet.addOutgoingNode(next);
		}

		nodeSet.setSetName(nodeSetName(toRemove));
		nodeSet.setReliability(new BigDecimal(reliability));
		createNextIteration(toRemove, nodeSet);

		printMessage("F-T: ", node, nodeSet);
	}

	private String nodeSetName(List<Node> nodes) {
		StringBuilder sb = new StringBuilder("(");
		for (Node node : nodes)
			sb.append(node.toString() + " + ");

		sb.delete(sb.length() - 3, sb.length());
		sb.append(")");
		return sb.toString();
	}

	private void createNextIteration(List<Node> toRemove, Node toAdd) {
		ArrayList<Node> iteration = history.get(history.size() - 1);
		for (Node node : toRemove)
			iteration.remove(node);
		iteration.add(toAdd);
	}

	private List<SortedSet<Integer>> getCombinations(int size, int kValue) {
		int[] possiveis = new int[size];
		for (int i = 0; i < possiveis.length; i++) {
			possiveis[i] = i;
		}

		List<SortedSet<Integer>> allCombList = new ArrayList<>();
		for (int nstatus : possiveis)
			allCombList.add(new TreeSet<Integer>(Arrays.asList(nstatus)));

		for (int nivel = 1; nivel < possiveis.length; nivel++) {
			List<SortedSet<Integer>> statusAntes = new ArrayList<>(allCombList);
			for (Set<Integer> antes : statusAntes) {
				SortedSet<Integer> novo = new TreeSet<>(antes);
				novo.add(possiveis[nivel]);
				if (!allCombList.contains(novo))
					allCombList.add(novo);
			}
		}

		Collections.sort(allCombList, new Comparator<SortedSet<Integer>>() {
			@Override
			public int compare(SortedSet<Integer> o1, SortedSet<Integer> o2) {
				int sizeComp = o1.size() - o2.size();
				if (sizeComp == 0) {
					Iterator<Integer> o1iIterator = o1.iterator();
					Iterator<Integer> o2iIterator = o2.iterator();
					while (sizeComp == 0 && o1iIterator.hasNext()) {
						sizeComp = o1iIterator.next().compareTo(o2iIterator.next());
					}
				}
				return sizeComp;
			}
		});

		ArrayList<SortedSet<Integer>> lixo = new ArrayList<>();
		for (SortedSet<Integer> comb : allCombList)
			if (comb.size() < kValue)
				lixo.add(comb);

		for (SortedSet<Integer> l : lixo)
			allCombList.remove(l);

		return allCombList;
	}

	private double getCombinationsReliability(List<SortedSet<Integer>> comb, List<Node> nodes) {
		double value = 0;
		double count;
		for (SortedSet<Integer> c : comb) {
			count = 1;
			for (int i = 0; i < nodes.size(); i++) {
				double reliability = nodes.get(i).getReliability().doubleValue();
				if (c.contains(i))
					count *= reliability;
				else
					count *= (1 - reliability);
			}
			value += count;
		}
		return value;
	}
}
