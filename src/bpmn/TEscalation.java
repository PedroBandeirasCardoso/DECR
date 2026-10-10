  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                      
                                                                                     
                                                                                               
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEscalation")
public class TEscalation
    extends TRootElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "escalationCode")
    protected String escalationCode;
    @XmlAttribute(name = "structureRef")
    protected QName structureRef;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                     
       
              
                             
                          
           
       
    public String getEscalationCode() {
        return escalationCode;
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setEscalationCode(String value) {
        this.escalationCode = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getStructureRef() {
        return structureRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setStructureRef(QName value) {
        this.structureRef = value;
    }

}
