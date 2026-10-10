  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                           
   
                                                                                               
   
        
                                                   
                        
                                                                                      
                                                                                                                       
                                                                                                                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConversationAssociation")
public class TConversationAssociation
    extends TBaseElement
{

    @XmlAttribute(name = "innerConversationNodeRef", required = true)
    protected QName innerConversationNodeRef;
    @XmlAttribute(name = "outerConversationNodeRef", required = true)
    protected QName outerConversationNodeRef;

       
                                                               
       
              
                             
                         
           
       
    public QName getInnerConversationNodeRef() {
        return innerConversationNodeRef;
    }

       
                                                               
       
                   
                            
                         
           
       
    public void setInnerConversationNodeRef(QName value) {
        this.innerConversationNodeRef = value;
    }

       
                                                               
       
              
                             
                         
           
       
    public QName getOuterConversationNodeRef() {
        return outerConversationNodeRef;
    }

       
                                                               
       
                   
                            
                         
           
       
    public void setOuterConversationNodeRef(QName value) {
        this.outerConversationNodeRef = value;
    }

}
