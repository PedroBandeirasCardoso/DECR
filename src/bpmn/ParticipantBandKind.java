  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


   
                                         
   
                                                                                               
      
        
                                             
                                                                     
                                               
                                                  
                                                  
                                                   
                                                      
                                                      
                      
                   
         
   
   
@XmlType(name = "ParticipantBandKind", namespace = "http://www.omg.org/spec/BPMN/20100524/DI")
@XmlEnum
public enum ParticipantBandKind {

    @XmlEnumValue("top_initiating")
    TOP_INITIATING("top_initiating"),
    @XmlEnumValue("middle_initiating")
    MIDDLE_INITIATING("middle_initiating"),
    @XmlEnumValue("bottom_initiating")
    BOTTOM_INITIATING("bottom_initiating"),
    @XmlEnumValue("top_non_initiating")
    TOP_NON_INITIATING("top_non_initiating"),
    @XmlEnumValue("middle_non_initiating")
    MIDDLE_NON_INITIATING("middle_non_initiating"),
    @XmlEnumValue("bottom_non_initiating")
    BOTTOM_NON_INITIATING("bottom_non_initiating");
    private final String value;

    ParticipantBandKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParticipantBandKind fromValue(String v) {
        for (ParticipantBandKind c: ParticipantBandKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
