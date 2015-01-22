package ua.com.goit.gojava1.lslayer.hackit2;

public class Skill {
    private String name;

    public Skill() {
        this.name = "Default";
    }

    public Skill(String name) {
        if (name == null) { 
            this.name = "Default";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

}
