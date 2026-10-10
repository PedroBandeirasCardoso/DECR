  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
      
        
                                               
                                                                     
                                     
                                    
                                     
                      
                   
         
   
   
@XmlType(name = "tAssociationDirection")
@XmlEnum
public enum TAssociationDirection {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("One")
    ONE("One"),
    @XmlEnumValue("Both")
    BOTH("Both");
    private final String value;

    TAssociationDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TAssociationDirection fromValue(String v) {
        for (TAssociationDirection c: TAssociationDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
