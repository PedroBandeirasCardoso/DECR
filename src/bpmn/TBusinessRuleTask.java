  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                               
                                                                                                                                           
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBusinessRuleTask")
public class TBusinessRuleTask
    extends TTask
{

    @XmlAttribute(name = "implementation")
    protected String implementation;

       
                                                     
       
              
                             
                          
           
       
    public String getImplementation() {
        if (implementation == null) {
            return "##unspecified";
        } else {
            return implementation;
        }
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setImplementation(String value) {
        this.implementation = value;
    }

}
