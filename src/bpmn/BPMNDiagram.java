  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                            
                      
                                                                                  
                                                                                                                           
                       
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNDiagram", namespace = "http://www.omg.org/spec/BPMN/20100524/DI", propOrder = {
    "bpmnPlane",
    "bpmnLabelStyle"
})
public class BPMNDiagram
    extends Diagram
{

    @XmlElement(name = "BPMNPlane", required = true)
    protected BPMNPlane bpmnPlane;
    @XmlElement(name = "BPMNLabelStyle")
    protected List<BPMNLabelStyle> bpmnLabelStyle;

       
                                                
       
              
                             
                             
           
       
    public BPMNPlane getBPMNPlane() {
        return bpmnPlane;
    }

       
                                                
       
                   
                            
                             
           
       
    public void setBPMNPlane(BPMNPlane value) {
        this.bpmnPlane = value;
    }

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                              
       
       
       
    public List<BPMNLabelStyle> getBPMNLabelStyle() {
        if (bpmnLabelStyle == null) {
            bpmnLabelStyle = new ArrayList<BPMNLabelStyle>();
        }
        return this.bpmnLabelStyle;
    }

}
