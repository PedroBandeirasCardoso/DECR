package helpers;

import java.util.ArrayList;
import java.util.List;

public class NodeSet extends Node {

	private List<Node> nodes;

	private String setName;

	public NodeSet(String id, String type) {
		super(id, type);
		nodes = new ArrayList<>();
	}

	public void addNode(Node n) {
		nodes.add(n);
	}

	public void removeNode(Node n) {
		nodes.remove(n);
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		setName(setName);
		this.setName = setName;
	}

	@Override
	public String toString() {
		return getSetName();
	}
}
