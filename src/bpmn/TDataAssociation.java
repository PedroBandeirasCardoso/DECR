  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                      
                      
                                                                                                                            
                                                                                        
                                                                                                                                  
                                                                                                                          
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataAssociation", propOrder = {
    "sourceRef",
    "targetRef",
    "transformation",
    "assignment"
})
@XmlSeeAlso({
    TDataInputAssociation.class,
    TDataOutputAssociation.class
})
public class TDataAssociation
    extends TBaseElement
{

    @XmlElementRef(name = "sourceRef", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> sourceRef;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object targetRef;
    protected TFormalExpression transformation;
    protected List<TAssignment> assignment;

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getSourceRef() {
        if (sourceRef == null) {
            sourceRef = new ArrayList<JAXBElement<Object>>();
        }
        return this.sourceRef;
    }

       
                                                
       
              
                             
                          
           
       
    public Object getTargetRef() {
        return targetRef;
    }

       
                                                
       
                   
                            
                          
           
       
    public void setTargetRef(Object value) {
        this.targetRef = value;
    }

       
                                                     
       
              
                             
                                     
           
       
    public TFormalExpression getTransformation() {
        return transformation;
    }

       
                                                     
       
                   
                            
                                     
           
       
    public void setTransformation(TFormalExpression value) {
        this.transformation = value;
    }

       
                                                 
       
          
                                                                 
                                                                 
                                                            
                                                                                      
       
          
                                                     
            
                                       
             
       
       
          
                                                               
                           
       
       
       
    public List<TAssignment> getAssignment() {
        if (assignment == null) {
            assignment = new ArrayList<TAssignment>();
        }
        return this.assignment;
    }

}
