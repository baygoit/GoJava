package ua.com.goit.gojava1.lslayer.hackit2;

public final class ActorFactory {
    private ActorFactory() {
        
    }
    public static Actor makeActor(String name) {
        Actor actor = new HumanControlledCharacter(name);
        return actor;
    }
}
