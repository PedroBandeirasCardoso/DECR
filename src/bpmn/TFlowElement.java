  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


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
@XmlType(name = "tFlowElement", propOrder = {
    "auditing",
    "monitoring",
    "categoryValueRef"
})
@XmlSeeAlso({
    TSequenceFlow.class,
    TDataStoreReference.class,
    TDataObject.class,
    TDataObjectReference.class,
    TFlowNode.class
})
public abstract class TFlowElement
    extends TBaseElement
{

    protected TAuditing auditing;
    protected TMonitoring monitoring;
    protected List<QName> categoryValueRef;
    @XmlAttribute(name = "name")
    protected String name;

       
                                               
       
              
                             
                             
           
       
    public TAuditing getAuditing() {
        return auditing;
    }

       
                                               
       
                   
                            
                             
           
       
    public void setAuditing(TAuditing value) {
        this.auditing = value;
    }

       
                                                 
       
              
                             
                               
           
       
    public TMonitoring getMonitoring() {
        return monitoring;
    }

       
                                                 
       
                   
                            
                               
           
       
    public void setMonitoring(TMonitoring value) {
        this.monitoring = value;
    }

       
                                                       
       
          
                                                                 
                                                                 
                                                            
                                                                                            
       
          
                                                     
            
                                             
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getCategoryValueRef() {
        if (categoryValueRef == null) {
            categoryValueRef = new ArrayList<QName>();
        }
        return this.categoryValueRef;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
