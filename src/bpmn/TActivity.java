  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                   
                      
                                                                                                         
                                                                                                                        
                                                                                                                                    
                                                                                                                                     
                                                                                                                            
                                                                                                             
                       
                                                                                                                   
                                                                                                           
                                                                                                                
                                                                                       
                                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tActivity", propOrder = {
    "ioSpecification",
    "property",
    "dataInputAssociation",
    "dataOutputAssociation",
    "resourceRole",
    "loopCharacteristics"
})
@XmlSeeAlso({
    TSubProcess.class,
    TCallActivity.class,
    TTask.class
})
public abstract class TActivity
    extends TFlowNode
{

    protected TInputOutputSpecification ioSpecification;
    protected List<TProperty> property;
    protected List<TDataInputAssociation> dataInputAssociation;
    protected List<TDataOutputAssociation> dataOutputAssociation;
    @XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TResourceRole>> resourceRole;
    @XmlElementRef(name = "loopCharacteristics", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends TLoopCharacteristics> loopCharacteristics;
    @XmlAttribute(name = "isForCompensation")
    protected Boolean isForCompensation;
    @XmlAttribute(name = "startQuantity")
    protected BigInteger startQuantity;
    @XmlAttribute(name = "completionQuantity")
    protected BigInteger completionQuantity;
    @XmlAttribute(name = "default")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object _default;
    @XmlAttribute(name = "reliability")
    protected Double reliability;

       
                                                      
       
              
                             
                                             
           
       
    public TInputOutputSpecification getIoSpecification() {
        return ioSpecification;
    }

       
                                                      
       
                   
                            
                                             
           
       
    public void setIoSpecification(TInputOutputSpecification value) {
        this.ioSpecification = value;
    }

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                         
       
       
       
    public List<TProperty> getProperty() {
        if (property == null) {
            property = new ArrayList<TProperty>();
        }
        return this.property;
    }

       
                                                           
       
          
                                                                 
                                                                 
                                                            
                                                                                                
       
          
                                                     
            
                                                 
             
       
       
          
                                                               
                                     
       
       
       
    public List<TDataInputAssociation> getDataInputAssociation() {
        if (dataInputAssociation == null) {
            dataInputAssociation = new ArrayList<TDataInputAssociation>();
        }
        return this.dataInputAssociation;
    }

       
                                                            
       
          
                                                                 
                                                                 
                                                            
                                                                                                 
       
          
                                                     
            
                                                  
             
       
       
          
                                                               
                                      
       
       
       
    public List<TDataOutputAssociation> getDataOutputAssociation() {
        if (dataOutputAssociation == null) {
            dataOutputAssociation = new ArrayList<TDataOutputAssociation>();
        }
        return this.dataOutputAssociation;
    }

       
                                                   
       
          
                                                                 
                                                                 
                                                            
                                                                                        
       
          
                                                     
            
                                         
             
       
       
          
                                                               
                                                                     
                                                                     
                                                                   
                                                                
       
       
       
    public List<JAXBElement<? extends TResourceRole>> getResourceRole() {
        if (resourceRole == null) {
            resourceRole = new ArrayList<JAXBElement<? extends TResourceRole>>();
        }
        return this.resourceRole;
    }

       
                                                          
       
              
                             
                                                                                           
                                                                              
                                                                                      
           
       
    public JAXBElement<? extends TLoopCharacteristics> getLoopCharacteristics() {
        return loopCharacteristics;
    }

       
                                                          
       
                   
                            
                                                                                           
                                                                              
                                                                                      
           
       
    public void setLoopCharacteristics(JAXBElement<? extends TLoopCharacteristics> value) {
        this.loopCharacteristics = value;
    }

       
                                                        
       
              
                             
                           
           
       
    public boolean isIsForCompensation() {
        if (isForCompensation == null) {
            return false;
        } else {
            return isForCompensation;
        }
    }

       
                                                        
       
                   
                            
                           
           
       
    public void setIsForCompensation(Boolean value) {
        this.isForCompensation = value;
    }

       
                                                    
       
              
                             
                              
           
       
    public BigInteger getStartQuantity() {
        if (startQuantity == null) {
            return new BigInteger("1");
        } else {
            return startQuantity;
        }
    }

       
                                                    
       
                   
                            
                              
           
       
    public void setStartQuantity(BigInteger value) {
        this.startQuantity = value;
    }

       
                                                         
       
              
                             
                              
           
       
    public BigInteger getCompletionQuantity() {
        if (completionQuantity == null) {
            return new BigInteger("1");
        } else {
            return completionQuantity;
        }
    }

       
                                                         
       
                   
                            
                              
           
       
    public void setCompletionQuantity(BigInteger value) {
        this.completionQuantity = value;
    }

       
                                              
       
              
                             
                          
           
       
    public Object getDefault() {
        return _default;
    }

       
                                              
       
                   
                            
                          
           
       
    public void setDefault(Object value) {
        this._default = value;
    }

       
                                                  
       
              
                             
                          
           
       
    public double getReliability() {
        if (reliability == null) {
            return  1.0D;
        } else {
            return reliability;
        }
    }

       
                                                  
       
                   
                            
                          
           
       
    public void setReliability(Double value) {
        this.reliability = value;
    }

}
