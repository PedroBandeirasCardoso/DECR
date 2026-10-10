  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


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
@XmlType(name = "tOperation", propOrder = {
    "inMessageRef",
    "outMessageRef",
    "errorRef"
})
public class TOperation
    extends TBaseElement
{

    @XmlElement(required = true)
    protected QName inMessageRef;
    protected QName outMessageRef;
    protected List<QName> errorRef;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "implementationRef")
    protected QName implementationRef;

       
                                                   
       
              
                             
                         
           
       
    public QName getInMessageRef() {
        return inMessageRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setInMessageRef(QName value) {
        this.inMessageRef = value;
    }

       
                                                    
       
              
                             
                         
           
       
    public QName getOutMessageRef() {
        return outMessageRef;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setOutMessageRef(QName value) {
        this.outMessageRef = value;
    }

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getErrorRef() {
        if (errorRef == null) {
            errorRef = new ArrayList<QName>();
        }
        return this.errorRef;
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
