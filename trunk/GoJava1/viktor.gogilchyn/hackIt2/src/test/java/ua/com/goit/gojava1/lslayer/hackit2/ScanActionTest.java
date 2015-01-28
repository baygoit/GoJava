package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.exceptions.SkillUninitilizedException;

public class ScanActionTest {
    @Test
    public void testSmoke() {
        Action action = new ScanAction(); 
        assertNotNull(action);
    }
    @Test
    public void testFailedAndSuccessAction() throws SkillUninitilizedException {
        Actor actor = new HumanControlledCharacter("Test name");
        actor.addSkill("test");
        Action action = new ScanAction();
        ActionResult result = action.execute(actor);
        assertFalse(result.isSuccess());
        assertEquals(result.getResultMessage(), "Scan failed");
        actor.addSkill("scan");
        ActionResult resultTwo = action.execute(actor);
        assertTrue(resultTwo.isSuccess());
        assertEquals(resultTwo.getResultMessage(), "Scan successful");
    }

}
