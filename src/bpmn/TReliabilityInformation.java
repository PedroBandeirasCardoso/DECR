  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                          
   
                                                                                               
   
        
                                                  
                        
                                                                        
                                                                                                     
                                                                                                       
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tReliabilityInformation")
public class TReliabilityInformation {

    @XmlAttribute(name = "requiredReliability")
    protected BigDecimal requiredReliability;
    @XmlAttribute(name = "calculatedReliability")
    protected BigDecimal calculatedReliability;

       
                                                          
       
              
                             
                              
           
       
    public BigDecimal getRequiredReliability() {
        return requiredReliability;
    }

       
                                                          
       
                   
                            
                              
           
       
    public void setRequiredReliability(BigDecimal value) {
        this.requiredReliability = value;
    }

       
                                                            
       
              
                             
                              
           
       
    public BigDecimal getCalculatedReliability() {
        return calculatedReliability;
    }

       
                                                            
       
                   
                            
                              
           
       
    public void setCalculatedReliability(BigDecimal value) {
        this.calculatedReliability = value;
    }

}
