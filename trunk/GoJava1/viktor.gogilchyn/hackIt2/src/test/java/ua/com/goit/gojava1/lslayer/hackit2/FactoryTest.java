package ua.com.goit.gojava1.lslayer.hackit2;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.ActorFactory;

public class FactoryTest {
    @Test
    public void testActorFactory() throws HackitWrongParameterException {
        ActorFactory f = new ActorFactory();
        f.addSkill("Hello");
        f.addSkill("world", 12);
        f.setActorName("Developer");
        
    }


}
