package ua.com.goit.gojava1.lslayer.hackit2.gear;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractUtility implements Gear {
    private String name;
    private Map<String, Integer> purpose = new LinkedHashMap<String, Integer>();
    
    public AbstractUtility(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Gear addPurpose(String purpose, int value) {
        if (purpose != null) //No null purpose can be
            this.purpose.put(purpose, value);
        return this;
    }

    @Override
    public int getPurposeValue(String commandToInvoke) {
        return purpose.get(commandToInvoke) != null ? purpose.get(commandToInvoke) : 0;
    }
    
}
