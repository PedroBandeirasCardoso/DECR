  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                       
   
                                                                                               
   
        
                               
                        
                                                                                   
                      
                                                                                                                                 
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Edge", namespace = "http://www.omg.org/spec/DD/20100524/DI", propOrder = {
    "waypoint"
})
@XmlSeeAlso({
    LabeledEdge.class
})
public abstract class Edge
    extends DiagramElement
{

    @XmlElement(required = true)
    protected List<Point> waypoint;

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                     
       
       
       
    public List<Point> getWaypoint() {
        if (waypoint == null) {
            waypoint = new ArrayList<Point>();
        }
        return this.waypoint;
    }

}
