  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                          
   
                                                                                               
   
        
                                  
                        
                                                                        
                                                                                     
                                                                                              
                                                                                           
                                                                               
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diagram", namespace = "http://www.omg.org/spec/DD/20100524/DI")
@XmlSeeAlso({
    BPMNDiagram.class
})
public abstract class Diagram {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "documentation")
    protected String documentation;
    @XmlAttribute(name = "resolution")
    protected Double resolution;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                    
       
              
                             
                          
           
       
    public String getDocumentation() {
        return documentation;
    }

       
                                                    
       
                   
                            
                          
           
       
    public void setDocumentation(String value) {
        this.documentation = value;
    }

       
                                                 
       
              
                             
                          
           
       
    public Double getResolution() {
        return resolution;
    }

       
                                                 
       
                   
                            
                          
           
       
    public void setResolution(Double value) {
        this.resolution = value;
    }

       
                                         
       
              
                             
                          
           
       
    public String getId() {
        return id;
    }

       
                                         
       
                   
                            
                          
           
       
    public void setId(String value) {
        this.id = value;
    }

}
