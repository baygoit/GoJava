package ua.com.goit.gojava1.lslayer.hackit2.gear;

import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.HackitWrongParameterException;

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

    public Gear addPurpose(String purpose, int value) throws Exception {
        if (purpose == null) throw new HackitWrongParameterException ("No null purpose allowed");
            this.purpose.put(purpose, value);
        return this;
    }

    @Override
    public int getPurposeValue(String commandToInvoke) {
        return purpose.get(commandToInvoke) != null ? purpose.get(commandToInvoke) : 0;
    }

    @Override
    public String toString() {
        return "AbstractUtility [name=" + name + ", purpose=" + purpose + "]";
    }
    
}
