  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                                      
                      
                                                                                                    
                                                                                                  
                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAssignment", propOrder = {
    "from",
    "to"
})
public class TAssignment
    extends TBaseElement
{

    @XmlElement(required = true)
    protected TExpression from;
    @XmlElement(required = true)
    protected TExpression to;

       
                                           
       
              
                             
                               
           
       
    public TExpression getFrom() {
        return from;
    }

       
                                           
       
                   
                            
                               
           
       
    public void setFrom(TExpression value) {
        this.from = value;
    }

       
                                         
       
              
                             
                               
           
       
    public TExpression getTo() {
        return to;
    }

       
                                         
       
                   
                            
                               
           
       
    public void setTo(TExpression value) {
        this.to = value;
    }

}
