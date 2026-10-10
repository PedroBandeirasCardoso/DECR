  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                
   
                                                                                               
   
        
                                        
                        
                                                                                        
                      
                                                                                                                           
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tChoreography", propOrder = {
    "flowElement"
})
@XmlSeeAlso({
    TGlobalChoreographyTask.class
})
public class TChoreography
    extends TCollaboration
{

    @XmlElementRef(name = "flowElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TFlowElement>> flowElement;

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                                                                      
                                                                  
                                                               
                                                                  
                                                                       
                                                                             
                                                                   
                                                                    
                                                                      
                                                                  
                                                                     
                                                                         
                                                                   
                                                                       
                                                               
                                                                       
                                                                          
                                                                 
                                                                             
                                                               
                                                                 
                                                                 
                                                                        
                                                           
                                                                 
                                                                       
                                                                      
                                                                  
                                                                         
                                                                       
                                                            
                                                                 
       
       
       
    public List<JAXBElement<? extends TFlowElement>> getFlowElement() {
        if (flowElement == null) {
            flowElement = new ArrayList<JAXBElement<? extends TFlowElement>>();
        }
        return this.flowElement;
    }

}
