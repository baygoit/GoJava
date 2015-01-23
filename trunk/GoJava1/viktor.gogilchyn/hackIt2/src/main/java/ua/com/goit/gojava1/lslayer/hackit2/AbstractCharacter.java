package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class AbstractCharacter implements Actor{
    protected String name;
    private List<Skill> skills;
    private List<Gear> possesions;
    public void addGear(Gear gear) {
        //There will be a lot of checks. Somewhen
        possesions.add(gear);
    }
    public void removeGear(Gear gear) {
        //There will be a lot of checks. Somewhen
        possesions.remove(gear);
    }
    public boolean checkIfPossesed (Gear gear) {
        return this.possesions.contains(gear);
    }
    public AbstractCharacter (String name) {
        this.name = name;
    }
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

}
class Skill {
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
    
    public static Set<Skill> getRandomSkills(int quantity) {
        if (quantity < 0) return new HashSet<Skill>();
        if (quantity < Skill.allPossibleSkills.size()) {
            Set<Skill> returnSet = new HashSet<Skill>();
            int index = new Random().nextInt(allPossibleSkills.size());
            Iterator<Skill> iter = allPossibleSkills.iterator();
            for (int i = 0; i < index; i++) {
                iter.next();
            }
            returnSet.add(iter.next());
            returnSet.addAll(Skill.getRandomSkills(quantity - returnSet.size()));
            return returnSet;
        }
        return null;
    }

}
