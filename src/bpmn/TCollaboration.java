  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                                      
                      
                                                                                                                           
                                                                                                                           
                                                                                                                        
                                                                                                                                
                                                                                                                                       
                                                                                                                                      
                                                                                                                                      
                                                                                                                              
                                                                                                                                  
                                                                                                                                
                       
                                                                                     
                                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCollaboration", propOrder = {
    "participant",
    "messageFlow",
    "artifact",
    "conversationNode",
    "conversationAssociation",
    "participantAssociation",
    "messageFlowAssociation",
    "correlationKey",
    "choreographyRef",
    "conversationLink"
})
@XmlSeeAlso({
    TGlobalConversation.class,
    TChoreography.class
})
public class TCollaboration
    extends TRootElement
{

    protected List<TParticipant> participant;
    protected List<TMessageFlow> messageFlow;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TArtifact>> artifact;
    @XmlElementRef(name = "conversationNode", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TConversationNode>> conversationNode;
    protected List<TConversationAssociation> conversationAssociation;
    protected List<TParticipantAssociation> participantAssociation;
    protected List<TMessageFlowAssociation> messageFlowAssociation;
    protected List<TCorrelationKey> correlationKey;
    protected List<QName> choreographyRef;
    protected List<TConversationLink> conversationLink;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "isClosed")
    protected Boolean isClosed;

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                            
       
       
       
    public List<TParticipant> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<TParticipant>();
        }
        return this.participant;
    }

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                            
       
       
       
    public List<TMessageFlow> getMessageFlow() {
        if (messageFlow == null) {
            messageFlow = new ArrayList<TMessageFlow>();
        }
        return this.messageFlow;
    }

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                                                            
                                                                  
                                                                     
                                                               
       
       
       
    public List<JAXBElement<? extends TArtifact>> getArtifact() {
        if (artifact == null) {
            artifact = new ArrayList<JAXBElement<? extends TArtifact>>();
        }
        return this.artifact;
    }

       
                                                       
       
          
                                                                 
                                                                 
                                                            
                                                                                            
       
          
                                                     
            
                                             
             
       
       
          
                                                               
                                                                      
                                                                   
                                                                       
                                                                       
       
       
       
    public List<JAXBElement<? extends TConversationNode>> getConversationNode() {
        if (conversationNode == null) {
            conversationNode = new ArrayList<JAXBElement<? extends TConversationNode>>();
        }
        return this.conversationNode;
    }

       
                                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                                   
       
          
                                                     
            
                                                    
             
       
       
          
                                                               
                                        
       
       
       
    public List<TConversationAssociation> getConversationAssociation() {
        if (conversationAssociation == null) {
            conversationAssociation = new ArrayList<TConversationAssociation>();
        }
        return this.conversationAssociation;
    }

       
                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                  
       
          
                                                     
            
                                                   
             
       
       
          
                                                               
                                       
       
       
       
    public List<TParticipantAssociation> getParticipantAssociation() {
        if (participantAssociation == null) {
            participantAssociation = new ArrayList<TParticipantAssociation>();
        }
        return this.participantAssociation;
    }

       
                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                  
       
          
                                                     
            
                                                   
             
       
       
          
                                                               
                                       
       
       
       
    public List<TMessageFlowAssociation> getMessageFlowAssociation() {
        if (messageFlowAssociation == null) {
            messageFlowAssociation = new ArrayList<TMessageFlowAssociation>();
        }
        return this.messageFlowAssociation;
    }

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                               
       
       
       
    public List<TCorrelationKey> getCorrelationKey() {
        if (correlationKey == null) {
            correlationKey = new ArrayList<TCorrelationKey>();
        }
        return this.correlationKey;
    }

       
                                                      
       
          
                                                                 
                                                                 
                                                            
                                                                                           
       
          
                                                     
            
                                            
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getChoreographyRef() {
        if (choreographyRef == null) {
            choreographyRef = new ArrayList<QName>();
        }
        return this.choreographyRef;
    }

       
                                                       
       
          
                                                                 
                                                                 
                                                            
                                                                                            
       
          
                                                     
            
                                             
             
       
       
          
                                                               
                                 
       
       
       
    public List<TConversationLink> getConversationLink() {
        if (conversationLink == null) {
            conversationLink = new ArrayList<TConversationLink>();
        }
        return this.conversationLink;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                               
       
              
                             
                           
           
       
    public boolean isIsClosed() {
        if (isClosed == null) {
            return false;
        } else {
            return isClosed;
        }
    }

       
                                               
       
                   
                            
                           
           
       
    public void setIsClosed(Boolean value) {
        this.isClosed = value;
    }

}
