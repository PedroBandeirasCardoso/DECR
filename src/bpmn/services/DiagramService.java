package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bpmn.TCategory;
import bpmn.TCollaboration;
import bpmn.TDefinitions;
import bpmn.TFlowElement;
import bpmn.TMessageFlow;
import bpmn.TProcess;
import helpers.Comms;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class DiagramService {

	public final static String RELIABILITYVALUE = "ReliabilityInformation";
	public final static String BUSINESSVALUE = "BusinessValueInformation";
	public final static String RISKVALUE = "RiskInformation";
	public final static String COSTVALUE = "CostInformation";
	public final static String OUTGOING = "OutgoingCommunication";
	public final static String INCOMING = "IncomingCommunication";

	public final static String PROBABILITY = "Probability";
	public static final String LANE = "lane";
	public static final String LANES = "executionLane";

	public static final String MUTABLE = "Mutable";

	public static List<TProcess> getProcesses(JAXBElement<?> parsed) {
		List<TProcess> d = new ArrayList<>();
		TDefinitions def;
		TProcess process;
		ArrayList<Comms> outs = new ArrayList<Comms>();
		ArrayList<Comms> ins = new ArrayList<Comms>();
		def = (TDefinitions) parsed.getValue();
		int pos = 0;
		while (pos < def.getRootElement().size()) {
			try {
				process = (TProcess) def.getRootElement().get(pos).getValue();
				process.setComponentValue("Rely", -1);
				process.setComponentValue("BV", -1);
				process.setComponentValue("Risk", -1);
				outs = new ArrayList<Comms>();
				ins = new ArrayList<Comms>();
				if (def.getRootElement().get(pos).getValue().getExtensionElements() != null) {
					for (Object node : def.getRootElement().get(pos).getValue().getExtensionElements().getAny()) {
						if (((Node) node).getLocalName() != null) {
							switch (((Node) node).getLocalName()) {
								case RELIABILITYVALUE: {
									process.setComponentValue("Rely", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));
									break;
								}
								case BUSINESSVALUE: {
									process.setComponentValue("BV", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));
									break;
								}
								case RISKVALUE: {
									NodeList nList = ((Node) node).getChildNodes();
									for (int j = 0; j < nList.getLength(); j++) {
										if (nList.item(j).getLocalName() != null && nList.item(j).getLocalName().contains("calculatedRisk"))
											process.setComponentValue("Risk", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));

									}
									break;
								}
								case OUTGOING: {
									NodeList nList = ((Node) node).getChildNodes();
									Comms outgoing = new Comms();
									for (int j = 0; j < nList.getLength(); j++) {
										if (nList.item(j).getLocalName() != null) {
											switch (nList.item(j).getLocalName()) {
												case "reliabilityValue": {
													outgoing.setReliability(Double.parseDouble(nList.item(j).getTextContent()));
													break;
												}
												case "costValue": {
													outgoing.setCost(Double.parseDouble(nList.item(j).getTextContent()));
													break;
												}
												case "participantRef": {
													outgoing.setParticipantRef(nList.item(j).getTextContent());
													break;
												}
											}
										}
									}
									outs.add(outgoing);
									break;
								}
								case INCOMING: {
									NodeList nList = ((Node) node).getChildNodes();
									Comms incoming = new Comms();
									for (int j = 0; j < nList.getLength(); j++) {
										if (nList.item(j).getLocalName() != null) {
											switch (nList.item(j).getLocalName()) {
												case "reliabilityValue": {
													incoming.setReliability(Double.parseDouble(nList.item(j).getTextContent()));
													break;
												}
												case "costValue": {
													incoming.setCost(Double.parseDouble(nList.item(j).getTextContent()));
													break;
												}
												case "participantRef": {
													incoming.setParticipantRef(nList.item(j).getTextContent());
													break;
												}
											}
										}
									}
									ins.add(incoming);
									break;
								}
							}
						}
					}
				}
				process.setIncoming(ins);
				process.setOutgoing(outs);
				d.add(process);
			} catch (ClassCastException ce) {
			}
			pos++;
		}
		return d;
	}

	public static List<TCollaboration> getCollaborations(JAXBElement<?> parsed) {
		List<TCollaboration> d = new ArrayList<>();
		TDefinitions def;
		def = (TDefinitions) parsed.getValue();

		int pos = 0;
		while (pos < def.getRootElement().size()) {
			try {
				d.add((TCollaboration) def.getRootElement().get(pos).getValue());
			} catch (ClassCastException ce) {
			}
			pos++;
		}
		return d;
	}

	public static List<TCategory> getCategories(JAXBElement<?> parsed) {
		List<TCategory> d = new ArrayList<>();
		TDefinitions def;
		TCategory category;
		def = (TDefinitions) parsed.getValue();

		int pos = 0;
		while (pos < def.getRootElement().size()) {
			try {
				category = (TCategory) def.getRootElement().get(pos).getValue();
				category.setComponentValue("Rely", -1);
				category.setComponentValue("BV", -1);
				category.setComponentValue("Risk", -1);
				if (def.getRootElement().get(pos).getValue().getExtensionElements() != null) {
					for (Object node : def.getRootElement().get(pos).getValue().getExtensionElements().getAny()) {
						if (((Node) node).getLocalName() != null) {
							switch (((Node) node).getLocalName()) {
								case RELIABILITYVALUE: {
									category.setComponentValue("Rely", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));
									break;
								}
								case BUSINESSVALUE: {
									category.setComponentValue("BV", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));
									break;
								}
								case RISKVALUE: {
									category.setComponentValue("Risk", Double.parseDouble(((Node) node).getFirstChild().getTextContent()));
									break;
								}
								case "CategoryValueRef": {
									category.setCategoryValueRef(((Node) node).getFirstChild().getTextContent());
									break;
								}
							}
						}
					}
				}
				d.add(category);
			} catch (ClassCastException ce) {
			}
			pos++;
		}
		return d;
	}

	public static JAXBElement<?> XMLUnmarshal(String file) throws FileNotFoundException {
		JAXBContext context;
		Unmarshaller u;
		JAXBElement<?> parsed = null;
		try {
			context = JAXBContext.newInstance(TProcess.class);
			u = context.createUnmarshaller();
			parsed = (JAXBElement<?>) u.unmarshal(new FileInputStream(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return parsed;
	}

	public static void XMLMarshal(JAXBElement<?> root, String file) {
		JAXBContext context;
		Marshaller u;
		try {
			context = JAXBContext.newInstance(TProcess.class);
			u = context.createMarshaller();
			u.marshal(root, new File(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static boolean setParameterByName(TFlowElement tfe, String name, double value) {
		if (tfe.getExtensionElements() != null) {
			int extensionSize = tfe.getExtensionElements().getAny().size();
			for (int i = 0; i < extensionSize; i++) {
				Node x = (Node) tfe.getExtensionElements().getAny().get(i);
				NodeList nList = x.getChildNodes();
				for (int j = 0; j < x.getChildNodes().getLength(); j++) {
					if (nList.item(j).getLocalName() != null)
						if (nList.item(j).getLocalName().equals(name)) {
							nList.item(j).getFirstChild().setNodeValue(String.valueOf(value));
							return true;
						}
				}
			}
		}
		return false;
	}

	public static String getParameterByName(TFlowElement tfe, String name) {
		String result="";
		String pRef="";
		String value="";
		if (tfe.getExtensionElements() != null) {
			int extensionSize = tfe.getExtensionElements().getAny().size();
			for (int i = 0; i < extensionSize; i++) {
				pRef="";
				value="";
				Node x = (Node) tfe.getExtensionElements().getAny().get(i);
				if (x.getLocalName() != null && x.getLocalName().equals(name)) {
					if (x.getLocalName().equals(MUTABLE)) {
						result = x.getTextContent();
					}
					NodeList nList = x.getChildNodes();
					for (int j = 0; j < nList.getLength(); j++) {
						if (nList.item(j).getLocalName() != null) {
							switch (name) {
								case RELIABILITYVALUE: {
									switch (nList.item(j).getLocalName()) {
										case "reliabilityValue": {
											value = nList.item(j).getFirstChild().getTextContent();
											break;
										}
										case "participantRef": {
											pRef = nList.item(j).getFirstChild().getTextContent();
											break;
										}
									}
									break;
								}
								case COSTVALUE: {
									switch (nList.item(j).getLocalName()) {
										case "costValue": {
											value = nList.item(j).getFirstChild().getTextContent();
											break;
										}
										case "participantRef": {
											pRef = nList.item(j).getFirstChild().getTextContent();
											break;
										}
									}
									break;
								}
								default: {
									result = nList.item(j).getFirstChild().getTextContent();
								}
							}
						}

					}
				}
				if (!pRef.equals("") && !value.equals(""))
					result += pRef + "-" + value + ";";
			}
		}
		if (result.equals("") || result.equals("-"))
			return "-1";
		else
			return result;
	}

	public static String getParameterByName(TMessageFlow tmf, String name) {
		if (tmf.getExtensionElements() != null) {
			int extensionSize = tmf.getExtensionElements().getAny().size();
			for (int i = 0; i < extensionSize; i++) {
				Node x = (Node) tmf.getExtensionElements().getAny().get(i);
				if (x.getLocalName() != null && x.getLocalName().equals(name)) {
					return x.getFirstChild().getTextContent();
				}
			}
		}
		return "-1";
	}
}
