package ua.com.goit.gojava1.lslayer.hackit2.actor;

public class HumanControlledCharacter extends AbstractCharacter implements HumanControlled {

    public HumanControlledCharacter(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

}
