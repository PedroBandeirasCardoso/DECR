  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
   
        
                                   
                        
                                                                                   
                                                                                                                                             
                                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGateway")
@XmlSeeAlso({
    TExclusiveGateway.class,
    TEventBasedGateway.class,
    TParallelGateway.class,
    TInclusiveGateway.class,
    TComplexGateway.class
})
public class TGateway
    extends TFlowNode
{

    @XmlAttribute(name = "gatewayDirection")
    protected TGatewayDirection gatewayDirection;
    @XmlAttribute(name = "reliability")
    protected Double reliability;

       
                                                       
       
              
                             
                                     
           
       
    public TGatewayDirection getGatewayDirection() {
        if (gatewayDirection == null) {
            return TGatewayDirection.UNSPECIFIED;
        } else {
            return gatewayDirection;
        }
    }

       
                                                       
       
                   
                            
                                     
           
       
    public void setGatewayDirection(TGatewayDirection value) {
        this.gatewayDirection = value;
    }

       
                                                  
       
              
                             
                          
           
       
    public double getReliability() {
        if (reliability == null) {
            return  1.0D;
        } else {
            return reliability;
        }
    }

       
                                                  
       
                   
                            
                          
           
       
    public void setReliability(Double value) {
        this.reliability = value;
    }

}
