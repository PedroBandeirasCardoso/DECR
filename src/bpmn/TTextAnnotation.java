  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                                  
   
                                                                                               
   
        
                                          
                        
                                                                                   
                      
                                                                                              
                       
                                                                                                                
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTextAnnotation", propOrder = {
    "text"
})
public class TTextAnnotation
    extends TArtifact
{

    protected TText text;
    @XmlAttribute(name = "textFormat")
    protected String textFormat;

       
                                           
       
              
                             
                         
           
       
    public TText getText() {
        return text;
    }

       
                                           
       
                   
                            
                         
           
       
    public void setText(TText value) {
        this.text = value;
    }

       
                                                 
       
              
                             
                          
           
       
    public String getTextFormat() {
        if (textFormat == null) {
            return "text/plain";
        } else {
            return textFormat;
        }
    }

       
                                                 
       
                   
                            
                          
           
       
    public void setTextFormat(String value) {
        this.textFormat = value;
    }

}
