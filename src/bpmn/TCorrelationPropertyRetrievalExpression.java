  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                                          
   
                                                                                               
   
        
                                                                  
                        
                                                                                      
                      
                                                                                                                 
                       
                                                                                                         
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationPropertyRetrievalExpression", propOrder = {
    "messagePath"
})
public class TCorrelationPropertyRetrievalExpression
    extends TBaseElement
{

    @XmlElement(required = true)
    protected TFormalExpression messagePath;
    @XmlAttribute(name = "messageRef", required = true)
    protected QName messageRef;

       
                                                  
       
              
                             
                                     
           
       
    public TFormalExpression getMessagePath() {
        return messagePath;
    }

       
                                                  
       
                   
                            
                                     
           
       
    public void setMessagePath(TFormalExpression value) {
        this.messagePath = value;
    }

       
                                                 
       
              
                             
                         
           
       
    public QName getMessageRef() {
        return messageRef;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setMessageRef(QName value) {
        this.messageRef = value;
    }

}
