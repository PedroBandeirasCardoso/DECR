  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                        
   
                                                                                               
   
        
                                                
                        
                                                                                          
                                                                                        
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tErrorEventDefinition")
public class TErrorEventDefinition
    extends TEventDefinition
{

    @XmlAttribute(name = "errorRef")
    protected QName errorRef;

       
                                               
       
              
                             
                         
           
       
    public QName getErrorRef() {
        return errorRef;
    }

       
                                               
       
                   
                            
                         
           
       
    public void setErrorRef(QName value) {
        this.errorRef = value;
    }

}
