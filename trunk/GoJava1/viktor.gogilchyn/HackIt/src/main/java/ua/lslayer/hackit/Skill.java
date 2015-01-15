package ua.lslayer.hackit;

public final class Skill {
    private static final String OUTPUT_TEMPLATE = "@";
    private String name;
    private int value;
    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.name + Skill.OUTPUT_TEMPLATE + this.value;
    }
    
}
