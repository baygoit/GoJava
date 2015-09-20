package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.SimpleExplosionAction;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.ScanDevice;

public class BoomTest {
    ActionParameters arg = null;
    ActionResult result = null;
    Actor targetActor = null;
    Action boom = null;
    Gear bomb = null;
    Gear unbreakable = null;
    Gear breakable = null;

    @Before
    public void init() throws HackitWrongParameterException {
        result = new ActionResult();
        boom = new SimpleExplosionAction();
        arg = new ActionParameters();
        targetActor = new HumanControlledCharacter("DeadMen");
        bomb = null;
        breakable = new ScanDevice("ScanMaster");
        try {
            unbreakable = new BombDevice("Concrete").addPurpose("explode",
                    10000);
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBombCreation() {
        try {
            bomb = new BombDevice("C4");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertEquals(1, bomb.getPurposeValue("explode"));
    }

    @Test
    public void testBadExplosion() throws HackitWrongParameterException {
        bomb = new BombDevice("C4");
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("explode action. Tool needed", e.getMessage());
        }

        arg.tool = bomb;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("explode action. Target needed", e.getMessage());
        }

        
        arg.targetActor = targetActor;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertTrue(result.isSuccess());
        assertEquals("DeadMen exploded!", result.getResultMessage());

        
        arg.targetActor = null;
        arg.targetGear = breakable;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertTrue(result.isSuccess());
        assertEquals("ScanMaster exploded!", result.getResultMessage());
        
        arg.targetGear = unbreakable;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertFalse(result.isSuccess());
        assertEquals("Concrete stay alive!", result.getResultMessage());
        
    }

}
