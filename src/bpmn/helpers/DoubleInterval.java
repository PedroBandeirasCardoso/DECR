package helpers;

import services.GeneratorService;

public class DoubleInterval {

	private double min;
	private double max;
	private double range;

	public DoubleInterval(double min, double max) {
		super();
		this.min = min;
		this.max = max;
		range = max - min;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public double getRandomFromInterval() {
		return Double.parseDouble(GeneratorService.df.format(min + range * Math.random()).replace(",", "."));
	}
}
