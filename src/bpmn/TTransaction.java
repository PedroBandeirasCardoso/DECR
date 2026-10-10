  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                                     
                                                                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTransaction")
public class TTransaction
    extends TSubProcess
{

    @XmlAttribute(name = "method")
    protected String method;

       
                                             
       
              
                             
                          
           
       
    public String getMethod() {
        if (method == null) {
            return "##Compensate";
        } else {
            return method;
        }
    }

       
                                             
       
                   
                            
                          
           
       
    public void setMethod(String value) {
        this.method = value;
    }

}
