  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


   
                                           
   
                                                                                               
      
        
                                               
                                                                     
                                     
                                         
                                                        
                                                      
                      
                   
         
   
   
@XmlType(name = "tChoreographyLoopType")
@XmlEnum
public enum TChoreographyLoopType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("MultiInstanceSequential")
    MULTI_INSTANCE_SEQUENTIAL("MultiInstanceSequential"),
    @XmlEnumValue("MultiInstanceParallel")
    MULTI_INSTANCE_PARALLEL("MultiInstanceParallel");
    private final String value;

    TChoreographyLoopType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TChoreographyLoopType fromValue(String v) {
        for (TChoreographyLoopType c: TChoreographyLoopType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
