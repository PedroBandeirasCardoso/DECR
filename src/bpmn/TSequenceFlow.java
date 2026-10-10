  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                
   
                                                                                               
   
        
                                        
                        
                                                                                      
                      
                                                                                                                                 
                       
                                                                                                        
                                                                                                        
                                                                                             
                                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSequenceFlow", propOrder = {
    "conditionExpression"
})
public class TSequenceFlow
    extends TFlowElement
{

    protected TExpression conditionExpression;
    @XmlAttribute(name = "sourceRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sourceRef;
    @XmlAttribute(name = "targetRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object targetRef;
    @XmlAttribute(name = "isImmediate")
    protected Boolean isImmediate;
    @XmlAttribute(name = "probability")
    protected Double probability;

       
                                                          
       
              
                             
                               
           
       
    public TExpression getConditionExpression() {
        return conditionExpression;
    }

       
                                                          
       
                   
                            
                               
           
       
    public void setConditionExpression(TExpression value) {
        this.conditionExpression = value;
    }

       
                                                
       
              
                             
                          
           
       
    public Object getSourceRef() {
        return sourceRef;
    }

       
                                                
       
                   
                            
                          
           
       
    public void setSourceRef(Object value) {
        this.sourceRef = value;
    }

       
                                                
       
              
                             
                          
           
       
    public Object getTargetRef() {
        return targetRef;
    }

       
                                                
       
                   
                            
                          
           
       
    public void setTargetRef(Object value) {
        this.targetRef = value;
    }

       
                                                  
       
              
                             
                           
           
       
    public Boolean isIsImmediate() {
        return isImmediate;
    }

       
                                                  
       
                   
                            
                           
           
       
    public void setIsImmediate(Boolean value) {
        this.isImmediate = value;
    }

       
                                                  
       
              
                             
                          
           
       
    public double getProbability() {
        if (probability == null) {
            return  1.0D;
        } else {
            return probability;
        }
    }

       
                                                  
       
                   
                            
                          
           
       
    public void setProbability(Double value) {
        this.probability = value;
    }

}
