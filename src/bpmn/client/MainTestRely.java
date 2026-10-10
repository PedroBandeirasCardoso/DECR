package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import helpers.Node;
import helpers.Solution;
import services.AlgorithmService;

public class MainTestRely {

	public static void main(String[] args) throws IOException {

		AlgorithmService as = new AlgorithmService(args[0], args[1], Boolean.parseBoolean(args[2]));

		String graphType = args[3];

		List<String[]> relyAndRisk = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(args[4]));
		BufferedWriter bw = new BufferedWriter(new FileWriter(args[5]));

		String line = null;
		String[] fields = null;

		Node node = null;

		Solution s = null;

		double riskValue = 0;

		if (graphType.equals("2D")) {

			String nodeID = null;
			BigDecimal initialRely = new BigDecimal(0);
			BigDecimal maxRely = new BigDecimal(0);
			BigDecimal intervalRely = new BigDecimal(0);

			line = br.readLine();

			fields = line.split(";");

			nodeID = fields[0];
			initialRely = new BigDecimal(fields[1]);
			maxRely = new BigDecimal(fields[2]);
			intervalRely = new BigDecimal(fields[3]);

			String[] header = {nodeID + " Rely", "Category 1 Risk", "Category 2 Risk", "Category 3 Risk", "Process Risk"};

			relyAndRisk.add(header);

			if (!nodeID.equals("comms")) {
				for (Node n : as.getNodes().values()) {
					if (n.getId().equals(nodeID)) {
						node = n;
						break;
					}
				}

				node.setReliability(initialRely);
			}
			else {
				as.changeComsReliability(initialRely.doubleValue());
			}

			while (initialRely.doubleValue() <= maxRely.doubleValue()) {
				s = as.initialValue();
				riskValue = s.getRisk();
				String[] record = {initialRely.toString(),String.valueOf(as.getcategoryRisk("Category 1")),String.valueOf(as.getcategoryRisk("Category 2")*0.7),String.valueOf(as.getcategoryRisk("Category 3")),String.format("%.6f",riskValue)};
				relyAndRisk.add(record);

				as = new AlgorithmService(args[0], args[1], Boolean.parseBoolean(args[2]));

				initialRely = initialRely.add(intervalRely);

				if (!nodeID.equals("comms")) {

					for (Node n : as.getNodes().values()) {
						if (n.getId().equals(nodeID)) {
							node = n;
							break;
						}
					}

					node.setReliability(initialRely);
				}
				else {
					as.changeComsReliability(initialRely.doubleValue());
				}
			}
			for (String[] relyRisk : relyAndRisk) {
				bw.write(relyRisk[0].replace(".",",")+";"+relyRisk[1].replace(".",",")+";"+relyRisk[2].replace(".",",")+";"+relyRisk[3].replace(".",",")+";"+relyRisk[4].replace(".",",")+"\n");
			}
		}
		else {

			String nodeID = null;
			BigDecimal initialRely = new BigDecimal(0);
			BigDecimal maxRely = new BigDecimal(0);
			BigDecimal intervalRely = new BigDecimal(0);

			String nodeID2 = null;
			BigDecimal initialRely2 = new BigDecimal(0);
			BigDecimal maxRely2 = new BigDecimal(0);
			BigDecimal intervalRely2 = new BigDecimal(0);

			line = br.readLine();

			fields = line.split(";");

			nodeID = fields[0];
			initialRely = new BigDecimal(fields[1]);
			maxRely = new BigDecimal(fields[2]);
			intervalRely = new BigDecimal(fields[3]);

			line = br.readLine();

			fields = line.split(";");

			nodeID2 = fields[0];
			initialRely2 = new BigDecimal(fields[1]);
			maxRely2 = new BigDecimal(fields[2]);
			intervalRely2 = new BigDecimal(fields[3]);

			String[] header = {nodeID + " Rely", nodeID2 + " Rely", "Category 1 Risk", "Category 2 Risk", "Category 3 Risk", "Process Risk"};

			relyAndRisk.add(header);

			if (!nodeID.equals("comms")) {
				for (Node n : as.getNodes().values()) {
					if (n.getId().equals(nodeID)) {
						node = n;
						break;
					}
				}

				node.setReliability(initialRely);
			}
			else {
				as.changeComsReliability(initialRely.doubleValue());
			}

			if (!nodeID2.equals("comms")) {
				for (Node n : as.getNodes().values()) {
					if (n.getId().equals(nodeID2)) {
						node = n;
						break;
					}
				}

				node.setReliability(initialRely2);
			}
			else {
				as.changeComsReliability(initialRely2.doubleValue());
			}

			while (initialRely.doubleValue() <= maxRely.doubleValue()) {
				while (initialRely2.doubleValue() <= maxRely2.doubleValue()) {

					s = as.initialValue();
					riskValue = s.getRisk();
					String[] record = {initialRely.toString(),initialRely2.toString(),String.valueOf(as.getcategoryRisk("Category 1")),String.valueOf(as.getcategoryRisk("Category 2")*0.7),String.valueOf(as.getcategoryRisk("Category 3")),String.format("%.6f",riskValue)};
					relyAndRisk.add(record);

					as = new AlgorithmService(args[0], args[1], Boolean.parseBoolean(args[2]));

					initialRely2 = initialRely2.add(intervalRely2);

					if (!nodeID.equals("comms")) {

						for (Node n : as.getNodes().values()) {
							if (n.getId().equals(nodeID)) {
								node = n;
								break;
							}
						}

						node.setReliability(initialRely);
					}
					else {
						as.changeComsReliability(initialRely.doubleValue());
					}

					if (!nodeID2.equals("comms")) {
						for (Node n : as.getNodes().values()) {
							if (n.getId().equals(nodeID2)) {
								node = n;
								break;
							}
						}

						node.setReliability(initialRely2);
					}
					else {
						as.changeComsReliability(initialRely2.doubleValue());
					}
				}

				as = new AlgorithmService(args[0], args[1], Boolean.parseBoolean(args[2]));

				initialRely = initialRely.add(intervalRely);
				initialRely2 = new BigDecimal(fields[1]);

				if (!nodeID.equals("comms")) {

					for (Node n : as.getNodes().values()) {
						if (n.getId().equals(nodeID)) {
							node = n;
							break;
						}
					}

					node.setReliability(initialRely);
				}
				else {
					as.changeComsReliability(initialRely.doubleValue());
				}

				if (!nodeID2.equals("comms")) {
					for (Node n : as.getNodes().values()) {
						if (n.getId().equals(nodeID2)) {
							node = n;
							break;
						}
					}

					node.setReliability(initialRely2);
				}
				else {
					as.changeComsReliability(initialRely2.doubleValue());
				}
			}
			for (String[] relyRisk : relyAndRisk) {
				bw.write(relyRisk[0].replace(".",",")+";"+relyRisk[1].replace(".",",")+";"+relyRisk[2].replace(".",",")+";"+relyRisk[3].replace(".",",")+";"+relyRisk[4].replace(".",",")+";"+relyRisk[5].replace(".",",")+"\n");
			}
		}

		br.close();
		bw.close();
	}
}
