package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;

@Configuration
public class ActorFactory {
    
//    @Bean
//    public ActorFactory getInstance() {
//        return this;
//    }
    
    private static final int DEFAULT_SKILL_VALUE = 1;
    private HumanControlledCharacter actor = new HumanControlledCharacter();
    private String actorName = null;
    private long id = -1;
    private Position position = new Position();
    private List<Skill> skills = new ArrayList<Skill>();
    private List<Attribute> atrributes = new ArrayList<Attribute>();

    public long getId() {
        return id;
    }

    public ActorFactory addSkill(String skill, int value)
            throws HackitWrongParameterException {
        if (skill != null) {
            this.skills.add(new Skill(skill, value));
        } else {
            throw new HackitWrongParameterException("Skill can't be null");
        }
        return this;
    }

    public ActorFactory addSkill(String skill)
            throws HackitWrongParameterException {
        if (skill != null) {
            this.skills.add(new Skill(skill, DEFAULT_SKILL_VALUE));
        } else {
            throw new HackitWrongParameterException("Skill can't be null");
        }
        return this;
    }
    
    public ActorFactory addAttribute(String attribute, String value) {
        this.atrributes.add(new Attribute (attribute, value));
        return this;
    }
    
    public ActorFactory setPosition(Position position) {
        this.position = position;
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

    public void incSkill(String string, int int1) {
        // TODO Auto-generated method stub
        
    }


}
