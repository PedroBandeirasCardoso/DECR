  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                                       
   
                                                                                               
   
        
                                               
                        
                                                                                      
                      
                                                                                                   
                       
                                                                                              
                                                                                             
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataObjectReference", propOrder = {
    "dataState"
})
public class TDataObjectReference
    extends TFlowElement
{

    protected TDataState dataState;
    @XmlAttribute(name = "itemSubjectRef")
    protected QName itemSubjectRef;
    @XmlAttribute(name = "dataObjectRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object dataObjectRef;

       
                                                
       
              
                             
                              
           
       
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

       
                                                    
       
              
                             
                          
           
       
    public Object getDataObjectRef() {
        return dataObjectRef;
    }

       
                                                    
       
                   
                            
                          
           
       
    public void setDataObjectRef(Object value) {
        this.dataObjectRef = value;
    }

}
