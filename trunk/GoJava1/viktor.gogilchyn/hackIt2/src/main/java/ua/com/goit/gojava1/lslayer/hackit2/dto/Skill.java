package ua.com.goit.gojava1.lslayer.hackit2.dto;

import java.util.HashSet;
import java.util.Set;

import ua.com.goit.gojava1.lslayer.hackit2.SkillDefaultValueException;

public class Skill {
    private String name = null;
    private int value = 0;
    private static Set<Skill> allPossibleSkills = new HashSet<Skill>();

    @SuppressWarnings("unused")
    private Skill() {
        
    }

    public Skill(String name) {
        if (name != null) {
            this.value = 1;
            this.name = name;
            Skill.allPossibleSkills.add(this);
        }
    }
    
    public String getName() {
        return this.name;
    }

    public void evolve() {
            this.value += 1;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && ((Skill) obj).getName() == this.name) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.value;
    }

}
