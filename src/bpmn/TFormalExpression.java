  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                     
                                                                                         
                                                                                                  
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFormalExpression")
public class TFormalExpression
    extends TExpression
{

    @XmlAttribute(name = "language")
    @XmlSchemaType(name = "anyURI")
    protected String language;
    @XmlAttribute(name = "evaluatesToTypeRef")
    protected QName evaluatesToTypeRef;

       
                                               
       
              
                             
                          
           
       
    public String getLanguage() {
        return language;
    }

       
                                               
       
                   
                            
                          
           
       
    public void setLanguage(String value) {
        this.language = value;
    }

       
                                                         
       
              
                             
                         
           
       
    public QName getEvaluatesToTypeRef() {
        return evaluatesToTypeRef;
    }

       
                                                         
       
                   
                            
                         
           
       
    public void setEvaluatesToTypeRef(QName value) {
        this.evaluatesToTypeRef = value;
    }

}
