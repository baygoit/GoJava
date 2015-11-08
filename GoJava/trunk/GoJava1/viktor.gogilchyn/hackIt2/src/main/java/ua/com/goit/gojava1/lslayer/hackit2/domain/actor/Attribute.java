package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;

public class Attribute {
    
    private String name;
    private String value;
    
    public Attribute(String attributeName, String value) {
        this.name = attributeName;
        this.value = value;
    }

    public Attribute() {
        
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    } 
    
    

}
