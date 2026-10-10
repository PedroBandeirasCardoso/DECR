  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
   
        
                                   
                        
                                                                                      
                      
                                                                                                                    
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLaneSet", propOrder = {
    "lane"
})
public class TLaneSet
    extends TBaseElement
{

    protected List<TLane> lane;
    @XmlAttribute(name = "name")
    protected String name;

       
                                           
       
          
                                                                 
                                                                 
                                                            
                                                                                
       
          
                                                     
            
                                 
             
       
       
          
                                                               
                     
       
       
       
    public List<TLane> getLane() {
        if (lane == null) {
            lane = new ArrayList<TLane>();
        }
        return this.lane;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
