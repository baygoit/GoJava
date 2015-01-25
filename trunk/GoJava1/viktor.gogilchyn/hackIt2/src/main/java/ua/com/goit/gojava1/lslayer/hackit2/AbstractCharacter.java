package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//import java.util.Random;
import java.util.Set;

import ua.com.goit.gojava1.lslayer.hackit2.exceptions.SkillUninitilizedException;

public abstract class AbstractCharacter implements Actor{

    private Skill getSkillByName(String skillName) throws SkillUninitilizedException {
        if (this.skills.contains(new Skill(skillName))) {
            return this.skills.get(this.skills.indexOf(new Skill(skillName)));
        } else return null;
    }
    @Override
    public int skillValue(String skillName) throws SkillUninitilizedException {
        if (this.getSkillByName(skillName) != null) {
            return this.getSkillByName(skillName).getValue();
        } else 
            return 0;
    }
    
    
    @Override
    public void evolveSkill(String skillName) throws SkillUninitilizedException {
        if (this.skillValue(skillName) > 0) {
            this.getSkillByName(skillName).evolve();
        }
    }


    protected String name;
    private List<Skill> skills = new ArrayList<Skill>();
//  private List<Gear> possesionsList;
//  private List<Gear> ControlList;
//    public void addGear(Gear gear) {
//        //There will be a lot of checks. Somewhen
////        possesions.add(gear);
//    }
//    public void removeGear(Gear gear) {
//        //There will be a lot of checks. Somewhen
////        possesions.remove(gear);
//    }
//    public boolean checkIfPossesed (Gear gear) {
//        return this.possesions.contains(gear);
//    }
    public AbstractCharacter (String name) {
        this.name = name;
    }
    public void addSkill(String skillName) throws SkillUninitilizedException {
        this.skills.add(new Skill(skillName));
    }
    @Override
    
    public List<String> listAllSkills() {
        // TODO Auto-generated method stub
        List<String> returnValue = new ArrayList<String>();
        for (Skill s : this.skills) {
            returnValue.add(s.toString());
        }
        return returnValue;
    }
    
 

}
class Skill {
    private String name = null;
    private int value = 0;
    private static Set<Skill> allPossibleSkills = new HashSet<Skill>();

    public Skill(String name) throws SkillUninitilizedException {
        if (name != null) {
            this.value = 1;
            this.name = name;
            Skill.allPossibleSkills.add(this);
        } else throw new SkillUninitilizedException("null can't be a Skill name");
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
    
//I don't know why I left this code. Mayne some time it will be needed.
    
//    public static Set<Skill> getRandomSkills(int quantity) {
//        Set<Skill> returnSet = new HashSet<Skill>();
//        if (quantity < Skill.allPossibleSkills.size()) {
//            Random rand = new Random(System.currentTimeMillis());
//            Skill[] setArray = (Skill[]) Skill.allPossibleSkills.toArray();
//            returnSet
//                    .add(setArray[rand.nextInt(Skill.allPossibleSkills.size())]);
//            if (quantity > 1) {
//                returnSet.addAll(Skill.getRandomSkills(quantity
//                        - returnSet.size()));
//            }
//            return returnSet;
//        }
//        return null;
//    }

}
