package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.SimpleLookAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

public class SimpleActionTest {
    @Test
    public void testSmoke() {
        Action action = new SimpleLookAction(); 
        assertNotNull(action);
    }
    @Test
    public void testSimpleAction() {
        ParameterObject po = new ParameterObject();
        Actor actor = new HumanControlledCharacter("Test name");
        Action action = new SimpleLookAction();
        po.actor = actor;
        ActionResult result = action.execute(po);
        assertTrue(result.isSuccess());
        assertEquals(result.getResultMessage(), "You examined the universe. Looks simple, yeah?");
        Gear target = new ScanDevice("ScanMaster");
        po.target = target;
        result = action.execute(po);
        assertTrue(result.isSuccess());
        assertEquals(result.getResultMessage(), "You examined " + target.getName() + ". Looks simple, yeah?");
    }

}
