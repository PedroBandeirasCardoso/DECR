  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                          
   
                                                                                               
   
        
                                                  
                        
                                                                                          
                      
                                                                                                         
                       
                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tMessageEventDefinition", propOrder = {
    "operationRef"
})
public class TMessageEventDefinition
    extends TEventDefinition
{

    protected QName operationRef;
    @XmlAttribute(name = "messageRef")
    protected QName messageRef;

       
                                                   
       
              
                             
                         
           
       
    public QName getOperationRef() {
        return operationRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setOperationRef(QName value) {
        this.operationRef = value;
    }

       
                                                 
       
              
                             
                         
           
       
    public QName getMessageRef() {
        return messageRef;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setMessageRef(QName value) {
        this.messageRef = value;
    }

}
