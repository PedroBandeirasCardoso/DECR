  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


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
@XmlType(name = "Plane", namespace = "http://www.omg.org/spec/DD/20100524/DI", propOrder = {
    "diagramElement"
})
@XmlSeeAlso({
    BPMNPlane.class
})
public abstract class Plane
    extends Node
{

    @XmlElementRef(name = "DiagramElement", namespace = "http://www.omg.org/spec/DD/20100524/DI", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends DiagramElement>> diagramElement;

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                                                              
                                                               
                                                                    
       
       
       
    public List<JAXBElement<? extends DiagramElement>> getDiagramElement() {
        if (diagramElement == null) {
            diagramElement = new ArrayList<JAXBElement<? extends DiagramElement>>();
        }
        return this.diagramElement;
    }

}
