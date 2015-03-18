package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.SimpleLookAction;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.ScanDevice;

public class SimpleActionTest {
    @Test
    public void testSmoke() {
        Action action = new SimpleLookAction(); 
        assertNotNull(action);
    }
    @Test
    public void testSimpleAction() {
        ActionParameters po = new ActionParameters();
        Actor actor = new HumanControlledCharacter("Test name");
        Action action = new SimpleLookAction();
        Gear target = null;
        ActionResult result = null;
        try {
            target = new ScanDevice("ScanMaster");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("look action. Target nedded", e.getMessage());
        }
        po.actor = actor;
        po.targetGear = target;
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertTrue(result.isSuccess());
        assertEquals("You examined " + target.getName() + ". Looks simple, yeah?", result.getResultMessage());
        
        po.actor = null;
        po.targetGear = target;
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertTrue(result.isSuccess());
        assertEquals("You examined " + target.getName() + ". Looks simple, yeah?", result.getResultMessage());
        
        po.targetActor = actor;
        po.targetGear = null;
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertTrue(result.isSuccess());
        assertEquals("You examined " + actor.getName() + ". Looks simple, yeah?", result.getResultMessage());
    }

}
