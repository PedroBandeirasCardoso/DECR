  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                
                      
                                                                                                                          
                                                                                                                                     
                                                                                                   
                                                                                                                               
                                                                                                                                     
                       
                                                                                                                  
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCatchEvent", propOrder = {
    "dataOutput",
    "dataOutputAssociation",
    "outputSet",
    "eventDefinition",
    "eventDefinitionRef"
})
@XmlSeeAlso({
    TStartEvent.class,
    TBoundaryEvent.class,
    TIntermediateCatchEvent.class
})
public abstract class TCatchEvent
    extends TEvent
{

    protected List<TDataOutput> dataOutput;
    protected List<TDataOutputAssociation> dataOutputAssociation;
    protected TOutputSet outputSet;
    @XmlElementRef(name = "eventDefinition", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TEventDefinition>> eventDefinition;
    protected List<QName> eventDefinitionRef;
    @XmlAttribute(name = "parallelMultiple")
    protected Boolean parallelMultiple;

       
                                                 
       
          
                                                                 
                                                                 
                                                            
                                                                                      
       
          
                                                     
            
                                       
             
       
       
          
                                                               
                           
       
       
       
    public List<TDataOutput> getDataOutput() {
        if (dataOutput == null) {
            dataOutput = new ArrayList<TDataOutput>();
        }
        return this.dataOutput;
    }

       
                                                            
       
          
                                                                 
                                                                 
                                                            
                                                                                                 
       
          
                                                     
            
                                                  
             
       
       
          
                                                               
                                      
       
       
       
    public List<TDataOutputAssociation> getDataOutputAssociation() {
        if (dataOutputAssociation == null) {
            dataOutputAssociation = new ArrayList<TDataOutputAssociation>();
        }
        return this.dataOutputAssociation;
    }

       
                                                
       
              
                             
                              
           
       
    public TOutputSet getOutputSet() {
        return outputSet;
    }

       
                                                
       
                   
                            
                              
           
       
    public void setOutputSet(TOutputSet value) {
        this.outputSet = value;
    }

       
                                                      
       
          
                                                                 
                                                                 
                                                            
                                                                                           
       
          
                                                     
            
                                            
             
       
       
          
                                                               
                                                                             
                                                                                
                                                                            
                                                                      
                                                                           
                                                                            
                                                                          
                                                                               
                                                                                
                                                                           
                                                                                 
       
       
       
    public List<JAXBElement<? extends TEventDefinition>> getEventDefinition() {
        if (eventDefinition == null) {
            eventDefinition = new ArrayList<JAXBElement<? extends TEventDefinition>>();
        }
        return this.eventDefinition;
    }

       
                                                         
       
          
                                                                 
                                                                 
                                                            
                                                                                              
       
          
                                                     
            
                                               
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getEventDefinitionRef() {
        if (eventDefinitionRef == null) {
            eventDefinitionRef = new ArrayList<QName>();
        }
        return this.eventDefinitionRef;
    }

       
                                                       
       
              
                             
                           
           
       
    public boolean isParallelMultiple() {
        if (parallelMultiple == null) {
            return false;
        } else {
            return parallelMultiple;
        }
    }

       
                                                       
       
                   
                            
                           
           
       
    public void setParallelMultiple(Boolean value) {
        this.parallelMultiple = value;
    }

}
