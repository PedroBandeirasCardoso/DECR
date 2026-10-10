  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                             
   
                                                                                               
   
        
                                                     
                        
                                                                                          
                                                                                                   
                                                                                           
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCompensateEventDefinition")
public class TCompensateEventDefinition
    extends TEventDefinition
{

    @XmlAttribute(name = "waitForCompletion")
    protected Boolean waitForCompletion;
    @XmlAttribute(name = "activityRef")
    protected QName activityRef;

       
                                                        
       
              
                             
                           
           
       
    public Boolean isWaitForCompletion() {
        return waitForCompletion;
    }

       
                                                        
       
                   
                            
                           
           
       
    public void setWaitForCompletion(Boolean value) {
        this.waitForCompletion = value;
    }

       
                                                  
       
              
                             
                         
           
       
    public QName getActivityRef() {
        return activityRef;
    }

       
                                                  
       
                   
                            
                         
           
       
    public void setActivityRef(QName value) {
        this.activityRef = value;
    }

}
