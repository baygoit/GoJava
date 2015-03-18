package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;

public abstract class AbstractGear implements Gear {
    private String name;
    private Map<String, Integer> purpose = new LinkedHashMap<String, Integer>();

    public AbstractGear() {
    }

    public Gear addPurpose(String purpose, int value)
            throws HackitWrongParameterException {
        if (purpose == null) {
            throw new HackitWrongParameterException("No null purpose allowed");
        }
        this.purpose.put(purpose, value);
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPurposeValue(String commandToInvoke) {
        return this.purpose.get(commandToInvoke) != null ? this.purpose
                .get(commandToInvoke) : 0;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractUtility [name=" + this.name + ", purpose="
                + this.purpose + "]";
    }

}
