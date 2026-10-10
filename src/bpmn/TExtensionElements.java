  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                     
   
                                                                                               
   
        
                                             
                        
                                                                        
                      
                                                                                                  
                       
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tExtensionElements", propOrder = {
    "any"
})
public class TExtensionElements {

    @XmlAnyElement(lax = true)
    protected List<Object> any;

       
                                          
       
          
                                                                 
                                                                 
                                                            
                                                                               
       
          
                                                     
            
                                
             
       
       
          
                                                               
                      
                       
       
       
       
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
