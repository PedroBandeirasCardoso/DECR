  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                         
   
                                                                                               
   
        
                                 
                        
                                                                                   
                                                                                                
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGroup")
public class TGroup
    extends TArtifact
{

    @XmlAttribute(name = "categoryValueRef")
    protected QName categoryValueRef;

       
                                                       
       
              
                             
                         
           
       
    public QName getCategoryValueRef() {
        return categoryValueRef;
    }

       
                                                       
       
                   
                            
                         
           
       
    public void setCategoryValueRef(QName value) {
        this.categoryValueRef = value;
    }

}
