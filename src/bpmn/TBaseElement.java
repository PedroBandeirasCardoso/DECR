  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                        
                      
                                                                                                                             
                                                                                                           
                       
                                                                               
                                                                     
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBaseElement", propOrder = {
    "documentation",
    "extensionElements"
})
@XmlSeeAlso({
    TConversationAssociation.class,
    TInputOutputBinding.class,
    TAuditing.class,
    TOutputSet.class,
    TDataOutput.class,
    TProperty.class,
    TRendering.class,
    TMonitoring.class,
    TLaneSet.class,
    TInputSet.class,
    TConversationLink.class,
    TMessageFlow.class,
    TResourceAssignmentExpression.class,
    TParticipantAssociation.class,
    TRelationship.class,
    TDataInput.class,
    TComplexBehaviorDefinition.class,
    TOperation.class,
    TResourceParameter.class,
    TParticipant.class,
    TCorrelationSubscription.class,
    TConversationNode.class,
    TArtifact.class,
    TDataState.class,
    TMessageFlowAssociation.class,
    TCategoryValue.class,
    TLoopCharacteristics.class,
    TCorrelationPropertyBinding.class,
    TInputOutputSpecification.class,
    TResourceRole.class,
    TDataAssociation.class,
    TCorrelationPropertyRetrievalExpression.class,
    TLane.class,
    TParticipantMultiplicity.class,
    TAssignment.class,
    TResourceParameterBinding.class,
    TRootElement.class,
    TCorrelationKey.class,
    TFlowElement.class
})
public abstract class TBaseElement {

    protected List<TDocumentation> documentation;
    protected TExtensionElements extensionElements;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

       
                                                    
       
          
                                                                 
                                                                 
                                                            
                                                                                         
       
          
                                                     
            
                                          
             
       
       
          
                                                               
                              
       
       
       
    public List<TDocumentation> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<TDocumentation>();
        }
        return this.documentation;
    }

       
                                                        
       
              
                             
                                      
           
       
    public TExtensionElements getExtensionElements() {
        return extensionElements;
    }

       
                                                        
       
                   
                            
                                      
           
       
    public void setExtensionElements(TExtensionElements value) {
        this.extensionElements = value;
    }

       
                                         
       
              
                             
                          
           
       
    public String getId() {
        return id;
    }

       
                                         
       
                   
                            
                          
           
       
    public void setId(String value) {
        this.id = value;
    }

       
                                                                                                 
       
          
                                                         
                                                      
       
                                                                             
                                                                               
       
       
              
                          
       
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
