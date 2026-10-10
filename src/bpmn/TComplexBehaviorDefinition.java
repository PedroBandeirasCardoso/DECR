  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                             
   
                                                                                               
   
        
                                                     
                        
                                                                                      
                      
                                                                                                               
                                                                                                                           
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tComplexBehaviorDefinition", propOrder = {
    "condition",
    "event"
})
public class TComplexBehaviorDefinition
    extends TBaseElement
{

    @XmlElement(required = true)
    protected TFormalExpression condition;
    protected TImplicitThrowEvent event;

       
                                                
       
              
                             
                                     
           
       
    public TFormalExpression getCondition() {
        return condition;
    }

       
                                                
       
                   
                            
                                     
           
       
    public void setCondition(TFormalExpression value) {
        this.condition = value;
    }

       
                                            
       
              
                             
                                       
           
       
    public TImplicitThrowEvent getEvent() {
        return event;
    }

       
                                            
       
                   
                            
                                       
           
       
    public void setEvent(TImplicitThrowEvent value) {
        this.event = value;
    }

}
