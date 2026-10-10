  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                
                      
                                                                                                                         
                                                                                                                                    
                                                                                                  
                                                                                                                               
                                                                                                                                     
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tThrowEvent", propOrder = {
    "dataInput",
    "dataInputAssociation",
    "inputSet",
    "eventDefinition",
    "eventDefinitionRef"
})
@XmlSeeAlso({
    TEndEvent.class,
    TIntermediateThrowEvent.class,
    TImplicitThrowEvent.class
})
public abstract class TThrowEvent
    extends TEvent
{

    protected List<TDataInput> dataInput;
    protected List<TDataInputAssociation> dataInputAssociation;
    protected TInputSet inputSet;
    @XmlElementRef(name = "eventDefinition", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TEventDefinition>> eventDefinition;
    protected List<QName> eventDefinitionRef;

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TDataInput> getDataInput() {
        if (dataInput == null) {
            dataInput = new ArrayList<TDataInput>();
        }
        return this.dataInput;
    }

       
                                                           
       
          
                                                                 
                                                                 
                                                            
                                                                                                
       
          
                                                     
            
                                                 
             
       
       
          
                                                               
                                     
       
       
       
    public List<TDataInputAssociation> getDataInputAssociation() {
        if (dataInputAssociation == null) {
            dataInputAssociation = new ArrayList<TDataInputAssociation>();
        }
        return this.dataInputAssociation;
    }

       
                                               
       
              
                             
                             
           
       
    public TInputSet getInputSet() {
        return inputSet;
    }

       
                                               
       
                   
                            
                             
           
       
    public void setInputSet(TInputSet value) {
        this.inputSet = value;
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

}
