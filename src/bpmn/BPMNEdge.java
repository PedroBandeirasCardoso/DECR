  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
   
        
                                   
                        
                                                                                
                      
                                                                                                
                       
                                                                                           
                                                                                             
                                                                                             
                                                                                                                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNEdge", namespace = "http://www.omg.org/spec/BPMN/20100524/DI", propOrder = {
    "bpmnLabel"
})
public class BPMNEdge
    extends LabeledEdge
{

    @XmlElement(name = "BPMNLabel")
    protected BPMNLabel bpmnLabel;
    @XmlAttribute(name = "bpmnElement")
    protected QName bpmnElement;
    @XmlAttribute(name = "sourceElement")
    protected QName sourceElement;
    @XmlAttribute(name = "targetElement")
    protected QName targetElement;
    @XmlAttribute(name = "messageVisibleKind")
    protected MessageVisibleKind messageVisibleKind;

       
                                                
       
              
                             
                             
           
       
    public BPMNLabel getBPMNLabel() {
        return bpmnLabel;
    }

       
                                                
       
                   
                            
                             
           
       
    public void setBPMNLabel(BPMNLabel value) {
        this.bpmnLabel = value;
    }

       
                                                  
       
              
                             
                         
           
       
    public QName getBpmnElement() {
        return bpmnElement;
    }

       
                                                  
       
                   
                            
                         
           
       
    public void setBpmnElement(QName value) {
        this.bpmnElement = value;
    }

       
                                                    
       
              
                             
                         
           
       
    public QName getSourceElement() {
        return sourceElement;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setSourceElement(QName value) {
        this.sourceElement = value;
    }

       
                                                    
       
              
                             
                         
           
       
    public QName getTargetElement() {
        return targetElement;
    }

       
                                                    
       
                   
                            
                         
           
       
    public void setTargetElement(QName value) {
        this.targetElement = value;
    }

       
                                                         
       
              
                             
                                      
           
       
    public MessageVisibleKind getMessageVisibleKind() {
        return messageVisibleKind;
    }

       
                                                         
       
                   
                            
                                      
           
       
    public void setMessageVisibleKind(MessageVisibleKind value) {
        this.messageVisibleKind = value;
    }

}
