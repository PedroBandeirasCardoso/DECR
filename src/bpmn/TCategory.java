  
                                                                                                                           
                                                                               
                                                                                        
                                               
  


package bpmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helpers.Node;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


   
                                            
   
                                                                                               
   
        
                                    
                        
                                                                                      
                      
                                                                                                                             
                       
                                                                                     
                                                                     
                      
                         
                    
         
   
   
   
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCategory", propOrder = {
    "categoryValue",
    "reliabilityValue",
    "businessValue",
    "calculatedRisk",
    "categoryValueRef",
    "superCategory",
    "subCategories",
})
public class TCategory
    extends TRootElement
{

    protected List<TCategoryValue> categoryValue;
    @XmlAttribute(name = "name")
    protected String name;
    protected String categoryValueRef;
    protected double reliabilityValue;
    protected double businessValue;
    protected double calculatedRisk;
	private TCategory superCategory;
	private List<TCategory> subCategories = new ArrayList<TCategory>();

       
                                                    
       
          
                                                                 
                                                                 
                                                            
                                                                                         
       
          
                                                     
            
                                          
             
       
       
          
                                                               
                              
       
       
       
    public List<TCategoryValue> getCategoryValue() {
        if (categoryValue == null) {
            categoryValue = new ArrayList<TCategoryValue>();
        }
        return this.categoryValue;
    }

       
                                           
       
              
                             
                          
           
       
    public String getName() {
        return name;
    }
    
    public List<TCategory> getSubCategories() {
        return subCategories;
    }
    
    public double getComponent(String component) {
    	switch (component) {
    		case "Rely":
    			return this.reliabilityValue;
    		case "BV":
    			return this.businessValue;
    		case "Risk":
    			return this.calculatedRisk;
    		default:
    			return -1.0;
    	}
    }

       
                                           
       
                   
                            
                          
           
       
    public void setName(String value) {
        this.name = value;
    }

	public HashMap<String, Node> getElements(HashMap<String, Node> nodesMap) {
		HashMap<String, Node> result = new HashMap<String, Node>();
		for (Node element : nodesMap.values()) {
			if (element.getCategoryValue().getId().equals(this.getId())) {
				result.put(element.getId(), element);
			}
		}
		return result;
	}

	public TCategory getSuperCategory() {
		return this.superCategory;
	}
	
	public void setSubCategories(List<TCategory> sbc2) {
		this.subCategories = sbc2;
	}

	public void setComponentValue(String componentToCompute, double componentValue) {
		switch (componentToCompute) {
			case "Rely": {
				this.reliabilityValue = componentValue;
				break;
			}
			case "BV": {
				this.businessValue = componentValue;
				break;
			}
			case "Risk": {
				this.calculatedRisk = componentValue;
				break;
			}
		}
	}

	public void setSuperCategory(TCategory tCategory) {
		this.superCategory = tCategory;
	}

	public String getCategoryValueRef() {
		return this.categoryValueRef;
	}

	public void setCategoryValueRef(String nodeValue) {
		this.categoryValueRef = nodeValue;
	}

	public boolean isHigherLevel(TCategory tCategory) {
		while (!tCategory.equals(null)) {
			if (this.superCategory.getId().equals(tCategory.getId())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final TCategory other = (TCategory) obj;
        if (!this.id.equals(other.getId())) {
            return false;
        }

        if (!this.name.equals(other.getName())) {
            return false;
        }

        return true;
    }
}
