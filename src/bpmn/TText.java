  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlType;


   
                                        
   
                                                                                               
   
        
                                
                        
                                                                        
                      
                                                        
                       
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tText", propOrder = {
    "content"
})
public class TText {

    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;

       
                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                   
       
          
                                                     
            
                                    
             
       
       
          
                                                               
                      
                       
                      
       
       
       
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
