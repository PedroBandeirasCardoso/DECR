  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                 
                      
                                                                                                
                       
                                                                                           
                                                                                              
                                                                                            
                                                                                                 
                                                                                                  
                                                                                                                         
                                                                                                         
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BPMNShape", namespace = "http://www.omg.org/spec/BPMN/20100524/DI", propOrder = {
    "bpmnLabel"
})
public class BPMNShape
    extends LabeledShape
{

    @XmlElement(name = "BPMNLabel")
    protected BPMNLabel bpmnLabel;
    @XmlAttribute(name = "bpmnElement")
    protected QName bpmnElement;
    @XmlAttribute(name = "isHorizontal")
    protected Boolean isHorizontal;
    @XmlAttribute(name = "isExpanded")
    protected Boolean isExpanded;
    @XmlAttribute(name = "isMarkerVisible")
    protected Boolean isMarkerVisible;
    @XmlAttribute(name = "isMessageVisible")
    protected Boolean isMessageVisible;
    @XmlAttribute(name = "participantBandKind")
    protected ParticipantBandKind participantBandKind;
    @XmlAttribute(name = "choreographyActivityShape")
    protected QName choreographyActivityShape;

       
                                                
       
              
                             
                             
           
       
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

       
                                                   
       
              
                             
                           
           
       
    public Boolean isIsHorizontal() {
        return isHorizontal;
    }

       
                                                   
       
                   
                            
                           
           
       
    public void setIsHorizontal(Boolean value) {
        this.isHorizontal = value;
    }

       
                                                 
       
              
                             
                           
           
       
    public Boolean isIsExpanded() {
        return isExpanded;
    }

       
                                                 
       
                   
                            
                           
           
       
    public void setIsExpanded(Boolean value) {
        this.isExpanded = value;
    }

       
                                                      
       
              
                             
                           
           
       
    public Boolean isIsMarkerVisible() {
        return isMarkerVisible;
    }

       
                                                      
       
                   
                            
                           
           
       
    public void setIsMarkerVisible(Boolean value) {
        this.isMarkerVisible = value;
    }

       
                                                       
       
              
                             
                           
           
       
    public Boolean isIsMessageVisible() {
        return isMessageVisible;
    }

       
                                                       
       
                   
                            
                           
           
       
    public void setIsMessageVisible(Boolean value) {
        this.isMessageVisible = value;
    }

       
                                                          
       
              
                             
                                       
           
       
    public ParticipantBandKind getParticipantBandKind() {
        return participantBandKind;
    }

       
                                                          
       
                   
                            
                                       
           
       
    public void setParticipantBandKind(ParticipantBandKind value) {
        this.participantBandKind = value;
    }

       
                                                                
       
              
                             
                         
           
       
    public QName getChoreographyActivityShape() {
        return choreographyActivityShape;
    }

       
                                                                
       
                   
                            
                         
           
       
    public void setChoreographyActivityShape(QName value) {
        this.choreographyActivityShape = value;
    }

}
