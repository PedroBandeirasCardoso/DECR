  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                     
   
                                                                                               
   
        
                                             
                        
                                                                                  
                                                                                                             
                                                                                                                                                
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEventBasedGateway")
public class TEventBasedGateway
    extends TGateway
{

    @XmlAttribute(name = "instantiate")
    protected Boolean instantiate;
    @XmlAttribute(name = "eventGatewayType")
    protected TEventBasedGatewayType eventGatewayType;

       
                                                  
       
              
                             
                           
           
       
    public boolean isInstantiate() {
        if (instantiate == null) {
            return false;
        } else {
            return instantiate;
        }
    }

       
                                                  
       
                   
                            
                           
           
       
    public void setInstantiate(Boolean value) {
        this.instantiate = value;
    }

       
                                                       
       
              
                             
                                          
           
       
    public TEventBasedGatewayType getEventGatewayType() {
        if (eventGatewayType == null) {
            return TEventBasedGatewayType.EXCLUSIVE;
        } else {
            return eventGatewayType;
        }
    }

       
                                                       
       
                   
                            
                                          
           
       
    public void setEventGatewayType(TEventBasedGatewayType value) {
        this.eventGatewayType = value;
    }

}
