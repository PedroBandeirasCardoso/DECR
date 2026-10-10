  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                      
                      
                                                                                                                                
                                                                                                                                    
                                                                                                                                          
                                                                                                                                
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputSet", propOrder = {
    "dataInputRefs",
    "optionalInputRefs",
    "whileExecutingInputRefs",
    "outputSetRefs"
})
public class TInputSet
    extends TBaseElement
{

    @XmlElementRef(name = "dataInputRefs", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> dataInputRefs;
    @XmlElementRef(name = "optionalInputRefs", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> optionalInputRefs;
    @XmlElementRef(name = "whileExecutingInputRefs", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> whileExecutingInputRefs;
    @XmlElementRef(name = "outputSetRefs", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> outputSetRefs;
    @XmlAttribute(name = "name")
    protected String name;

       
                                                    
       
          
                                                                 
                                                                 
                                                            
                                                                                         
       
          
                                                     
            
                                          
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getDataInputRefs() {
        if (dataInputRefs == null) {
            dataInputRefs = new ArrayList<JAXBElement<Object>>();
        }
        return this.dataInputRefs;
    }

       
                                                        
       
          
                                                                 
                                                                 
                                                            
                                                                                             
       
          
                                                     
            
                                              
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getOptionalInputRefs() {
        if (optionalInputRefs == null) {
            optionalInputRefs = new ArrayList<JAXBElement<Object>>();
        }
        return this.optionalInputRefs;
    }

       
                                                              
       
          
                                                                 
                                                                 
                                                            
                                                                                                   
       
          
                                                     
            
                                                    
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getWhileExecutingInputRefs() {
        if (whileExecutingInputRefs == null) {
            whileExecutingInputRefs = new ArrayList<JAXBElement<Object>>();
        }
        return this.whileExecutingInputRefs;
    }

       
                                                    
       
          
                                                                 
                                                                 
                                                            
                                                                                         
       
          
                                                     
            
                                          
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getOutputSetRefs() {
        if (outputSetRefs == null) {
            outputSetRefs = new ArrayList<JAXBElement<Object>>();
        }
        return this.outputSetRefs;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

}
