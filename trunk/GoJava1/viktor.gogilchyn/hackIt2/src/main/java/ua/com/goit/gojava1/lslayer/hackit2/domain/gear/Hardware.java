package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.util.Map;

public interface Hardware extends Gear {

    @Override
    public String getName();

    public Map<String, Integer> getParameters();

    @Override
    public void setName(String name);

    public void setParameters(Map<String, Integer> parameters);

}
