  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


   
                               
   
                                                                                               
      
        
                                   
                                                                     
                                            
                                         
                      
                   
         
   
   
@XmlType(name = "tItemKind")
@XmlEnum
public enum TItemKind {

    @XmlEnumValue("Information")
    INFORMATION("Information"),
    @XmlEnumValue("Physical")
    PHYSICAL("Physical");
    private final String value;

    TItemKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TItemKind fromValue(String v) {
        for (TItemKind c: TItemKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
