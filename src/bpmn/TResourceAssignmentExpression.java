  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                                                
   
                                                                                               
   
        
                                                        
                        
                                                                                      
                      
                                                                                      
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResourceAssignmentExpression", propOrder = {
    "expression"
})
public class TResourceAssignmentExpression
    extends TBaseElement
{

    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected JAXBElement<? extends TExpression> expression;

       
                                                 
       
              
                             
                                                                           
                                                                     
           
       
    public JAXBElement<? extends TExpression> getExpression() {
        return expression;
    }

       
                                                 
       
                   
                            
                                                                           
                                                                     
           
       
    public void setExpression(JAXBElement<? extends TExpression> value) {
        this.expression = value;
    }

}
