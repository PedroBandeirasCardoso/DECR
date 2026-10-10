  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                        
   
                                                                                               
   
        
                                
                        
                                                                        
                                                                                                 
                                                                                                 
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Point", namespace = "http://www.omg.org/spec/DD/20100524/DC")
public class Point {

    @XmlAttribute(name = "x", required = true)
    protected double x;
    @XmlAttribute(name = "y", required = true)
    protected double y;

       
                                        
       
       
    public double getX() {
        return x;
    }

       
                                        
       
       
    public void setX(double value) {
        this.x = value;
    }

       
                                        
       
       
    public double getY() {
        return y;
    }

       
                                        
       
       
    public void setY(double value) {
        this.y = value;
    }

}
