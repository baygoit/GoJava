package ua.com.goit.gojava1.lslayer.hackit2.actor;

public interface Actor {
    public String getName();

    //Skills part
    public int getSkillValue(String skillName);
    public void addSkill(String string);
    public void evolveSkill(String skillName);
    
    //UI part
    public String getAllSkills();
}
