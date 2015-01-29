package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.ScanDevice;

public class ScanActionTest {
    @Test
    public void testSmoke() {
        Action action = new ScanAction(); 
        assertNotNull(action);
    }
    @Test
    public void testSimpleAction() {
        Actor actor = new HumanControlledCharacter("Test name");
        Action action = new SimpleLookAction();
        ActionResult result = action.execute(actor);
        assertTrue(result.isSuccess());
        assertEquals(result.getResultMessage(), "You examined the universe. Looks simple, yeah?");
        Gear target = new ScanDevice("ScanMaster");
        result = action.execute(actor, null, target);
        assertTrue(result.isSuccess());
        assertEquals(result.getResultMessage(), "You examined " + target.getName() + ". Looks simple, yeah?");
    }

}
