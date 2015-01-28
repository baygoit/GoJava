package ua.com.goit.gojava1.lslayer.hackit2.gear;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractHardware implements Hardware {
    private String name;
    private Map<String, Integer> parameters = new HashMap<String, Integer>();
    public AbstractHardware(String name) {
        this.name = name;
    }
    public void addParameter(String paramName, Integer paramValue) {
        this.parameters.put(paramName, paramValue);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String listParameters() {
        String result = "";
        String eol = System.getProperty("line.separator");
        for (Map.Entry<String, Integer> element : parameters.entrySet()) {
            result += eol + element.getKey().toLowerCase() + ": " + element.getValue(); 
        }
        return result;
    }
    @Override
    public String toString() {
        String eol = System.getProperty("line.separator");
        return name + listParameters();
    }
    
}
