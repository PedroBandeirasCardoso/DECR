  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                        
                                                                                       
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tProbability")
public class TProbability {

    @XmlAttribute(name = "value")
    protected BigDecimal value;

       
                                            
       
              
                             
                              
           
       
    public BigDecimal getValue() {
        return value;
    }

       
                                            
       
                   
                            
                              
           
       
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
