  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                  
   
                                                                                               
   
        
                                          
                        
                                                                                  
                      
                                                                                                                                 
                       
                                                                                       
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tComplexGateway", propOrder = {
    "activationCondition"
})
public class TComplexGateway
    extends TGateway
{

    protected TExpression activationCondition;
    @XmlAttribute(name = "default")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object _default;

       
                                                          
       
              
                             
                               
           
       
    public TExpression getActivationCondition() {
        return activationCondition;
    }

       
                                                          
       
                   
                            
                               
           
       
    public void setActivationCondition(TExpression value) {
        this.activationCondition = value;
    }

       
                                              
       
              
                             
                          
           
       
    public Object getDefault() {
        return _default;
    }

       
                                              
       
                   
                            
                          
           
       
    public void setDefault(Object value) {
        this._default = value;
    }

}
