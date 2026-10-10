  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                     
                                                                                                               
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tStartEvent")
public class TStartEvent
    extends TCatchEvent
{

    @XmlAttribute(name = "isInterrupting")
    protected Boolean isInterrupting;

       
                                                     
       
              
                             
                           
           
       
    public boolean isIsInterrupting() {
        if (isInterrupting == null) {
            return true;
        } else {
            return isInterrupting;
        }
    }

       
                                                     
       
                   
                            
                           
           
       
    public void setIsInterrupting(Boolean value) {
        this.isInterrupting = value;
    }

}
