package ua.com.goit.gojava1.lslayer.hackit2.actor;

public class ActorFactory {
    private static final String [] DEFAULT_SKILLS = {"scan", "develop", "info"};
    public static Actor createDefaultActor(String actorName) {
        return createActorWithSkills(actorName, DEFAULT_SKILLS);
    }
    
    public static Actor createEmptyActor(String actorName) {
        if (actorName != null) {
            return new HumanControlledCharacter(actorName);
        }
        return null;
    }
    
    public static Actor createActorWithSkills(String actorName, String [] skills) {
        Actor actor = createEmptyActor(actorName);
        if (actor != null && skills != null) {
            for (String skill : skills) actor.addSkill(skill);
            return actor;
        }
        return null;
    }

}
