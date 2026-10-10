  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                      
                                                                                     
                                                                                                        
                                                                                                        
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConversationLink")
public class TConversationLink
    extends TBaseElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "sourceRef", required = true)
    protected QName sourceRef;
    @XmlAttribute(name = "targetRef", required = true)
    protected QName targetRef;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                
       
              
                             
                         
           
       
    public QName getSourceRef() {
        return sourceRef;
    }

       
                                                
       
                   
                            
                         
           
       
    public void setSourceRef(QName value) {
        this.sourceRef = value;
    }

       
                                                
       
              
                             
                         
           
       
    public QName getTargetRef() {
        return targetRef;
    }

       
                                                
       
                   
                            
                         
           
       
    public void setTargetRef(QName value) {
        this.targetRef = value;
    }

}
