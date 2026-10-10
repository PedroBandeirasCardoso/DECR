  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                        
                      
                                                      
                             
                                  
                                                                                  
                                
                                                                                      
                                 
                                  
                                   
                              
                        
                       
                                                                               
                                                                     
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagramElement", namespace = "http://www.omg.org/spec/DD/20100524/DI", propOrder = {
    "extension"
})
@XmlSeeAlso({
    Node.class,
    Edge.class
})
public abstract class DiagramElement {

    protected DiagramElement.Extension extension;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

       
                                                
       
              
                             
                                            
           
       
    public DiagramElement.Extension getExtension() {
        return extension;
    }

       
                                                
       
                   
                            
                                            
           
       
    public void setExtension(DiagramElement.Extension value) {
        this.extension = value;
    }

       
                                         
       
              
                             
                          
           
       
    public String getId() {
        return id;
    }

       
                                         
       
                   
                            
                          
           
       
    public void setId(String value) {
        this.id = value;
    }

       
                                                                                                 
       
          
                                                         
                                                      
       
                                                                             
                                                                               
       
       
              
                          
       
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


       
                                                
       
                                                                                                   
       
            
                       
                            
                                                                            
                          
                                                                                
                           
                            
                             
                        
             
       
       
       
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Extension {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

           
                                              
           
              
                                                                     
                                                                     
                                                                
                                                                                   
           
              
                                                         
                
                                    
                 
           
           
              
                                                                   
                          
           
           
           
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
