package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.Position;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

public class ActorFactory {
    
    private static final String[] DEFAULT_SKILLS = { "scan", "develop", "info" };
    private static final int DEFAULT_SKILL_VALUE = 1;
    private HumanControlledCharacter actor = new HumanControlledCharacter();
    private String actorName = null;
    private long id = -1;
    private Position position;
    private Map<String, Integer> skills = new LinkedHashMap<String, Integer>();
    private Map<String, String>  atrributes = new HashMap<String, String>();

    public ActorFactory addSkill(String skill, int value)
            throws HackitWrongParameterException {
        if (skill != null) {
            this.skills.put(skill, value);
        } else {
            throw new HackitWrongParameterException("Skill can't be null");
        }
        return this;
    }

    public ActorFactory addSkill(String skill)
            throws HackitWrongParameterException {
        if (skill != null) {
            this.skills.put(skill, DEFAULT_SKILL_VALUE);
        } else {
            throw new HackitWrongParameterException("Skill can't be null");
        }
        return this;
    }
    
    public ActorFactory addAttribute(String attribute, String value) {
        this.atrributes.put(attribute, value);
        return this;
    }
    
    public ActorFactory setPosition(Position position) {
        this.position = position;
        return this;
    }

    public ActorFactory setSkills(Map<String, Integer> skills) {
        this.skills = skills;
        return this;
    }

    public ActorFactory setAtrributes(Map<String, String> atrributes) {
        this.atrributes = atrributes;
        return this;
    }

    public ActorFactory setActorName(String actorName) {
        this.actorName = actorName;
        return this;
    }
    
    public ActorFactory setId(long id) {
        this.id = id;
        return this;
    }

    public Actor createActor() {
        this.actor.setName(actorName);
        this.actorName = null;
        this.actor.setSkills(skills);
        this.skills = null;
        this.actor.setAtrributes(atrributes);
        this.atrributes = null;
        this.actor.setPosition(position);
        this.position = null;
        if (this.id == -1) {
            
        }
        return this.actor;
    }

    public void addSkillsArray(String[] skills) throws HackitWrongParameterException {
        
        for (String element : skills) {
            this.addSkill(element);
        }
        
    }


}
