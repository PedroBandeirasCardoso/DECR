  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                                     
                                                                                                               
                                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBoundaryEvent")
public class TBoundaryEvent
    extends TCatchEvent
{

    @XmlAttribute(name = "cancelActivity")
    protected Boolean cancelActivity;
    @XmlAttribute(name = "attachedToRef", required = true)
    protected QName attachedToRef;

       
                                                     
       
              
                             
                           
           
       
    public boolean isCancelActivity() {
        if (cancelActivity == null) {
            return true;
        } else {
            return cancelActivity;
        }
    }

       
                                                     
       
                   
                            
                           
           
       
    public void setCancelActivity(Boolean value) {
        this.cancelActivity = value;
    }

       
                                                    
       
              
                             
                         
           
       
    public QName getAttachedToRef() {
        return attachedToRef;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setAttachedToRef(QName value) {
        this.attachedToRef = value;
    }

}
