package ua.lslayer.hackit;

import java.util.Random;

public class __Assistant {
    public static final String HERO_NAME = "M3g@p1h@R";
    public static final String ACC_NAME = "accname";
    public static final String PASSWORD = "masterkey";
    public static final String [] SKILL_ARRAY = {"Hacking", "Security", "Bruteforce"};
    
    private static int randInt(int min, int max) { //CopyPasted from StackOverflow. 
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public UserAccount makeMeAnAccountFilledWithAllINeed() {
        UserAccount returnValue = new UserAccount(ACC_NAME, PASSWORD);
        Hero goodBoy = new Hero(HERO_NAME);
        for (String skillName : SKILL_ARRAY) {
            goodBoy.addSkill(new Skill(skillName, randInt(1, 100) ));
        }
        returnValue.setHero(goodBoy);
        return returnValue;
    }
}
