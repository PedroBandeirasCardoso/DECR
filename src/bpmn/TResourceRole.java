  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


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
@XmlType(name = "tResourceRole", propOrder = {
    "resourceRef",
    "resourceParameterBinding",
    "resourceAssignmentExpression"
})
@XmlSeeAlso({
    TPerformer.class
})
public class TResourceRole
    extends TBaseElement
{

    protected QName resourceRef;
    protected List<TResourceParameterBinding> resourceParameterBinding;
    protected TResourceAssignmentExpression resourceAssignmentExpression;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                  
       
              
                             
                         
           
       
    public QName getResourceRef() {
        return resourceRef;
    }

       
                                                  
       
                   
                            
                         
           
       
    public void setResourceRef(QName value) {
        this.resourceRef = value;
    }

       
                                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                                    
       
          
                                                     
            
                                                     
             
       
       
          
                                                               
                                         
       
       
       
    public List<TResourceParameterBinding> getResourceParameterBinding() {
        if (resourceParameterBinding == null) {
            resourceParameterBinding = new ArrayList<TResourceParameterBinding>();
        }
        return this.resourceParameterBinding;
    }

       
                                                                   
       
              
                             
                                                 
           
       
    public TResourceAssignmentExpression getResourceAssignmentExpression() {
        return resourceAssignmentExpression;
    }

       
                                                                   
       
                   
                            
                                                 
           
       
    public void setResourceAssignmentExpression(TResourceAssignmentExpression value) {
        this.resourceAssignmentExpression = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
