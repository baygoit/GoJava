package ua.com.goit.gojava1.lslayer.hackit2;

public class Skill {
    private String name;
    private int value;

    public Skill() {
        this.value = 0;
        this.name = "Default";
    }

    public Skill(String name) {
        if (name == null) {
            this.value = 0;
            this.name = "Default";
        } else {
            this.value = 1;
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void evolve() throws SkillDefaultValueException {
        if (this.value > 0) {
            this.value += 1;
        } else throw new SkillDefaultValueException();
    }

    public int getValue() {
        // TODO Auto-generated method stub
        return this.value;
    }

}
