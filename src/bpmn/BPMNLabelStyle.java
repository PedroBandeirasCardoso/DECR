  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                 
   
                                                                                               
   
        
                                         
                        
                                                                          
                      
                                                                           
                       
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNLabelStyle", namespace = "http://www.omg.org/spec/BPMN/20100524/DI", propOrder = {
    "font"
})
public class BPMNLabelStyle
    extends Style
{

    @XmlElement(name = "Font", namespace = "http://www.omg.org/spec/DD/20100524/DC", required = true)
    protected Font font;

       
                                           
       
              
                             
                        
           
       
    public Font getFont() {
        return font;
    }

       
                                           
       
                   
                            
                        
           
       
    public void setFont(Font value) {
        this.font = value;
    }

}
