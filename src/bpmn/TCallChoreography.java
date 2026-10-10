  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                               
                      
                                                                                                                                      
                       
                                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallChoreography", propOrder = {
    "participantAssociation"
})
public class TCallChoreography
    extends TChoreographyActivity
{

    protected List<TParticipantAssociation> participantAssociation;
    @XmlAttribute(name = "calledChoreographyRef")
    protected QName calledChoreographyRef;

       
                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                  
       
          
                                                     
            
                                                   
             
       
       
          
                                                               
                                       
       
       
       
    public List<TParticipantAssociation> getParticipantAssociation() {
        if (participantAssociation == null) {
            participantAssociation = new ArrayList<TParticipantAssociation>();
        }
        return this.participantAssociation;
    }

       
                                                            
       
              
                             
                         
           
       
    public QName getCalledChoreographyRef() {
        return calledChoreographyRef;
    }

       
                                                            
       
                   
                            
                         
           
       
    public void setCalledChoreographyRef(QName value) {
        this.calledChoreographyRef = value;
    }

}
