  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                       
   
                                                                                               
   
        
                               
                        
                                                                                   
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Node", namespace = "http://www.omg.org/spec/DD/20100524/DI")
@XmlSeeAlso({
    Shape.class,
    Plane.class,
    Label.class
})
public abstract class Node
    extends DiagramElement
{


}
