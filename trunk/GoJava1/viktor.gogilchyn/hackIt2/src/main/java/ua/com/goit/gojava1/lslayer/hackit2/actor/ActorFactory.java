package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import ua.com.goit.gojava1.lslayer.hackit2.Position;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

@ComponentScan
public class ActorFactory {
    
    @Autowired
    DataSource ds;
    
    private static final String[] DEFAULT_SKILLS = { "scan", "develop", "info" };
    private HumanControlledCharacter actor = new HumanControlledCharacter();
    private String actorName = null;
    private long id;
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
   
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    public void setAtrributes(Map<String, String> atrributes) {
        this.atrributes = atrributes;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    
    public void setId(long id) {
        this.id = id;
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
        return this.actor;
    }

    public void addSkillsArray(String[] skills) {
        
    }


}
