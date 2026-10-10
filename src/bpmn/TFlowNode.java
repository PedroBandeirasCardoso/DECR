  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                      
                      
                                                                                                                           
                                                                                                                           
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFlowNode", propOrder = {
    "incoming",
    "outgoing"
})
@XmlSeeAlso({
    TEvent.class,
    TChoreographyActivity.class,
    TActivity.class,
    TGateway.class
})
public abstract class TFlowNode
    extends TFlowElement
{

    protected List<QName> incoming;
    protected List<QName> outgoing;

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getIncoming() {
        if (incoming == null) {
            incoming = new ArrayList<QName>();
        }
        return this.incoming;
    }

       
                                               
       
          
                                                                 
                                                                 
                                                            
                                                                                    
       
          
                                                     
            
                                     
             
       
       
          
                                                               
                     
       
       
       
    public List<QName> getOutgoing() {
        if (outgoing == null) {
            outgoing = new ArrayList<QName>();
        }
        return this.outgoing;
    }

}
