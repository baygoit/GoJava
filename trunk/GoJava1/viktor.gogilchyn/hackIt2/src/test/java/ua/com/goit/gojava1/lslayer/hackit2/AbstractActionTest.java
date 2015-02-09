package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.InfoAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.InfoDevice;

public class AbstractActionTest {
    private ParameterObject po = new ParameterObject();
    private Actor actor = new HumanControlledCharacter("MegaPihar");

    @Test
    public void testGetInfo() throws Exception {
        String eol = System.getProperty("line.separator");
        InfoDevice tool = new InfoDevice("Tool");
        Action action = new InfoAction();
        actor.addAttribute("CCN", "1234 5678 6543 2345");

        po.actor = actor;
        po.targetActor = actor;
        action.setParameters(po);
        ActionResult result = action.execute();
        assertFalse(result.isSuccess());
        assertEquals("A tool needed to info", result.getResultMessage());

        po.value = 100; //100% chance to get info
        po.tool = tool;
        action.setParameters(po);
        result = action.execute();
        assertTrue(result.isSuccess());
        assertEquals("CCN: 1234 5678 6543 2345" + eol, result.getResultMessage());

        po.value = 1; //1% chance to get info. Very rare chance to fail test
        //TODO Make an mechanism to test chanced methods
        action.setParameters(po);
        result = action.execute();
        assertTrue(result.isSuccess());
        assertEquals("CCN: ?????" + eol, result.getResultMessage());
        
    }
}
