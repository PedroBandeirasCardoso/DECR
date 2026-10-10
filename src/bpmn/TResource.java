  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                      
                      
                                                                                                                                 
                       
                                                                                                    
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResource", propOrder = {
    "resourceParameter"
})
public class TResource
    extends TRootElement
{

    protected List<TResourceParameter> resourceParameter;
    @XmlAttribute(name = "name", required = true)
    protected String name;

       
                                                        
       
          
                                                                 
                                                                 
                                                            
                                                                                             
       
          
                                                     
            
                                              
             
       
       
          
                                                               
                                  
       
       
       
    public List<TResourceParameter> getResourceParameter() {
        if (resourceParameter == null) {
            resourceParameter = new ArrayList<TResourceParameter>();
        }
        return this.resourceParameter;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
