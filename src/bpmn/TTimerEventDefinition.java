  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                        
   
                                                                                               
   
        
                                                
                        
                                                                                          
                    
                                                                                                                      
                                                                                                                          
                                                                                                                       
                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTimerEventDefinition", propOrder = {
    "timeDate",
    "timeDuration",
    "timeCycle"
})
public class TTimerEventDefinition
    extends TEventDefinition
{

    protected TExpression timeDate;
    protected TExpression timeDuration;
    protected TExpression timeCycle;

       
                                               
       
              
                             
                               
           
       
    public TExpression getTimeDate() {
        return timeDate;
    }

       
                                               
       
                   
                            
                               
           
       
    public void setTimeDate(TExpression value) {
        this.timeDate = value;
    }

       
                                                   
       
              
                             
                               
           
       
    public TExpression getTimeDuration() {
        return timeDuration;
    }

       
                                                   
       
                   
                            
                               
           
       
    public void setTimeDuration(TExpression value) {
        this.timeDuration = value;
    }

       
                                                
       
              
                             
                               
           
       
    public TExpression getTimeCycle() {
        return timeCycle;
    }

       
                                                
       
                   
                            
                               
           
       
    public void setTimeCycle(TExpression value) {
        this.timeCycle = value;
    }

}
