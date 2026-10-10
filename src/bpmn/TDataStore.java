  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.math.BigInteger;

import javax.xml.namespace.QName;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                             
   
                                                                                               
   
        
                                     
                        
                                                                                      
                      
                                                                                                   
                       
                                                                                     
                                                                                          
                                                                                                            
                                                                                              
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataStore", propOrder = {
    "dataState"
})
public class TDataStore
    extends TRootElement
{

    protected TDataState dataState;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "capacity")
    protected BigInteger capacity;
    @XmlAttribute(name = "isUnlimited")
    protected Boolean isUnlimited;
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

       
                                               
       
              
                             
                              
           
       
    public BigInteger getCapacity() {
        return capacity;
    }

       
                                               
       
                   
                            
                              
           
       
    public void setCapacity(BigInteger value) {
        this.capacity = value;
    }

       
                                                  
       
              
                             
                           
           
       
    public boolean isIsUnlimited() {
        if (isUnlimited == null) {
            return true;
        } else {
            return isUnlimited;
        }
    }

       
                                                  
       
                   
                            
                           
           
       
    public void setIsUnlimited(Boolean value) {
        this.isUnlimited = value;
    }

       
                                                     
       
              
                             
                         
           
       
    public QName getItemSubjectRef() {
        return itemSubjectRef;
    }

       
                                                     
       
                   
                            
                         
           
       
    public void setItemSubjectRef(QName value) {
        this.itemSubjectRef = value;
    }

}
