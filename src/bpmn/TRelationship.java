  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                
   
                                                                                               
   
        
                                        
                        
                                                                                      
                      
                                                                                                           
                                                                                                           
                       
                                                                                                    
                                                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tRelationship", propOrder = {
    "source",
    "target"
})
public class TRelationship
    extends TBaseElement
{

    @XmlElement(required = true)
    protected List<QName> source;
    @XmlElement(required = true)
    protected List<QName> target;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "direction")
    protected TRelationshipDirection direction;

       
                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                  
       
          
                                                     
            
                                   
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getSource() {
        if (source == null) {
            source = new ArrayList<QName>();
        }
        return this.source;
    }

       
                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                  
       
          
                                                     
            
                                   
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getTarget() {
        if (target == null) {
            target = new ArrayList<QName>();
        }
        return this.target;
    }

       
                                           
       
              
                             
                          
           
       
    public String getType() {
        return type;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setType(String value) {
        this.type = value;
    }

       
                                                
       
              
                             
                                          
           
       
    public TRelationshipDirection getDirection() {
        return direction;
    }

       
                                                
       
                   
                            
                                          
           
       
    public void setDirection(TRelationshipDirection value) {
        this.direction = value;
    }

}
