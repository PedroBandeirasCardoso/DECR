  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                               
                                                                                                                                          
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tServiceTask")
public class TServiceTask
    extends TTask
{

    @XmlAttribute(name = "implementation")
    protected String implementation;
    @XmlAttribute(name = "operationRef")
    protected QName operationRef;

       
                                                     
       
              
                             
                          
           
       
    public String getImplementation() {
        if (implementation == null) {
            return "##WebService";
        } else {
            return implementation;
        }
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setImplementation(String value) {
        this.implementation = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getOperationRef() {
        return operationRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setOperationRef(QName value) {
        this.operationRef = value;
    }

}
