  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                          
   
                                                                                               
   
        
                                                  
                        
                                                                                      
                                                                                                                  
                                                                                                                  
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tMessageFlowAssociation")
public class TMessageFlowAssociation
    extends TBaseElement
{

    @XmlAttribute(name = "innerMessageFlowRef", required = true)
    protected QName innerMessageFlowRef;
    @XmlAttribute(name = "outerMessageFlowRef", required = true)
    protected QName outerMessageFlowRef;

       
                                                          
       
              
                             
                         
           
       
    public QName getInnerMessageFlowRef() {
        return innerMessageFlowRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setInnerMessageFlowRef(QName value) {
        this.innerMessageFlowRef = value;
    }

       
                                                          
       
              
                             
                         
           
       
    public QName getOuterMessageFlowRef() {
        return outerMessageFlowRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setOuterMessageFlowRef(QName value) {
        this.outerMessageFlowRef = value;
    }

}
