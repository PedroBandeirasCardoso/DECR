package client;

import services.GeneratorService;

public class MainGenerate {

	public static void main(String[] args) {
		for (int i = 1; i<= Integer.parseInt(args[2]); i++) {
			GeneratorService gs = new GeneratorService(args[0]);
			gs.generateDiagram();
			gs.saveToFile(args[1].concat("_"+i));

		}
	}
}
