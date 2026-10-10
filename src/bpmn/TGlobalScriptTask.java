  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                    
   
                                                                                               
   
        
                                            
                        
                                                                                     
                      
                                                                                                
                       
                                                                                               
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGlobalScriptTask", propOrder = {
    "script"
})
public class TGlobalScriptTask
    extends TGlobalTask
{

    protected TScript script;
    @XmlAttribute(name = "scriptLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String scriptLanguage;

       
                                             
       
              
                             
                           
           
       
    public TScript getScript() {
        return script;
    }

       
                                             
       
                   
                            
                           
           
       
    public void setScript(TScript value) {
        this.script = value;
    }

       
                                                     
       
              
                             
                          
           
       
    public String getScriptLanguage() {
        return scriptLanguage;
    }

       
                                                     
       
                   
                            
                          
           
       
    public void setScriptLanguage(String value) {
        this.scriptLanguage = value;
    }

}
