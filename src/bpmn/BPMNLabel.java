  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                          
                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNLabel", namespace = "http://www.omg.org/spec/BPMN/20100524/DI")
public class BPMNLabel
    extends Label
{

    @XmlAttribute(name = "labelStyle")
    protected QName labelStyle;

       
                                                 
       
              
                             
                         
           
       
    public QName getLabelStyle() {
        return labelStyle;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setLabelStyle(QName value) {
        this.labelStyle = value;
    }

}
