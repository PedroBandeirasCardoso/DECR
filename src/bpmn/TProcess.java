  
                                                                                                                           
                                                                               
                                                                                        
                                               
  

package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import helpers.Comms;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;

   
      
                                        
   
      
                                                                                
              
   
        
                                   
                        
                                                                                          
                      
                                                                                                  
                                                                                                    
                                                                                                                        
                                                                                                                       
                                                                                                                           
                                                                                                                        
                                                                                                                            
                                                                                                                                       
                                                                                                                           
                       
                                                                                                                            
                                                                                                          
                                                                                              
                                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tProcess", propOrder = { "auditing", "monitoring", "property", "laneSet", "flowElement", "artifact",
		"resourceRole", "correlationSubscription", "supports", "categories", "reliabilityValue", "businessValue",
		"calculatedRisk", "outgoings", "incomings" })
public class TProcess extends TCallableElement {

	protected TAuditing auditing;
	protected TMonitoring monitoring;
	protected List<TProperty> property;
	protected List<TLaneSet> laneSet;
	protected List<TCategory> categories;
	@XmlElementRef(name = "flowElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
	protected List<JAXBElement<? extends TFlowElement>> flowElement;
	@XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
	protected List<JAXBElement<? extends TArtifact>> artifact;
	@XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
	protected List<JAXBElement<? extends TResourceRole>> resourceRole;
	protected List<TCorrelationSubscription> correlationSubscription;
	protected List<QName> supports;
	@XmlAttribute(name = "processType")
	protected TProcessType processType;
	@XmlAttribute(name = "isClosed")
	protected Boolean isClosed;
	@XmlAttribute(name = "isExecutable")
	protected Boolean isExecutable;
	@XmlAttribute(name = "definitionalCollaborationRef")
	protected QName definitionalCollaborationRef;
	private double reliabilityValue;
	private double businessValue;
	private double calculatedRisk;
	private ArrayList<Comms> outgoings;
	private ArrayList<Comms> incomings;

	   
                                            
    
                                                 
    
    
	public TAuditing getAuditing() {
		return auditing;
	}

	   
                                            
    
                
                                                   
    
    
	public void setAuditing(TAuditing value) {
		this.auditing = value;
	}

	   
                                              
    
                                                   
    
    
	public TMonitoring getMonitoring() {
		return monitoring;
	}

	   
                                              
    
                
                                                     
    
    
	public void setMonitoring(TMonitoring value) {
		this.monitoring = value;
	}

	   
                                            
    
       
                                                                    
                                                                           
                                                                 
                                                      
    
       
                                                  
    
         
                               
          
    
    
       
                                                                             
     
    
    
    
	public List<TProperty> getProperty() {
		if (property == null) {
			property = new ArrayList<TProperty>();
		}
		return this.property;
	}

	   
                                           
    
       
                                                                    
                                                                           
                                                                 
                                                     
    
       
                                                  
    
         
                              
          
    
    
       
                                                                            
     
    
    
    
	public List<TLaneSet> getLaneSet() {
		if (laneSet == null) {
			laneSet = new ArrayList<TLaneSet>();
		}
		return this.laneSet;
	}
	
	public List<TCategory> getCategories() {
		if (categories == null) {
			categories = new ArrayList<TCategory>();
		}
		return this.categories;
	}
	
	public TCategory getRootCategory() {
		return this.categories.get(0);
	}

	   
                                               
    
       
                                                                    
                                                                           
                                                                 
                                                         
    
       
                                                  
    
         
                                  
          
    
    
       
                                                            
                                                                   
                                                               
                                                            
                                                               
                                                                    
                                                                          
                                                                
                                                                 
                                                                   
                                                               
                                                                  
                                                                      
                                                                
                                                                    
                                                            
                                                                    
                                                                       
                                                              
                                                                          
                                                            
                                                              
                                                              
                                                                     
                                                                           
                                                              
                                                                    
                                                                   
                                                               
                                                                      
                                                                    
                                                         
                                           
    
    
    
	public List<JAXBElement<? extends TFlowElement>> getFlowElement() {
		if (flowElement == null) {
			flowElement = new ArrayList<JAXBElement<? extends TFlowElement>>();
		}
		return this.flowElement;
	}

	   
                                            
    
       
                                                                    
                                                                           
                                                                 
                                                      
    
       
                                                  
    
         
                               
          
    
    
       
                                                            
                                                                            
                                                               
                                                                  
                                         
    
    
    
	public List<JAXBElement<? extends TArtifact>> getArtifact() {
		if (artifact == null) {
			artifact = new ArrayList<JAXBElement<? extends TArtifact>>();
		}
		return this.artifact;
	}

	   
                                                
    
       
                                                                    
                                                                           
                                                                 
                                                          
    
       
                                                  
    
         
                                   
          
    
    
       
                                                            
                                                                  
                                                                  
                                                                
                                                             
    
    
    
	public List<JAXBElement<? extends TResourceRole>> getResourceRole() {
		if (resourceRole == null) {
			resourceRole = new ArrayList<JAXBElement<? extends TResourceRole>>();
		}
		return this.resourceRole;
	}

	   
                                                           
    
       
                                                                    
                                                                           
                                                                 
                                                                     
    
       
                                                  
    
         
                                              
          
    
    
       
                                                            
                                     
    
    
    
	public List<TCorrelationSubscription> getCorrelationSubscription() {
		if (correlationSubscription == null) {
			correlationSubscription = new ArrayList<TCorrelationSubscription>();
		}
		return this.correlationSubscription;
	}

	   
                                            
    
       
                                                                    
                                                                           
                                                                 
                                                      
    
       
                                                  
    
         
                               
          
    
    
       
                                                                           
    
    
    
	public List<QName> getSupports() {
		if (supports == null) {
			supports = new ArrayList<QName>();
		}
		return this.supports;
	}

	   
                                               
    
                                                    
    
    
	public TProcessType getProcessType() {
		if (processType == null) {
			return TProcessType.NONE;
		} else {
			return processType;
		}
	}

	   
                                               
    
                
                                                      
    
    
	public void setProcessType(TProcessType value) {
		this.processType = value;
	}

	   
                                            
    
                                               
    
    
                                
                           
                  
            
                     
     
    

	   
                                            
    
                
                                                 
    
    
	public void setIsClosed(Boolean value) {
		this.isClosed = value;
	}

	   
                                                
    
                                               
    
    
	public Boolean isIsExecutable() {
		return isExecutable;
	}

	   
                                                
    
                
                                                 
    
    
	public void setIsExecutable(Boolean value) {
		this.isExecutable = value;
	}

	   
                                                                
    
                                             
    
    
	public QName getDefinitionalCollaborationRef() {
		return definitionalCollaborationRef;
	}

	   
                                                                
    
                
                                               
    
    
	public void setDefinitionalCollaborationRef(QName value) {
		this.definitionalCollaborationRef = value;
	}

	public void setFlowElement(List<JAXBElement<? extends TFlowElement>> flowElement) {
		this.flowElement = flowElement;
	}
	
	public void setCategories(List<TCategory> categories) {
		this.categories = categories;
	}
	
	public double getBusinessValue() {
    	return this.businessValue;
    	}
	
	public double getComponent(String component) {
    	switch (component) {
    		case "Rely":
    			return this.reliabilityValue;
    		case "BV":
    			return this.businessValue;
    		case "Risk":
    			return this.calculatedRisk;
    		default:
    			return -1.0;
    	}
    }
	
	public void setOutgoing(ArrayList<Comms> outgoings) {
    	this.outgoings = outgoings;
    }
	
	public void setIncoming(ArrayList<Comms> incomings) {
    	this.incomings = incomings;
    }
	
	public ArrayList<Comms> getOutgoing() {
    	return this.outgoings;
    }
	
	public ArrayList<Comms> getIncoming() {
    	return this.incomings;
    }

	public void setComponentValue(String componentToCompute, double componentValue) {
		switch (componentToCompute) {
			case "Rely": {
				this.reliabilityValue = componentValue;
				break;
			}
			case "BV": {
				this.businessValue = componentValue;
				break;
			}
			case "Risk": {
				this.calculatedRisk = componentValue;
				break;
			}
		}
		
	}

}
