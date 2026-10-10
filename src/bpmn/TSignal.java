  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                          
   
                                                                                               
   
        
                                  
                        
                                                                                      
                                                                                     
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSignal")
public class TSignal
    extends TRootElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "structureRef")
    protected QName structureRef;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getStructureRef() {
        return structureRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setStructureRef(QName value) {
        this.structureRef = value;
    }

}
