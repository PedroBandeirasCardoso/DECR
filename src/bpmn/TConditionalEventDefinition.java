  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                              
   
                                                                                               
   
        
                                                      
                        
                                                                                          
                      
                                                                                                         
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConditionalEventDefinition", propOrder = {
    "condition"
})
public class TConditionalEventDefinition
    extends TEventDefinition
{

    @XmlElement(required = true)
    protected TExpression condition;

       
                                                
       
              
                             
                               
           
       
    public TExpression getCondition() {
        return condition;
    }

       
                                                
       
                   
                            
                               
           
       
    public void setCondition(TExpression value) {
        this.condition = value;
    }

}
