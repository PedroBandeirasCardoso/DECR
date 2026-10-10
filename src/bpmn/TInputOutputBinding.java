  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                      
   
                                                                                               
   
        
                                              
                        
                                                                                      
                                                                                                           
                                                                                                           
                                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputOutputBinding")
public class TInputOutputBinding
    extends TBaseElement
{

    @XmlAttribute(name = "operationRef", required = true)
    protected QName operationRef;
    @XmlAttribute(name = "inputDataRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object inputDataRef;
    @XmlAttribute(name = "outputDataRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object outputDataRef;

       
                                                   
       
              
                             
                         
           
       
    public QName getOperationRef() {
        return operationRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setOperationRef(QName value) {
        this.operationRef = value;
    }

       
                                                   
       
              
                             
                          
           
       
    public Object getInputDataRef() {
        return inputDataRef;
    }

       
                                                   
       
                   
                            
                          
           
       
    public void setInputDataRef(Object value) {
        this.inputDataRef = value;
    }

       
                                                    
       
              
                             
                          
           
       
    public Object getOutputDataRef() {
        return outputDataRef;
    }

       
                                                    
       
                   
                            
                          
           
       
    public void setOutputDataRef(Object value) {
        this.outputDataRef = value;
    }

}
