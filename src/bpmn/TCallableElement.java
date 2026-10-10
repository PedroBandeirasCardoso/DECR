  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                      
                      
                                                                                                                                        
                                                                                                         
                                                                                                                         
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallableElement", propOrder = {
    "supportedInterfaceRef",
    "ioSpecification",
    "ioBinding"
})
@XmlSeeAlso({
    TProcess.class,
    TGlobalTask.class
})
public class TCallableElement
    extends TRootElement
{

    protected List<QName> supportedInterfaceRef;
    protected TInputOutputSpecification ioSpecification;
    protected List<TInputOutputBinding> ioBinding;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                            
       
          
                                                                 
                                                                 
                                                            
                                                                                                 
       
          
                                                     
            
                                                  
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getSupportedInterfaceRef() {
        if (supportedInterfaceRef == null) {
            supportedInterfaceRef = new ArrayList<QName>();
        }
        return this.supportedInterfaceRef;
    }

       
                                                      
       
              
                             
                                             
           
       
    public TInputOutputSpecification getIoSpecification() {
        return ioSpecification;
    }

       
                                                      
       
                   
                            
                                             
           
       
    public void setIoSpecification(TInputOutputSpecification value) {
        this.ioSpecification = value;
    }

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                                   
       
       
       
    public List<TInputOutputBinding> getIoBinding() {
        if (ioBinding == null) {
            ioBinding = new ArrayList<TInputOutputBinding>();
        }
        return this.ioBinding;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
