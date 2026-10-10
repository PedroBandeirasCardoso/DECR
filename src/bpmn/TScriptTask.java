  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                              
   
                                                                                               
   
        
                                      
                        
                                                                               
                      
                                                                                                
                       
                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tScriptTask", propOrder = {
    "script"
})
public class TScriptTask
    extends TTask
{

    protected TScript script;
    @XmlAttribute(name = "scriptFormat")
    protected String scriptFormat;

       
                                             
       
              
                             
                           
           
       
    public TScript getScript() {
        return script;
    }

       
                                             
       
                   
                            
                           
           
       
    public void setScript(TScript value) {
        this.script = value;
    }

       
                                                   
       
              
                             
                          
           
       
    public String getScriptFormat() {
        return scriptFormat;
    }

       
                                                   
       
                   
                            
                          
           
       
    public void setScriptFormat(String value) {
        this.scriptFormat = value;
    }

}
