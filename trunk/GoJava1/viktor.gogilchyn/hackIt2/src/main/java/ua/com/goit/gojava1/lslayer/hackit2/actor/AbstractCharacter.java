package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

public abstract class AbstractCharacter implements Actor, Serializable {

    private static final long serialVersionUID = -2511742480639362123L;
    private long id;
    private String name;
    private Map<String, Integer> skills = new LinkedHashMap<String, Integer>();
    private Map<String, String>  atrributes = new HashMap<String, String>();
    
    @Override
    public void setName(String name) {
        this.name = name;
        
    }

    @Override
    public Map<String, String> getAttributes() {
        return atrributes;
    }

    
    // private List<Gear> possesionsList;
    // private List<Gear> ControlList;
    

    @Override
    public ActionResult act(Action whatToDo) throws HackitWrongParameterException {
        ActionParameters po = whatToDo.getParameters();
        po.actor = this;
        whatToDo.setParameters(po);
        return whatToDo.execute();
    }


    @Override
    public String getAttribute(String what) { //Right now I don't need null in result.  
        return atrributes.get(what) != null ? atrributes.get(what) : "";
    }

    
    @Override
    public String getStringForOutput() {
        String eol = System.getProperty("line.separator");
        String result = "";
        result += this.getName() + eol;
        result += this.getSkills();
        return result;
    }
    
    
    @Override
    public void addAttribute(String what, String value) {
        this.atrributes.put(what, value);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    
    public AbstractCharacter(String name) {
        this.name = name;
    }

    
    public void addSkill(String skillName) {
        if (getSkill(skillName) == 0 && skillName != null)
            this.skills.put(skillName, 1);
    }
    
    
    @Override
    public void incSkill(String skillName, int value) {
        if (this.getSkill(skillName) > 0) {
            this.skills.put(skillName, this.getSkill(skillName) + value);
        }
    }

    
    @Override
    public String toString() {
        return "Actor [name=" + name + ", skills=" + skills + "]";
    }


    @Override
    public Map<String, Integer> getSkills() {
        return this.skills;
    }

    
    @Override
    public String getName() {
        return this.name;
    }

    
    @Override
    public int getSkill(String skillName) {
        return skills.get(skillName) != null ? skills.get(skillName) : 0;
    }

}
