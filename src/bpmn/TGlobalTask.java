  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                          
                      
                                                                                                                            
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGlobalTask", propOrder = {
    "resourceRole"
})
@XmlSeeAlso({
    TGlobalUserTask.class,
    TGlobalManualTask.class,
    TGlobalBusinessRuleTask.class,
    TGlobalScriptTask.class
})
public class TGlobalTask
    extends TCallableElement
{

    @XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TResourceRole>> resourceRole;

       
                                                   
       
          
                                                                 
                                                                 
                                                            
                                                                                        
       
          
                                                     
            
                                         
             
       
       
          
                                                               
                                                                     
                                                                     
                                                                   
                                                                
       
       
       
    public List<JAXBElement<? extends TResourceRole>> getResourceRole() {
        if (resourceRole == null) {
            resourceRole = new ArrayList<JAXBElement<? extends TResourceRole>>();
        }
        return this.resourceRole;
    }

}
