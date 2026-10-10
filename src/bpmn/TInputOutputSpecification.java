  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                                            
   
                                                                                               
   
        
                                                    
                        
                                                                                      
                      
                                                                                                                         
                                                                                                                          
                                                                                                          
                                                                                                           
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputOutputSpecification", propOrder = {
    "dataInput",
    "dataOutput",
    "inputSet",
    "outputSet"
})
public class TInputOutputSpecification
    extends TBaseElement
{

    protected List<TDataInput> dataInput;
    protected List<TDataOutput> dataOutput;
    @XmlElement(required = true)
    protected List<TInputSet> inputSet;
    @XmlElement(required = true)
    protected List<TOutputSet> outputSet;

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TDataInput> getDataInput() {
        if (dataInput == null) {
            dataInput = new ArrayList<TDataInput>();
        }
        return this.dataInput;
    }

       
                                                 
       
          
                                                                 
                                                                 
                                                            
                                                                                      
       
          
                                                     
            
                                       
             
       
       
          
                                                               
                           
       
       
       
    public List<TDataOutput> getDataOutput() {
        if (dataOutput == null) {
            dataOutput = new ArrayList<TDataOutput>();
        }
        return this.dataOutput;
    }

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                         
       
       
       
    public List<TInputSet> getInputSet() {
        if (inputSet == null) {
            inputSet = new ArrayList<TInputSet>();
        }
        return this.inputSet;
    }

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TOutputSet> getOutputSet() {
        if (outputSet == null) {
            outputSet = new ArrayList<TOutputSet>();
        }
        return this.outputSet;
    }

}
