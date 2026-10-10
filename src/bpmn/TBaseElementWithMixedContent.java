  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                                               
   
                                                                                               
   
        
                                                       
                        
                                                                        
                      
                                                                                                                             
                                                                                                           
                       
                                                                               
                                                                     
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBaseElementWithMixedContent", propOrder = {
    "content"
})
@XmlSeeAlso({
    TExpression.class
})
public abstract class TBaseElementWithMixedContent {

    @XmlElementRefs({
        @XmlElementRef(name = "documentation", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "extensionElements", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

       
                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                   
       
          
                                                     
            
                                    
             
       
       
          
                                                               
                                                                    
                                                                        
                      
       
       
       
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
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

}
