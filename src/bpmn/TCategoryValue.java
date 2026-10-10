  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                                      
                                                                                      
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCategoryValue")
public class TCategoryValue
    extends TBaseElement
{

    @XmlAttribute(name = "value")
    protected String value;

       
                                            
       
              
                             
                          
           
       
    public String getValue() {
        return value;
    }

       
                                            
       
                   
                            
                          
           
       
    public void setValue(String value) {
        this.value = value;
    }

}
