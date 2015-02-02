package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.Map;

public interface Actor {
    public String getName();

    //Skills part
    public int getSkillValue(String skillName);
    public void addSkill(String string);
    public void evolveSkill(String skillName);
    public void setAttribute(String what, String value);
    public String getAttribute(String what);
    public Map<String, String> getAttributes();
    //UI part
    public String getAllSkills();
    public String getStringForOutput();
}
