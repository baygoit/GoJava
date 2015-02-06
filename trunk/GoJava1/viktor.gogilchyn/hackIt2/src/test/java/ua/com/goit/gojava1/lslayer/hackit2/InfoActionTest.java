package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.InfoAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.InfoDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

public class InfoActionTest {
    private ParameterObject po = new ParameterObject();
    private Actor actor = new HumanControlledCharacter("MegaPihar");
    @Test
    public void testInfoAction() throws Exception {
        InfoDevice tool = new InfoDevice("Tool");
        Gear target =  new ScanDevice("Target"); 
        po.actor = actor;
        Action action = new InfoAction();
        ActionResult result = action.execute(po);
        assertFalse(result.isSuccess());
        assertEquals("A tool needed to info", result.getResultMessage());

        po.tool = tool;
        po.targetGear = target;
        result = action.execute(po);
        assertTrue(result.isSuccess());
        assertEquals(target.getName(), result.getResultMessage());
        
    }

}
