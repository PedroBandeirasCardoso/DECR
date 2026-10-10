  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                     
   
                                                                                               
   
        
                                             
                        
                                                                                      
                                                                                     
                                                                                    
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResourceParameter")
public class TResourceParameter
    extends TBaseElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "type")
    protected QName type;
    @XmlAttribute(name = "isRequired")
    protected Boolean isRequired;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                           
       
              
                             
                         
           
       
    public QName getType() {
        return type;
    }

       
                                           
       
                   
                            
                         
           
       
    public void setType(QName value) {
        this.type = value;
    }

       
                                                 
       
              
                             
                           
           
       
    public Boolean isIsRequired() {
        return isRequired;
    }

       
                                                 
       
                   
                            
                           
           
       
    public void setIsRequired(Boolean value) {
        this.isRequired = value;
    }

}
