  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                              
   
                                                                                               
   
        
                                                      
                        
                                                                                      
                      
                                                                                                              
                       
                                                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationPropertyBinding", propOrder = {
    "dataPath"
})
public class TCorrelationPropertyBinding
    extends TBaseElement
{

    @XmlElement(required = true)
    protected TFormalExpression dataPath;
    @XmlAttribute(name = "correlationPropertyRef", required = true)
    protected QName correlationPropertyRef;

       
                                               
       
              
                             
                                     
           
       
    public TFormalExpression getDataPath() {
        return dataPath;
    }

       
                                               
       
                   
                            
                                     
           
       
    public void setDataPath(TFormalExpression value) {
        this.dataPath = value;
    }

       
                                                             
       
              
                             
                         
           
       
    public QName getCorrelationPropertyRef() {
        return correlationPropertyRef;
    }

       
                                                             
       
                   
                            
                         
           
       
    public void setCorrelationPropertyRef(QName value) {
        this.correlationPropertyRef = value;
    }

}
