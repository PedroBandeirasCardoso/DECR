  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                                   
                                                                                                        
                                                                                                        
                                                                                                                                              
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAssociation")
public class TAssociation
    extends TArtifact
{

    @XmlAttribute(name = "sourceRef", required = true)
    protected QName sourceRef;
    @XmlAttribute(name = "targetRef", required = true)
    protected QName targetRef;
    @XmlAttribute(name = "associationDirection")
    protected TAssociationDirection associationDirection;

       
                                                
       
              
                             
                         
           
       
    public QName getSourceRef() {
        return sourceRef;
    }

       
                                                
       
                   
                            
                         
           
       
    public void setSourceRef(QName value) {
        this.sourceRef = value;
    }

       
                                                
       
              
                             
                         
           
       
    public QName getTargetRef() {
        return targetRef;
    }

       
                                                
       
                   
                            
                         
           
       
    public void setTargetRef(QName value) {
        this.targetRef = value;
    }

       
                                                           
       
              
                             
                                         
           
       
    public TAssociationDirection getAssociationDirection() {
        if (associationDirection == null) {
            return TAssociationDirection.NONE;
        } else {
            return associationDirection;
        }
    }

       
                                                           
       
                   
                            
                                         
           
       
    public void setAssociationDirection(TAssociationDirection value) {
        this.associationDirection = value;
    }

}
