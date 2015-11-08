package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;

public abstract class AbstractHardware extends AbstractGear implements
        Hardware {

    public AbstractHardware() throws HackitWrongParameterException {
        super();
    }

    private Map<String, Integer> parameters = new LinkedHashMap<String, Integer>();

    public Hardware addParameter(String paramName, int paramValue) {
        this.parameters.put(paramName, paramValue);
        return this;
    }

    @Override
    public Map<String, Integer> getParameters() {
        return this.parameters;
    }

    @Override
    public void setParameters(Map<String, Integer> parameters) {
        this.parameters.clear();
        this.parameters.putAll(parameters);
    }

    public String listParameters() {
        String result = "";
        String eol = System.getProperty("line.separator");
        for (Map.Entry<String, Integer> element : parameters.entrySet()) {
            result += eol + element.getKey().toLowerCase() + ": "
                    + element.getValue();
        }
        return result;
    }

    public String getStringForOutput() {
        return super.getName() + listParameters();
    }

}
