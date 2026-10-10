  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


   
                                        
   
                                                                                               
   
        
                                
                        
                                                                                   
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTask")
@XmlSeeAlso({
    TScriptTask.class,
    TSendTask.class,
    TReceiveTask.class,
    TBusinessRuleTask.class,
    TManualTask.class,
    TServiceTask.class,
    TUserTask.class
})
public class TTask
    extends TActivity
{


}
