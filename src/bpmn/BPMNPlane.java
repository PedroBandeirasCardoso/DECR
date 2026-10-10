  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                          
                                                                                           
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNPlane", namespace = "http://www.omg.org/spec/BPMN/20100524/DI")
public class BPMNPlane
    extends Plane
{

    @XmlAttribute(name = "bpmnElement")
    protected QName bpmnElement;

       
                                                  
       
              
                             
                         
           
       
    public QName getBpmnElement() {
        return bpmnElement;
    }

       
                                                  
       
                   
                            
                         
           
       
    public void setBpmnElement(QName value) {
        this.bpmnElement = value;
    }

}
