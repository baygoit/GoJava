package ua.lslayer.hackit;

import java.util.ArrayList;

public class Hero {
    private String name;
    private ArrayList<Skill> Skills;
    
    public Hero(String name) {
        this.name = name;
        this.Skills = new ArrayList<Skill>();
    }
    
    public String listSkills() {
        String eol = System.getProperty("line.separator");  
        String returnValue = new String();
        for (Skill element : this.Skills) {
            returnValue += element;
            returnValue += eol;
        }
        return returnValue;
    }
    
    public void addSkill(Skill skill) {
        this.Skills.add(skill);
    }
    
    public void removeSkill(Skill skill) {
        this.Skills.remove(skill);
    }
    
}
