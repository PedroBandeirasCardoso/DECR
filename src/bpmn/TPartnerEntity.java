  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                                      
                      
                                                                                                                                 
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPartnerEntity", propOrder = {
    "participantRef"
})
public class TPartnerEntity
    extends TRootElement
{

    protected List<QName> participantRef;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                     
       
          
                                                                 
                                                                 
                                                            
                                                                                          
       
          
                                                     
            
                                           
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getParticipantRef() {
        if (participantRef == null) {
            participantRef = new ArrayList<QName>();
        }
        return this.participantRef;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
