  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                           
   
                                                                                               
   
        
                                                   
                        
                                                                                      
                                                                                                 
                                                                                                 
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParticipantMultiplicity")
public class TParticipantMultiplicity
    extends TBaseElement
{

    @XmlAttribute(name = "minimum")
    protected Integer minimum;
    @XmlAttribute(name = "maximum")
    protected Integer maximum;

       
                                              
       
              
                             
                           
           
       
    public int getMinimum() {
        if (minimum == null) {
            return  0;
        } else {
            return minimum;
        }
    }

       
                                              
       
                   
                            
                           
           
       
    public void setMinimum(Integer value) {
        this.minimum = value;
    }

       
                                              
       
              
                             
                           
           
       
    public int getMaximum() {
        if (maximum == null) {
            return  1;
        } else {
            return maximum;
        }
    }

       
                                              
       
                   
                            
                           
           
       
    public void setMaximum(Integer value) {
        this.maximum = value;
    }

}
