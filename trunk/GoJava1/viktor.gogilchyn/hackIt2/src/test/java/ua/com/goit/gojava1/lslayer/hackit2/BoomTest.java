package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.SimpleExplosionAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class BoomTest {
    @Test
    public void testGoodBoom() {
        ActionResult result = null;
        Action boom = new SimpleExplosionAction();
        Gear bomb = null;
        try {
            bomb = new BombDevice("C4");
        } catch (HackitWrongParameterException e) {
            fail("Exception unexpected");
        }
        assertEquals(1, bomb.getPurposeValue("explode"));
        ActionParameters arg = new ActionParameters();

        arg.tool = bomb;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("explode action. Target nedded", e.getMessage());
        }
        try {
            arg.targetGear = new ScanDevice("ScanMaster");
        } catch (HackitWrongParameterException e) {
            fail("unexpected exception");
        }
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            fail("unexpected exception");
        }
        assertTrue(result.isSuccess());
        assertEquals("ScanMaster exploded!", result.getResultMessage());
        arg.targetActor = new HumanControlledCharacter("DeadMen");
        arg.targetGear = null;
        boom.setParameters(arg);
        try {
            result = boom.execute();
        } catch (HackitWrongParameterException e) {
            // TODO Auto-generated catch block
            fail("unexpected exception");
        }
        assertTrue(result.isSuccess());
        assertEquals("DeadMen exploded!", result.getResultMessage());
    }

}
