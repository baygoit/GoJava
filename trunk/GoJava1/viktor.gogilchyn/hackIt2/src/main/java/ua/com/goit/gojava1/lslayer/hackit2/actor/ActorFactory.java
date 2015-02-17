package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.HashSet;
import java.util.Set;

import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

public class ActorFactory {
    private static final String[] DEFAULT_SKILLS = { "scan", "develop", "info" };

    private String actorName = null;
    private Set<String> skills = new HashSet<String>(); // Hash is for unique
                                                        // skills;

    // Newborn hero can't have evolved skills.
    public ActorFactory addSkill(String skill)
            throws HackitWrongParameterException {
        if (skill != null) {
            this.skills.add(skill);
        } else {
            throw new HackitWrongParameterException("Skill can't be null");
        }
        return this;
    }

    public void addSkillsArray(String[] skills) {
        if (skills != null) {
            for (String skill : skills) {
                this.skills.add(skill);
            }
        }
    }

    // Every newborn hero should have default skills
    public Actor createActor() {
        Actor newbornHero = this.createDefaultActor(this.actorName);
        for (String skill : this.skills) {
            newbornHero.addSkill(skill);
        }
        return newbornHero;
    }

    private Actor createActorWithSkills(String actorName, String[] skills) {
        Actor actor = this.createEmptyActor(actorName);
        if ((actor != null) && (skills != null)) {
            for (String skill : skills) {
                actor.addSkill(skill);
            }
            return actor;
        }
        return null;
    }

    private Actor createDefaultActor(String actorName) {
        return this.createActorWithSkills(actorName,
                ActorFactory.DEFAULT_SKILLS);
    }

    private Actor createEmptyActor(String actorName) {
        if (actorName != null) {
            return new HumanControlledCharacter(actorName);
        }
        return null;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

}
