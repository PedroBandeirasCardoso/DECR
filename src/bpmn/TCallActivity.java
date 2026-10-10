  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                
   
                                                                                               
   
        
                                        
                        
                                                                                   
                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallActivity")
public class TCallActivity
    extends TActivity
{

    @XmlAttribute(name = "calledElement")
    protected QName calledElement;

       
                                                    
       
              
                             
                         
           
       
    public QName getCalledElement() {
        return calledElement;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setCalledElement(QName value) {
        this.calledElement = value;
    }

}
