package helpers;

public class IntegerInverval {

	private int min;
	private int max;
	private int range;

	public IntegerInverval(int min, int max) {
		super();
		this.min = min;
		this.max = max;
		range = max - min;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getRandomFromInterval() {
		return (int) (min + Math.random() * (range + 1));
	}
}
