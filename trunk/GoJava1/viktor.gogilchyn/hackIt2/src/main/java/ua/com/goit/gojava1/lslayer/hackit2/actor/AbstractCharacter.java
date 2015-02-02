package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractCharacter implements Actor {

    private String name;

    private Map<String, Integer> skills = new LinkedHashMap<String, Integer>();
    @Override
    public Map<String, String> getAttributes() {
        return atrributes;
    }

    private Map<String, String> atrributes = new HashMap<String, String>();
    // private List<Gear> possesionsList;
    // private List<Gear> ControlList;
    

    @Override
    public String getAttribute(String what) { //Right now I don't need null in result.  
        return atrributes.get(what) != null ? atrributes.get(what) : "";
    }

    @Override
    public String getStringForOutput() {
        String eol = System.getProperty("line.separator");
        String result = "";
        result += this.getName() + eol;
        result += this.getAllSkills();
        return result;
    }
    @Override
    public void setAttribute(String what, String value) {
        this.atrributes.put(what, value);
    }

    public AbstractCharacter(String name) {
        this.name = name;
    }

    public void addSkill(String skillName) {
        if (getSkillValue(skillName) == 0 && skillName != null)
            this.skills.put(skillName, 1);
    }
    
    @Override
    public void evolveSkill(String skillName) {
        if (this.getSkillValue(skillName) > 0) {
            this.skills.put(skillName, this.getSkillValue(skillName) + 1);
        }
    }

    @Override
    public String getAllSkills() {
        String eol = System.getProperty("line.separator");
        String returnValue = "";
        for (Map.Entry<String, Integer> element : this.skills.entrySet()) {
            returnValue += element.getKey() + ": " + element.getValue() + eol;
        }
        return returnValue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSkillValue(String skillName) {
        return skills.get(skillName) != null ? skills.get(skillName) : 0;
    }

}
