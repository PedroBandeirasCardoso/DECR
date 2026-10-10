package helpers;

public class Comms {

	private double rely;
	private double cost;
	private String participantRef;

	public Comms() {

	}

	public void setReliability (double rely) {
		this.rely = rely;
	}

	public void setCost (double cost) {
		this.cost = cost;
	}

	public void setParticipantRef (String pRef) {
		this.participantRef = pRef;
	}

	public double getReliability () {
		return this.rely;
	}

	public double getCost () {
		return this.cost;
	}

	public String getParticipantRef () {
		return this.participantRef;
	}
}
