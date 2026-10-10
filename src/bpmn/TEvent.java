  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                         
   
                                                                                               
   
        
                                 
                        
                                                                                   
                      
                                                                                                                        
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEvent", propOrder = {
    "property"
})
@XmlSeeAlso({
    TCatchEvent.class,
    TThrowEvent.class
})
public abstract class TEvent
    extends TFlowNode
{

    protected List<TProperty> property;

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                         
       
       
       
    public List<TProperty> getProperty() {
        if (property == null) {
            property = new ArrayList<TProperty>();
        }
        return this.property;
    }

}
