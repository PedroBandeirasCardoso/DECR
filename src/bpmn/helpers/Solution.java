package helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	private HashMap<String,ArrayList<ArrayList<String>>> nodes;

	private double risk;

	private double costOfMessages;

	private int numberCommunications;

	private HashMap<String, Double> categories;

	public Solution(HashMap<String,ArrayList<ArrayList<String>>> nodes, double risk, double costOfMessages, int numberCommunications, HashMap<String, Double> cats) {
		super();
		this.nodes = nodes;
		this.risk = risk;
		this.costOfMessages = costOfMessages;
		this.numberCommunications = numberCommunications;
		this.categories = cats;
	}

	public HashMap<String, ArrayList<ArrayList<String>>> getNodes() {
		return nodes;
	}

	public double getRisk() {
		return risk;
	}

	public double getCostOfMessages() {
		return costOfMessages;
	}

	public int getNumberCommunications() {
		return numberCommunications;
	}

	public HashMap<String, Double> getCats() {
		return categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costOfMessages);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(risk);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		if (Double.doubleToLongBits(risk) != Double.doubleToLongBits(other.risk) || Double.doubleToLongBits(costOfMessages) != Double.doubleToLongBits(other.costOfMessages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{"+risk+","+costOfMessages+"}";
	}

}
