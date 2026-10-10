  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                      
                      
                                                                                                                                 
                                                                                                                                 
                                                                                                                              
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConversationNode", propOrder = {
    "participantRef",
    "messageFlowRef",
    "correlationKey"
})
@XmlSeeAlso({
    TSubConversation.class,
    TCallConversation.class,
    TConversation.class
})
public abstract class TConversationNode
    extends TBaseElement
{

    protected List<QName> participantRef;
    protected List<QName> messageFlowRef;
    protected List<TCorrelationKey> correlationKey;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getParticipantRef() {
        if (participantRef == null) {
            participantRef = new ArrayList<QName>();
        }
        return this.participantRef;
    }

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getMessageFlowRef() {
        if (messageFlowRef == null) {
            messageFlowRef = new ArrayList<QName>();
        }
        return this.messageFlowRef;
    }

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                               
       
       
       
    public List<TCorrelationKey> getCorrelationKey() {
        if (correlationKey == null) {
            correlationKey = new ArrayList<TCorrelationKey>();
        }
        return this.correlationKey;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
