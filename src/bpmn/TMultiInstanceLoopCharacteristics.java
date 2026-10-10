  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                                    
   
                                                                                               
   
        
                                                            
                        
                                                                                              
                      
                                                                                                                             
                                                                                                             
                                                                                                              
                                                                                                                          
                                                                                                                            
                                                                                                                                         
                                                                                                                                 
                       
                                                                                                              
                                                                                                                                       
                                                                                                   
                                                                                                    
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tMultiInstanceLoopCharacteristics", propOrder = {
    "loopCardinality",
    "loopDataInputRef",
    "loopDataOutputRef",
    "inputDataItem",
    "outputDataItem",
    "complexBehaviorDefinition",
    "completionCondition"
})
public class TMultiInstanceLoopCharacteristics
    extends TLoopCharacteristics
{

    protected TExpression loopCardinality;
    protected QName loopDataInputRef;
    protected QName loopDataOutputRef;
    protected TDataInput inputDataItem;
    protected TDataOutput outputDataItem;
    protected List<TComplexBehaviorDefinition> complexBehaviorDefinition;
    protected TExpression completionCondition;
    @XmlAttribute(name = "isSequential")
    protected Boolean isSequential;
    @XmlAttribute(name = "behavior")
    protected TMultiInstanceFlowCondition behavior;
    @XmlAttribute(name = "oneBehaviorEventRef")
    protected QName oneBehaviorEventRef;
    @XmlAttribute(name = "noneBehaviorEventRef")
    protected QName noneBehaviorEventRef;

       
                                                      
       
              
                             
                               
           
       
    public TExpression getLoopCardinality() {
        return loopCardinality;
    }

       
                                                      
       
                   
                            
                               
           
       
    public void setLoopCardinality(TExpression value) {
        this.loopCardinality = value;
    }

       
                                                       
       
              
                             
                         
           
       
    public QName getLoopDataInputRef() {
        return loopDataInputRef;
    }

       
                                                       
       
                   
                            
                         
           
       
    public void setLoopDataInputRef(QName value) {
        this.loopDataInputRef = value;
    }

       
                                                        
       
              
                             
                         
           
       
    public QName getLoopDataOutputRef() {
        return loopDataOutputRef;
    }

       
                                                        
       
                   
                            
                         
           
       
    public void setLoopDataOutputRef(QName value) {
        this.loopDataOutputRef = value;
    }

       
                                                    
       
              
                             
                              
           
       
    public TDataInput getInputDataItem() {
        return inputDataItem;
    }

       
                                                    
       
                   
                            
                              
           
       
    public void setInputDataItem(TDataInput value) {
        this.inputDataItem = value;
    }

       
                                                     
       
              
                             
                               
           
       
    public TDataOutput getOutputDataItem() {
        return outputDataItem;
    }

       
                                                     
       
                   
                            
                               
           
       
    public void setOutputDataItem(TDataOutput value) {
        this.outputDataItem = value;
    }

       
                                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                                     
       
          
                                                     
            
                                                      
             
       
       
          
                                                               
                                          
       
       
       
    public List<TComplexBehaviorDefinition> getComplexBehaviorDefinition() {
        if (complexBehaviorDefinition == null) {
            complexBehaviorDefinition = new ArrayList<TComplexBehaviorDefinition>();
        }
        return this.complexBehaviorDefinition;
    }

       
                                                          
       
              
                             
                               
           
       
    public TExpression getCompletionCondition() {
        return completionCondition;
    }

       
                                                          
       
                   
                            
                               
           
       
    public void setCompletionCondition(TExpression value) {
        this.completionCondition = value;
    }

       
                                                   
       
              
                             
                           
           
       
    public boolean isIsSequential() {
        if (isSequential == null) {
            return false;
        } else {
            return isSequential;
        }
    }

       
                                                   
       
                   
                            
                           
           
       
    public void setIsSequential(Boolean value) {
        this.isSequential = value;
    }

       
                                               
       
              
                             
                                               
           
       
    public TMultiInstanceFlowCondition getBehavior() {
        if (behavior == null) {
            return TMultiInstanceFlowCondition.ALL;
        } else {
            return behavior;
        }
    }

       
                                               
       
                   
                            
                                               
           
       
    public void setBehavior(TMultiInstanceFlowCondition value) {
        this.behavior = value;
    }

       
                                                          
       
              
                             
                         
           
       
    public QName getOneBehaviorEventRef() {
        return oneBehaviorEventRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setOneBehaviorEventRef(QName value) {
        this.oneBehaviorEventRef = value;
    }

       
                                                           
       
              
                             
                         
           
       
    public QName getNoneBehaviorEventRef() {
        return noneBehaviorEventRef;
    }

       
                                                           
       
                   
                            
                         
           
       
    public void setNoneBehaviorEventRef(QName value) {
        this.noneBehaviorEventRef = value;
    }

}
