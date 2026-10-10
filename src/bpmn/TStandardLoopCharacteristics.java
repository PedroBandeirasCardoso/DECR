  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                               
   
                                                                                               
   
        
                                                       
                        
                                                                                              
                      
                                                                                                                           
                       
                                                                                                            
                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tStandardLoopCharacteristics", propOrder = {
    "loopCondition"
})
public class TStandardLoopCharacteristics
    extends TLoopCharacteristics
{

    protected TExpression loopCondition;
    @XmlAttribute(name = "testBefore")
    protected Boolean testBefore;
    @XmlAttribute(name = "loopMaximum")
    protected BigInteger loopMaximum;

       
                                                    
       
              
                             
                               
           
       
    public TExpression getLoopCondition() {
        return loopCondition;
    }

       
                                                    
       
                   
                            
                               
           
       
    public void setLoopCondition(TExpression value) {
        this.loopCondition = value;
    }

       
                                                 
       
              
                             
                           
           
       
    public boolean isTestBefore() {
        if (testBefore == null) {
            return false;
        } else {
            return testBefore;
        }
    }

       
                                                 
       
                   
                            
                           
           
       
    public void setTestBefore(Boolean value) {
        this.testBefore = value;
    }

       
                                                  
       
              
                             
                              
           
       
    public BigInteger getLoopMaximum() {
        return loopMaximum;
    }

       
                                                  
       
                   
                            
                              
           
       
    public void setLoopMaximum(BigInteger value) {
        this.loopMaximum = value;
    }

}
