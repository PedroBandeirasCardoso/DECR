  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                          
   
                                                                                               
   
        
                                                  
                        
                                                                                       
                                                                                                        
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGlobalChoreographyTask")
public class TGlobalChoreographyTask
    extends TChoreography
{

    @XmlAttribute(name = "initiatingParticipantRef")
    protected QName initiatingParticipantRef;

       
                                                               
       
              
                             
                         
           
       
    public QName getInitiatingParticipantRef() {
        return initiatingParticipantRef;
    }

       
                                                               
       
                   
                            
                         
           
       
    public void setInitiatingParticipantRef(QName value) {
        this.initiatingParticipantRef = value;
    }

}
