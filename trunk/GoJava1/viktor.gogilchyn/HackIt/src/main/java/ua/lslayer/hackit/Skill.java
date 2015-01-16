package ua.lslayer.hackit;

public final class Skill {
    private static final String OUTPUT_TEMPLATE = "%1$s --- %2$s";
    private String name;
    private int value;
    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return String.format(OUTPUT_TEMPLATE, this.name, this.value);
    }
    
}
