package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;

public class Skill {

    private String name;
    private int value;

    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Skill() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
