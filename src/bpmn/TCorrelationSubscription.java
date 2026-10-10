  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                           
   
                                                                                               
   
        
                                                   
                        
                                                                                      
                      
                                                                                                                                          
                       
                                                                                                                
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationSubscription", propOrder = {
    "correlationPropertyBinding"
})
public class TCorrelationSubscription
    extends TBaseElement
{

    protected List<TCorrelationPropertyBinding> correlationPropertyBinding;
    @XmlAttribute(name = "correlationKeyRef", required = true)
    protected QName correlationKeyRef;

       
                                                                 
       
          
                                                                 
                                                                 
                                                            
                                                                                                      
       
          
                                                     
            
                                                       
             
       
       
          
                                                               
                                           
       
       
       
    public List<TCorrelationPropertyBinding> getCorrelationPropertyBinding() {
        if (correlationPropertyBinding == null) {
            correlationPropertyBinding = new ArrayList<TCorrelationPropertyBinding>();
        }
        return this.correlationPropertyBinding;
    }

       
                                                        
       
              
                             
                         
           
       
    public QName getCorrelationKeyRef() {
        return correlationKeyRef;
    }

       
                                                        
       
                   
                            
                         
           
       
    public void setCorrelationKeyRef(QName value) {
        this.correlationKeyRef = value;
    }

}
