  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
   
        
                                   
                        
                                                                                      
                                                                                     
                                                                                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tMessage")
public class TMessage
    extends TRootElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "itemRef")
    protected QName itemRef;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                              
       
              
                             
                         
           
       
    public QName getItemRef() {
        return itemRef;
    }

       
                                              
       
                   
                            
                         
           
       
    public void setItemRef(QName value) {
        this.itemRef = value;
    }

}
