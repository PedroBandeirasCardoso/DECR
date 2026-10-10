  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                  
   
                                                                                               
   
        
                                          
                        
                                                                                      
                                                                                            
                                                                                                              
                                                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tItemDefinition")
public class TItemDefinition
    extends TRootElement
{

    @XmlAttribute(name = "structureRef")
    protected QName structureRef;
    @XmlAttribute(name = "isCollection")
    protected Boolean isCollection;
    @XmlAttribute(name = "itemKind")
    protected TItemKind itemKind;

       
                                                   
       
              
                             
                         
           
       
    public QName getStructureRef() {
        return structureRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setStructureRef(QName value) {
        this.structureRef = value;
    }

       
                                                   
       
              
                             
                           
           
       
    public boolean isIsCollection() {
        if (isCollection == null) {
            return false;
        } else {
            return isCollection;
        }
    }

       
                                                   
       
                   
                            
                           
           
       
    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

       
                                               
       
              
                             
                             
           
       
    public TItemKind getItemKind() {
        if (itemKind == null) {
            return TItemKind.INFORMATION;
        } else {
            return itemKind;
        }
    }

       
                                               
       
                   
                            
                             
           
       
    public void setItemKind(TItemKind value) {
        this.itemKind = value;
    }

}
