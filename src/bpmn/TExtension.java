  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                             
   
                                                                                               
   
        
                                     
                        
                                                                        
                      
                                                                                                                             
                       
                                                                                          
                                                                                                                
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tExtension", propOrder = {
    "documentation"
})
public class TExtension {

    protected List<TDocumentation> documentation;
    @XmlAttribute(name = "definition")
    protected QName definition;
    @XmlAttribute(name = "mustUnderstand")
    protected Boolean mustUnderstand;

       
                                                    
       
          
                                                                 
                                                                 
                                                            
                                                                                         
       
          
                                                     
            
                                          
             
       
       
          
                                                               
                              
       
       
       
    public List<TDocumentation> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<TDocumentation>();
        }
        return this.documentation;
    }

       
                                                 
       
              
                             
                         
           
       
    public QName getDefinition() {
        return definition;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setDefinition(QName value) {
        this.definition = value;
    }

       
                                                     
       
              
                             
                           
           
       
    public boolean isMustUnderstand() {
        if (mustUnderstand == null) {
            return false;
        } else {
            return mustUnderstand;
        }
    }

       
                                                     
       
                   
                            
                           
           
       
    public void setMustUnderstand(Boolean value) {
        this.mustUnderstand = value;
    }

}
