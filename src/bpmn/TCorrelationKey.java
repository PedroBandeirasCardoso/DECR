  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                  
   
                                                                                               
   
        
                                          
                        
                                                                                      
                      
                                                                                                                                         
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationKey", propOrder = {
    "correlationPropertyRef"
})
public class TCorrelationKey
    extends TBaseElement
{

    protected List<QName> correlationPropertyRef;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                  
       
          
                                                     
            
                                                   
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getCorrelationPropertyRef() {
        if (correlationPropertyRef == null) {
            correlationPropertyRef = new ArrayList<QName>();
        }
        return this.correlationPropertyRef;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
