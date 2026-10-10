  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                        
   
                                                                                               
   
        
                                                
                        
                                                                                   
                      
                                                                                                                                 
                                                                                                                              
                       
                                                                                                                       
                                                                                                                                  
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tChoreographyActivity", propOrder = {
    "participantRef",
    "correlationKey"
})
@XmlSeeAlso({
    TCallChoreography.class,
    TSubChoreography.class,
    TChoreographyTask.class
})
public abstract class TChoreographyActivity
    extends TFlowNode
{

    @XmlElement(required = true)
    protected List<QName> participantRef;
    protected List<TCorrelationKey> correlationKey;
    @XmlAttribute(name = "initiatingParticipantRef", required = true)
    protected QName initiatingParticipantRef;
    @XmlAttribute(name = "loopType")
    protected TChoreographyLoopType loopType;

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getParticipantRef() {
        if (participantRef == null) {
            participantRef = new ArrayList<QName>();
        }
        return this.participantRef;
    }

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                               
       
       
       
    public List<TCorrelationKey> getCorrelationKey() {
        if (correlationKey == null) {
            correlationKey = new ArrayList<TCorrelationKey>();
        }
        return this.correlationKey;
    }

       
                                                               
       
              
                             
                         
           
       
    public QName getInitiatingParticipantRef() {
        return initiatingParticipantRef;
    }

       
                                                               
       
                   
                            
                         
           
       
    public void setInitiatingParticipantRef(QName value) {
        this.initiatingParticipantRef = value;
    }

       
                                               
       
              
                             
                                         
           
       
    public TChoreographyLoopType getLoopType() {
        if (loopType == null) {
            return TChoreographyLoopType.NONE;
        } else {
            return loopType;
        }
    }

       
                                               
       
                   
                            
                                         
           
       
    public void setLoopType(TChoreographyLoopType value) {
        this.loopType = value;
    }

}
