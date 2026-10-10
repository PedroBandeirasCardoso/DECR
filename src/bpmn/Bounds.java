  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                         
   
                                                                                               
   
        
                                 
                        
                                                                        
                                                                                                 
                                                                                                 
                                                                                                     
                                                                                                      
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bounds", namespace = "http://www.omg.org/spec/DD/20100524/DC")
public class Bounds {

    @XmlAttribute(name = "x", required = true)
    protected double x;
    @XmlAttribute(name = "y", required = true)
    protected double y;
    @XmlAttribute(name = "width", required = true)
    protected double width;
    @XmlAttribute(name = "height", required = true)
    protected double height;

       
                                        
       
       
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

       
                                            
       
       
    public double getWidth() {
        return width;
    }

       
                                            
       
       
    public void setWidth(double value) {
        this.width = value;
    }

       
                                             
       
       
    public double getHeight() {
        return height;
    }

       
                                             
       
       
    public void setHeight(double value) {
        this.height = value;
    }

}
