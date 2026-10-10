  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                        
                      
                                                        
                       
                                                                               
                                                                                                                
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDocumentation", propOrder = {
    "content"
})
public class TDocumentation {

    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "textFormat")
    protected String textFormat;

       
                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                   
       
          
                                                     
            
                                    
             
       
       
          
                                                               
                      
                       
                      
       
       
       
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

       
                                         
       
              
                             
                          
           
       
    public String getId() {
        return id;
    }

       
                                         
       
                   
                            
                          
           
       
    public void setId(String value) {
        this.id = value;
    }

       
                                                 
       
              
                             
                          
           
       
    public String getTextFormat() {
        if (textFormat == null) {
            return "text/plain";
        } else {
            return textFormat;
        }
    }

       
                                                 
       
                   
                            
                          
           
       
    public void setTextFormat(String value) {
        this.textFormat = value;
    }

}
