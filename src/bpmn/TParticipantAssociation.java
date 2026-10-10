  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                          
   
                                                                                               
   
        
                                                  
                        
                                                                                      
                      
                                                                                                  
                                                                                                  
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParticipantAssociation", propOrder = {
    "innerParticipantRef",
    "outerParticipantRef"
})
public class TParticipantAssociation
    extends TBaseElement
{

    @XmlElement(required = true)
    protected QName innerParticipantRef;
    @XmlElement(required = true)
    protected QName outerParticipantRef;

       
                                                          
       
              
                             
                         
           
       
    public QName getInnerParticipantRef() {
        return innerParticipantRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setInnerParticipantRef(QName value) {
        this.innerParticipantRef = value;
    }

       
                                                          
       
              
                             
                         
           
       
    public QName getOuterParticipantRef() {
        return outerParticipantRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setOuterParticipantRef(QName value) {
        this.outerParticipantRef = value;
    }

}
