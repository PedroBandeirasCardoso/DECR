  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                               
                      
                                                                                                                         
                       
                                                                                                                                           
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserTask", propOrder = {
    "rendering"
})
public class TUserTask
    extends TTask
{

    protected List<TRendering> rendering;
    @XmlAttribute(name = "implementation")
    protected String implementation;

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TRendering> getRendering() {
        if (rendering == null) {
            rendering = new ArrayList<TRendering>();
        }
        return this.rendering;
    }

       
                                                     
       
              
                             
                          
           
       
    public String getImplementation() {
        if (implementation == null) {
            return "##unspecified";
        } else {
            return implementation;
        }
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setImplementation(String value) {
        this.implementation = value;
    }

}
