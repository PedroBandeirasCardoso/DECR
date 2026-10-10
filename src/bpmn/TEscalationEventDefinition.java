  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                             
   
                                                                                               
   
        
                                                     
                        
                                                                                          
                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEscalationEventDefinition")
public class TEscalationEventDefinition
    extends TEventDefinition
{

    @XmlAttribute(name = "escalationRef")
    protected QName escalationRef;

       
                                                    
       
              
                             
                         
           
       
    public QName getEscalationRef() {
        return escalationRef;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setEscalationRef(QName value) {
        this.escalationRef = value;
    }

}
