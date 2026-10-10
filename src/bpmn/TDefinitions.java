  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


   
                                               
   
                                                                                               
   
        
                                       
                        
                                                                        
                      
                                                                                                                      
                                                                                                                         
                                                                                                                           
                                                                                                                        
                                                                                                                            
                       
                                                                               
                                                                                     
                                                                                                               
                                                                                                                                          
                                                                                                                                        
                                                                                         
                                                                                                
                                                                     
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDefinitions", propOrder = {
    "_import",
    "extension",
    "rootElement",
    "bpmnDiagram",
    "relationship"
})
public class TDefinitions {

    @XmlElement(name = "import")
    protected List<TImport> _import;
    protected List<TExtension> extension;
    @XmlElementRef(name = "rootElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TRootElement>> rootElement;
    @XmlElement(name = "BPMNDiagram", namespace = "http://www.omg.org/spec/BPMN/20100524/DI")
    protected List<BPMNDiagram> bpmnDiagram;
    protected List<TRelationship> relationship;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "targetNamespace", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;
    @XmlAttribute(name = "typeLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String typeLanguage;
    @XmlAttribute(name = "exporter")
    protected String exporter;
    @XmlAttribute(name = "exporterVersion")
    protected String exporterVersion;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

       
                                             
       
          
                                                                 
                                                                 
                                                            
                                                                                  
       
          
                                                     
            
                                   
             
       
       
          
                                                               
                       
       
       
       
    public List<TImport> getImport() {
        if (_import == null) {
            _import = new ArrayList<TImport>();
        }
        return this._import;
    }

       
                                                
       
          
                                                                 
                                                                 
                                                            
                                                                                     
       
          
                                                     
            
                                      
             
       
       
          
                                                               
                          
       
       
       
    public List<TExtension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<TExtension>();
        }
        return this.extension;
    }

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                                                                     
                                                                             
                                                                      
                                                             
                                                                          
                                                                             
                                                                 
                                                                  
                                                                            
                                                                 
                                                                     
                                                                
                                                                            
                                                                       
                                                                    
                                                                         
                                                                
                                                                                 
                                                                    
                                                               
                                                                                
                                                               
                                                                               
                                                                       
                                                              
                                                                                
                                                                           
                                                            
                                                                           
                                                              
                                                                             
                                                               
                                                                  
                                                                          
                                                                   
       
       
       
    public List<JAXBElement<? extends TRootElement>> getRootElement() {
        if (rootElement == null) {
            rootElement = new ArrayList<JAXBElement<? extends TRootElement>>();
        }
        return this.rootElement;
    }

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                           
       
       
       
    public List<BPMNDiagram> getBPMNDiagram() {
        if (bpmnDiagram == null) {
            bpmnDiagram = new ArrayList<BPMNDiagram>();
        }
        return this.bpmnDiagram;
    }

       
                                                   
       
          
                                                                 
                                                                 
                                                            
                                                                                        
       
          
                                                     
            
                                         
             
       
       
          
                                                               
                             
       
       
       
    public List<TRelationship> getRelationship() {
        if (relationship == null) {
            relationship = new ArrayList<TRelationship>();
        }
        return this.relationship;
    }

       
                                         
       
              
                             
                          
           
       
    public String getId() {
        return id;
    }

       
                                         
       
                   
                            
                          
           
       
    public void setId(String value) {
        this.id = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                      
       
              
                             
                          
           
       
    public String getTargetNamespace() {
        return targetNamespace;
    }

       
                                                      
       
                   
                            
                          
           
       
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

       
                                                         
       
              
                             
                          
           
       
    public String getExpressionLanguage() {
        if (expressionLanguage == null) {
            return "http://www.w3.org/1999/XPath";
        } else {
            return expressionLanguage;
        }
    }

       
                                                         
       
                   
                            
                          
           
       
    public void setExpressionLanguage(String value) {
        this.expressionLanguage = value;
    }

       
                                                   
       
              
                             
                          
           
       
    public String getTypeLanguage() {
        if (typeLanguage == null) {
            return "http://www.w3.org/2001/XMLSchema";
        } else {
            return typeLanguage;
        }
    }

       
                                                   
       
                   
                            
                          
           
       
    public void setTypeLanguage(String value) {
        this.typeLanguage = value;
    }

       
                                               
       
              
                             
                          
           
       
    public String getExporter() {
        return exporter;
    }

       
                                               
       
                   
                            
                          
           
       
    public void setExporter(String value) {
        this.exporter = value;
    }

       
                                                      
       
              
                             
                          
           
       
    public String getExporterVersion() {
        return exporterVersion;
    }

       
                                                      
       
                   
                            
                          
           
       
    public void setExporterVersion(String value) {
        this.exporterVersion = value;
    }

       
                                                                                                 
       
          
                                                         
                                                      
       
                                                                             
                                                                               
       
       
              
                          
       
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
