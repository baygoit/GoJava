package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractCharacter implements Actor{

    @Override
    public int getSkillValue(String skillName) {
        return skills.get(skillName) != null ? skills.get(skillName) : 0;
    }
    
    @Override
    public void evolveSkill(String skillName) {
        if (this.getSkillValue(skillName) > 0) {
            this.skills.put(skillName, this.getSkillValue(skillName) + 1);
        }
    }

    protected String name;
    private Map<String, Integer> skills = new LinkedHashMap<String, Integer>();
//  private List<Gear> possesionsList;
//  private List<Gear> ControlList;
    public AbstractCharacter (String name) {
        this.name = name;
    }
    public void addSkill(String skillName) {
        if (getSkillValue(skillName) == 0 && skillName != null)  
            this.skills.put(skillName, 1);
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
    
 

}
