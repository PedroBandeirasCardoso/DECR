  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                               
                                                                                                                                          
                                                                                          
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSendTask")
public class TSendTask
    extends TTask
{

    @XmlAttribute(name = "implementation")
    protected String implementation;
    @XmlAttribute(name = "messageRef")
    protected QName messageRef;
    @XmlAttribute(name = "operationRef")
    protected QName operationRef;

       
                                                     
       
              
                             
                          
           
       
    public String getImplementation() {
        if (implementation == null) {
            return "##WebService";
        } else {
            return implementation;
        }
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setImplementation(String value) {
        this.implementation = value;
    }

       
                                                 
       
              
                             
                         
           
       
    public QName getMessageRef() {
        return messageRef;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setMessageRef(QName value) {
        this.messageRef = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getOperationRef() {
        return operationRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setOperationRef(QName value) {
        this.operationRef = value;
    }

}
