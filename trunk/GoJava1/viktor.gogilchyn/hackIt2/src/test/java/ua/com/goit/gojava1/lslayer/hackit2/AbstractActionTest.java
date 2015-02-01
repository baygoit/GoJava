package ua.com.goit.gojava1.lslayer.hackit2;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.InformationAction;
import ua.com.goit.gojava1.lslayer.hackit2.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;

public class AbstractActionTest {
    @Test
    public void testGetInfo() {
        Action action = new InformationAction();
        Actor actor = new HumanControlledCharacter("UserName");
        actor.setAttribute("CCN", "1234 5678 6543 2345");
        
    }
}
