  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                      
   
                                                                                               
   
        
                                              
                        
                                                                                      
                      
                                                                                                   
                       
                                                                                              
                                                                                            
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataStoreReference", propOrder = {
    "dataState"
})
public class TDataStoreReference
    extends TFlowElement
{

    protected TDataState dataState;
    @XmlAttribute(name = "itemSubjectRef")
    protected QName itemSubjectRef;
    @XmlAttribute(name = "dataStoreRef")
    protected QName dataStoreRef;

       
                                                
       
              
                             
                              
           
       
    public TDataState getDataState() {
        return dataState;
    }

       
                                                
       
                   
                            
                              
           
       
    public void setDataState(TDataState value) {
        this.dataState = value;
    }

       
                                                     
       
              
                             
                         
           
       
    public QName getItemSubjectRef() {
        return itemSubjectRef;
    }

       
                                                     
       
                   
                            
                         
           
       
    public void setItemSubjectRef(QName value) {
        this.itemSubjectRef = value;
    }

       
                                                   
       
              
                             
                         
           
       
    public QName getDataStoreRef() {
        return dataStoreRef;
    }

       
                                                   
       
                   
                            
                         
           
       
    public void setDataStoreRef(QName value) {
        this.dataStoreRef = value;
    }

}
