  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                        
   
                                                                                               
   
        
                                
                        
                                                                         
                      
                                                                                           
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label", namespace = "http://www.omg.org/spec/DD/20100524/DI", propOrder = {
    "bounds"
})
@XmlSeeAlso({
    BPMNLabel.class
})
public abstract class Label
    extends Node
{

    @XmlElement(name = "Bounds", namespace = "http://www.omg.org/spec/DD/20100524/DC")
    protected Bounds bounds;

       
                                             
       
              
                             
                          
           
       
    public Bounds getBounds() {
        return bounds;
    }

       
                                             
       
                   
                            
                          
           
       
    public void setBounds(Bounds value) {
        this.bounds = value;
    }

}
