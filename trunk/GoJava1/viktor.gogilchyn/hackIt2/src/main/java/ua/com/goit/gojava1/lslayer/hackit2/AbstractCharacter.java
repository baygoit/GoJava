package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.dto.Skill;

public abstract class AbstractCharacter implements Actor{
    protected String name;
    private List<Skill> skills;
    public AbstractCharacter (String name) {
        this.name = name;
    }
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

}
