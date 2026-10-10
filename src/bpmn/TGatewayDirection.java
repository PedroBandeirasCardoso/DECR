  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


   
                                       
   
                                                                                               
      
        
                                           
                                                                     
                                            
                                           
                                          
                                      
                      
                   
         
   
   
@XmlType(name = "tGatewayDirection")
@XmlEnum
public enum TGatewayDirection {

    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified"),
    @XmlEnumValue("Converging")
    CONVERGING("Converging"),
    @XmlEnumValue("Diverging")
    DIVERGING("Diverging"),
    @XmlEnumValue("Mixed")
    MIXED("Mixed");
    private final String value;

    TGatewayDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGatewayDirection fromValue(String v) {
        for (TGatewayDirection c: TGatewayDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
