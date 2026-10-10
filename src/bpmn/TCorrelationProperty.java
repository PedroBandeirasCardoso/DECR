  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                       
   
                                                                                               
   
        
                                               
                        
                                                                                      
                      
                                                                                                                                        
                       
                                                                                     
                                                                                    
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationProperty", propOrder = {
    "correlationPropertyRetrievalExpression"
})
public class TCorrelationProperty
    extends TRootElement
{

    @XmlElement(required = true)
    protected List<TCorrelationPropertyRetrievalExpression> correlationPropertyRetrievalExpression;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "type")
    protected QName type;

       
                                                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                                                  
       
          
                                                     
            
                                                                   
             
       
       
          
                                                               
                                                       
       
       
       
    public List<TCorrelationPropertyRetrievalExpression> getCorrelationPropertyRetrievalExpression() {
        if (correlationPropertyRetrievalExpression == null) {
            correlationPropertyRetrievalExpression = new ArrayList<TCorrelationPropertyRetrievalExpression>();
        }
        return this.correlationPropertyRetrievalExpression;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                           
       
              
                             
                         
           
       
    public QName getType() {
        return type;
    }

       
                                           
       
                   
                            
                         
           
       
    public void setType(QName value) {
        this.type = value;
    }

}
