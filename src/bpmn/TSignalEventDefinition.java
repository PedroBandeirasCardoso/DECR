  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                         
   
                                                                                               
   
        
                                                 
                        
                                                                                          
                                                                                         
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSignalEventDefinition")
public class TSignalEventDefinition
    extends TEventDefinition
{

    @XmlAttribute(name = "signalRef")
    protected QName signalRef;

       
                                                
       
              
                             
                         
           
       
    public QName getSignalRef() {
        return signalRef;
    }

       
                                                
       
                   
                            
                         
           
       
    public void setSignalRef(QName value) {
        this.signalRef = value;
    }

}
