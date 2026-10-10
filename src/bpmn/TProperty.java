  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                      
                      
                                                                                                   
                       
                                                                                     
                                                                                              
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tProperty", propOrder = {
    "dataState"
})
public class TProperty
    extends TBaseElement
{

    protected TDataState dataState;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "itemSubjectRef")
    protected QName itemSubjectRef;

       
                                                
       
              
                             
                              
           
       
    public TDataState getDataState() {
        return dataState;
    }

       
                                                
       
                   
                            
                              
           
       
    public void setDataState(TDataState value) {
        this.dataState = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                     
       
              
                             
                         
           
       
    public QName getItemSubjectRef() {
        return itemSubjectRef;
    }

       
                                                     
       
                   
                            
                         
           
       
    public void setItemSubjectRef(QName value) {
        this.itemSubjectRef = value;
    }

}
