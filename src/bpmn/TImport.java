  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


   
                                          
   
                                                                                               
   
        
                                  
                        
                                                                        
                                                                                                         
                                                                                                        
                                                                                                          
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImport")
public class TImport {

    @XmlAttribute(name = "namespace", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlAttribute(name = "location", required = true)
    protected String location;
    @XmlAttribute(name = "importType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String importType;

       
                                                
       
              
                             
                          
           
       
    public String getNamespace() {
        return namespace;
    }

       
                                                
       
                   
                            
                          
           
       
    public void setNamespace(String value) {
        this.namespace = value;
    }

       
                                               
       
              
                             
                          
           
       
    public String getLocation() {
        return location;
    }

       
                                               
       
                   
                            
                          
           
       
    public void setLocation(String value) {
        this.location = value;
    }

       
                                                 
       
              
                             
                          
           
       
    public String getImportType() {
        return importType;
    }

       
                                                 
       
                   
                            
                          
           
       
    public void setImportType(String value) {
        this.importType = value;
    }

}
