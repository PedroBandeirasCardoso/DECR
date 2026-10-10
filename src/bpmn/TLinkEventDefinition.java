  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                       
   
                                                                                               
   
        
                                               
                        
                                                                                          
                      
                                                                                                                         
                                                                                                   
                       
                                                                                                    
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLinkEventDefinition", propOrder = {
    "source",
    "target"
})
public class TLinkEventDefinition
    extends TEventDefinition
{

    protected List<QName> source;
    protected QName target;
    @XmlAttribute(name = "name", required = true)
    protected String name;

       
                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                  
       
          
                                                     
            
                                   
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getSource() {
        if (source == null) {
            source = new ArrayList<QName>();
        }
        return this.source;
    }

       
                                             
       
              
                             
                         
           
       
    public QName getTarget() {
        return target;
    }

       
                                             
       
                   
                            
                         
           
       
    public void setTarget(QName value) {
        this.target = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
