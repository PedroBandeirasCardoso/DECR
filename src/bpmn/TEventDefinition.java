  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                      
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEventDefinition")
@XmlSeeAlso({
    TEscalationEventDefinition.class,
    TTimerEventDefinition.class,
    TLinkEventDefinition.class,
    TConditionalEventDefinition.class,
    TTerminateEventDefinition.class,
    TSignalEventDefinition.class,
    TMessageEventDefinition.class,
    TCancelEventDefinition.class,
    TCompensateEventDefinition.class,
    TErrorEventDefinition.class
})
public abstract class TEventDefinition
    extends TRootElement
{


}
