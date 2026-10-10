  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                                            
   
                                                                                               
   
        
                                                    
                        
                                                                                      
                      
                                                                                      
                       
                                                                                                           
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResourceParameterBinding", propOrder = {
    "expression"
})
public class TResourceParameterBinding
    extends TBaseElement
{

    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected JAXBElement<? extends TExpression> expression;
    @XmlAttribute(name = "parameterRef", required = true)
    protected QName parameterRef;

       
                                                 
       
              
                             
                                                                           
                                                                     
           
       
    public JAXBElement<? extends TExpression> getExpression() {
        return expression;
    }

       
                                                 
       
                   
                            
                                                                           
                                                                     
           
       
    public void setExpression(JAXBElement<? extends TExpression> value) {
        this.expression = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getParameterRef() {
        return parameterRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setParameterRef(QName value) {
        this.parameterRef = value;
    }

}
