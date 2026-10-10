  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                                      
                      
                                                                                                                               
                                                                                                                              
                                                                                                                 
                       
                                                                                     
                                                                                          
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParticipant", propOrder = {
    "interfaceRef",
    "endPointRef",
    "participantMultiplicity"
})
public class TParticipant
    extends TBaseElement
{

    protected List<QName> interfaceRef;
    protected List<QName> endPointRef;
    protected TParticipantMultiplicity participantMultiplicity;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "processRef")
    protected QName processRef;

       
                                                   
       
          
                                                                 
                                                                 
                                                            
                                                                                        
       
          
                                                     
            
                                         
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getInterfaceRef() {
        if (interfaceRef == null) {
            interfaceRef = new ArrayList<QName>();
        }
        return this.interfaceRef;
    }

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getEndPointRef() {
        if (endPointRef == null) {
            endPointRef = new ArrayList<QName>();
        }
        return this.endPointRef;
    }

       
                                                              
       
              
                             
                                            
           
       
    public TParticipantMultiplicity getParticipantMultiplicity() {
        return participantMultiplicity;
    }

       
                                                              
       
                   
                            
                                            
           
       
    public void setParticipantMultiplicity(TParticipantMultiplicity value) {
        this.participantMultiplicity = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                 
       
              
                             
                         
           
       
    public QName getProcessRef() {
        return processRef;
    }

       
                                                 
       
                   
                            
                         
           
       
    public void setProcessRef(QName value) {
        this.processRef = value;
    }

}
