  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                       
   
                                                                                               
   
        
                               
                        
                                                                        
                                                                                     
                                                                                     
                                                                                        
                                                                                          
                                                                                             
                                                                                                 
                        
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Font", namespace = "http://www.omg.org/spec/DD/20100524/DC")
public class Font {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "size")
    protected Double size;
    @XmlAttribute(name = "isBold")
    protected Boolean isBold;
    @XmlAttribute(name = "isItalic")
    protected Boolean isItalic;
    @XmlAttribute(name = "isUnderline")
    protected Boolean isUnderline;
    @XmlAttribute(name = "isStrikeThrough")
    protected Boolean isStrikeThrough;

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

       
                                           
       
              
                             
                          
           
       
    public Double getSize() {
        return size;
    }

       
                                           
       
                   
                            
                          
           
       
    public void setSize(Double value) {
        this.size = value;
    }

       
                                             
       
              
                             
                           
           
       
    public Boolean isIsBold() {
        return isBold;
    }

       
                                             
       
                   
                            
                           
           
       
    public void setIsBold(Boolean value) {
        this.isBold = value;
    }

       
                                               
       
              
                             
                           
           
       
    public Boolean isIsItalic() {
        return isItalic;
    }

       
                                               
       
                   
                            
                           
           
       
    public void setIsItalic(Boolean value) {
        this.isItalic = value;
    }

       
                                                  
       
              
                             
                           
           
       
    public Boolean isIsUnderline() {
        return isUnderline;
    }

       
                                                  
       
                   
                            
                           
           
       
    public void setIsUnderline(Boolean value) {
        this.isUnderline = value;
    }

       
                                                      
       
              
                             
                           
           
       
    public Boolean isIsStrikeThrough() {
        return isStrikeThrough;
    }

       
                                                      
       
                   
                            
                           
           
       
    public void setIsStrikeThrough(Boolean value) {
        this.isStrikeThrough = value;
    }

}
