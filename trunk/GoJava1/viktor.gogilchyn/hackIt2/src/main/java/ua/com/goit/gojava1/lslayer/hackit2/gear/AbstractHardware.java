package ua.com.goit.gojava1.lslayer.hackit2.gear;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractHardware implements Hardware {
    private String name;
    private Map<String, Integer> purpose = new LinkedHashMap<String, Integer>();
    private Map<String, Integer> parameters = new LinkedHashMap<String, Integer>();
    public AbstractHardware(String name) {
        this.name = name;
    }

    public Hardware addPurpose(String purpose, int value) {
        if (purpose != null) //No null purpose can be
            this.purpose.put(purpose, value);
        return this;
    }
    
    @Override
    public int getSkillBonus(String commandToInvoke) {
        return purpose.get(commandToInvoke) != null ? purpose.get(commandToInvoke) : 0;
    }

    public Hardware addParameter(String paramName, int paramValue) {
        this.parameters.put(paramName, paramValue);
        return this;
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
        return name + listParameters();
    }
    
}
