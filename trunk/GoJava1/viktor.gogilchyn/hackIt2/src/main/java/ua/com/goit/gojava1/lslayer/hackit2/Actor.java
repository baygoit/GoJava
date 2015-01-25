package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.exceptions.SkillUninitilizedException;

public interface Actor {
    public int skillValue(String skillName) throws SkillUninitilizedException;
    public String getName();
    public void addSkill(String string) throws SkillUninitilizedException;
    public void evolveSkill(String skillName) throws SkillUninitilizedException;
    
    //UI part
    public List<String> listAllSkills();
}
