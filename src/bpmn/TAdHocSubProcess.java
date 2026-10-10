  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                     
                      
                                                                                                                                 
                       
                                                                                                                         
                                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAdHocSubProcess", propOrder = {
    "completionCondition"
})
public class TAdHocSubProcess
    extends TSubProcess
{

    protected TExpression completionCondition;
    @XmlAttribute(name = "cancelRemainingInstances")
    protected Boolean cancelRemainingInstances;
    @XmlAttribute(name = "ordering")
    protected TAdHocOrdering ordering;

       
                                                          
       
              
                             
                               
           
       
    public TExpression getCompletionCondition() {
        return completionCondition;
    }

       
                                                          
       
                   
                            
                               
           
       
    public void setCompletionCondition(TExpression value) {
        this.completionCondition = value;
    }

       
                                                               
       
              
                             
                           
           
       
    public boolean isCancelRemainingInstances() {
        if (cancelRemainingInstances == null) {
            return true;
        } else {
            return cancelRemainingInstances;
        }
    }

       
                                                               
       
                   
                            
                           
           
       
    public void setCancelRemainingInstances(Boolean value) {
        this.cancelRemainingInstances = value;
    }

       
                                               
       
              
                             
                                  
           
       
    public TAdHocOrdering getOrdering() {
        return ordering;
    }

       
                                               
       
                   
                            
                                  
           
       
    public void setOrdering(TAdHocOrdering value) {
        this.ordering = value;
    }

}
