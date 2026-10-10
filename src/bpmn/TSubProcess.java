  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                   
                      
                                                                                                                       
                                                                                                                           
                                                                                                                        
                       
                                                                                                                  
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubProcess", propOrder = {
    "laneSet",
    "flowElement",
    "artifact"
})
@XmlSeeAlso({
    TAdHocSubProcess.class,
    TTransaction.class
})
public class TSubProcess
    extends TActivity
{

    protected List<TLaneSet> laneSet;
    @XmlElementRef(name = "flowElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TFlowElement>> flowElement;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TArtifact>> artifact;
    @XmlAttribute(name = "triggeredByEvent")
    protected Boolean triggeredByEvent;

       
                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                   
       
          
                                                     
            
                                    
             
       
       
          
                                                               
                        
       
       
       
    public List<TLaneSet> getLaneSet() {
        if (laneSet == null) {
            laneSet = new ArrayList<TLaneSet>();
        }
        return this.laneSet;
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

       
                                                       
       
              
                             
                           
           
       
    public boolean isTriggeredByEvent() {
        if (triggeredByEvent == null) {
            return false;
        } else {
            return triggeredByEvent;
        }
    }

       
                                                       
       
                   
                            
                           
           
       
    public void setTriggeredByEvent(Boolean value) {
        this.triggeredByEvent = value;
    }

}
