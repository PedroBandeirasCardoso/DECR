  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                               
                      
                                                                                                                           
                                                                                                                        
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubChoreography", propOrder = {
    "flowElement",
    "artifact"
})
public class TSubChoreography
    extends TChoreographyActivity
{

    @XmlElementRef(name = "flowElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TFlowElement>> flowElement;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TArtifact>> artifact;

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                                                                      
                                                                  
                                                               
                                                                  
                                                                       
                                                                             
                                                                   
                                                                    
                                                                      
                                                                  
                                                                     
                                                                         
                                                                   
                                                                       
                                                               
                                                                       
                                                                          
                                                                 
                                                                             
                                                               
                                                                 
                                                                 
                                                                        
                                                           
                                                                 
                                                                       
                                                                      
                                                                  
                                                                         
                                                                       
                                                            
                                                                 
       
       
       
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

}
