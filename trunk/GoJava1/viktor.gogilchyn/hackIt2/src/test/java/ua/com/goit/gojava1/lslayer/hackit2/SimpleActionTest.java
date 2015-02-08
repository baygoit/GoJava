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
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class SimpleActionTest {
    @Test
    public void testSmoke() {
        Action action = new SimpleLookAction(); 
        assertNotNull(action);
    }
    @Test
    public void testSimpleAction() throws Exception {
        ParameterObject po = new ParameterObject();
        Actor actor = new HumanControlledCharacter("Test name");
        Action action = new SimpleLookAction();
        Gear target = new ScanDevice("ScanMaster");
        ActionResult result = action.execute(po);
        assertFalse(result.isSuccess());
        assertEquals("A person needed to look", result.getResultMessage());
        po.actor = actor;
        po.targetGear = target;
        result = action.execute(po);
        assertTrue(result.isSuccess());
        assertEquals("You examined " + target.getName() + ". Looks simple, yeah?", result.getResultMessage());
    }

}
