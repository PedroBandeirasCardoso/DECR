  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                           
                      
                                                                                                                                      
                       
                                                                                                      
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallConversation", propOrder = {
    "participantAssociation"
})
public class TCallConversation
    extends TConversationNode
{

    protected List<TParticipantAssociation> participantAssociation;
    @XmlAttribute(name = "calledCollaborationRef")
    protected QName calledCollaborationRef;

       
                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                  
       
          
                                                     
            
                                                   
             
       
       
          
                                                               
                                       
       
       
       
    public List<TParticipantAssociation> getParticipantAssociation() {
        if (participantAssociation == null) {
            participantAssociation = new ArrayList<TParticipantAssociation>();
        }
        return this.participantAssociation;
    }

       
                                                             
       
              
                             
                         
           
       
    public QName getCalledCollaborationRef() {
        return calledCollaborationRef;
    }

       
                                                             
       
                   
                            
                         
           
       
    public void setCalledCollaborationRef(QName value) {
        this.calledCollaborationRef = value;
    }

}
