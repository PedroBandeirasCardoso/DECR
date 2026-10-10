  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


   
                                        
   
                                                                                               
   
        
                                
                        
                                                                                      
                      
                                                                                                                               
                                                                                                                              
                                                                                                                       
                       
                                                                                     
                                                                                                   
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLane", propOrder = {
    "partitionElement",
    "flowNodeRef",
    "childLaneSet"
})
public class TLane
    extends TBaseElement
{

    protected TBaseElement partitionElement;
    @XmlElementRef(name = "flowNodeRef", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> flowNodeRef;
    protected TLaneSet childLaneSet;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "partitionElementRef")
    protected QName partitionElementRef;

       
                                                       
       
              
                             
                                
           
       
    public TBaseElement getPartitionElement() {
        return partitionElement;
    }

       
                                                       
       
                   
                            
                                
           
       
    public void setPartitionElement(TBaseElement value) {
        this.partitionElement = value;
    }

       
                                                  
       
          
                                                                 
                                                                 
                                                            
                                                                                       
       
          
                                                     
            
                                        
             
       
       
          
                                                               
                                                            
       
       
       
    public List<JAXBElement<Object>> getFlowNodeRef() {
        if (flowNodeRef == null) {
            flowNodeRef = new ArrayList<JAXBElement<Object>>();
        }
        return this.flowNodeRef;
    }

       
                                                   
       
              
                             
                            
           
       
    public TLaneSet getChildLaneSet() {
        return childLaneSet;
    }

       
                                                   
       
                   
                            
                            
           
       
    public void setChildLaneSet(TLaneSet value) {
        this.childLaneSet = value;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                                          
       
              
                             
                         
           
       
    public QName getPartitionElementRef() {
        return partitionElementRef;
    }

       
                                                          
       
                   
                            
                         
           
       
    public void setPartitionElementRef(QName value) {
        this.partitionElementRef = value;
    }

}
