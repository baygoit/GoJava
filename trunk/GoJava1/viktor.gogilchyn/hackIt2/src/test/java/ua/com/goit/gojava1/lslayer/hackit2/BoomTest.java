package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.SimpleExplosionAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

public class BoomTest {
    @Test
    public void testGoodBoom() {
        Action boom = new SimpleExplosionAction();
        Gear bomb = new BombDevice("C4");
        assertEquals(1, bomb.getPurposeValue("explode"));
        ParameterObject arg = new ParameterObject();

        arg.tool = bomb;
        ActionResult result = boom.execute(arg);
        assertFalse(result.isSuccess());
        assertEquals("A target needed to explode", result.getResultMessage());
        arg.targetGear = new ScanDevice("ScanMaster");
        result = boom.execute(arg);
        assertTrue(result.isSuccess());
        assertEquals("ScanMaster exploded!", result.getResultMessage());
        arg.targetActor = new HumanControlledCharacter("DeadMen");
        arg.targetGear = null;
        result = boom.execute(arg);
        assertTrue(result.isSuccess());
        assertEquals("DeadMen exploded!", result.getResultMessage());
    }

}
