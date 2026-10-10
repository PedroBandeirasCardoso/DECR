  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


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
@XmlType(name = "tInterface", propOrder = {
    "operation"
})
public class TInterface
    extends TRootElement
{

    @XmlElement(required = true)
    protected List<TOperation> operation;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "implementationRef")
    protected QName implementationRef;

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TOperation> getOperation() {
        if (operation == null) {
            operation = new ArrayList<TOperation>();
        }
        return this.operation;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                        
       
              
                             
                         
           
       
    public QName getImplementationRef() {
        return implementationRef;
    }

       
                                                        
       
                   
                            
                         
           
       
    public void setImplementationRef(QName value) {
        this.implementationRef = value;
    }

}
