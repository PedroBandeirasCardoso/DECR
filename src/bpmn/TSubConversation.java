  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                                   
   
                                                                                               
   
        
                                           
                        
                                                                                           
                      
                                                                                                                                
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubConversation", propOrder = {
    "conversationNode"
})
public class TSubConversation
    extends TConversationNode
{

    @XmlElementRef(name = "conversationNode", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TConversationNode>> conversationNode;

       
                                                       
       
          
                                                                 
                                                                 
                                                            
                                                                                            
       
          
                                                     
            
                                             
             
       
       
          
                                                               
                                                                      
                                                                   
                                                                       
                                                                       
       
       
       
    public List<JAXBElement<? extends TConversationNode>> getConversationNode() {
        if (conversationNode == null) {
            conversationNode = new ArrayList<JAXBElement<? extends TConversationNode>>();
        }
        return this.conversationNode;
    }

}
