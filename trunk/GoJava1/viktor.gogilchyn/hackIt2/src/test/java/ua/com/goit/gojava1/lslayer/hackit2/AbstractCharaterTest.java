package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;

public class AbstractCharaterTest {
    private String eol = System.getProperty("line.separator");

    @Test
    public void testSmoke() {
        assertTrue(true);
    }
    
    @Test
    public void testSkillValueFromActor() {
        Actor actor = new HumanControlledCharacter("Test name");
        actor.addSkill("test");
        assertEquals(actor.getSkillValue("test"), 1);
        assertFalse(actor.getSkillValue("test_skill") >= 1); //Absent skill value is 0;
        actor.addSkill("test"); //Additional adding don't modify anything;
        assertEquals(actor.getSkillValue("test"), 1);
        actor.addSkill(null);
        assertEquals(0, actor.getSkillValue(null)); //null should be handled
    }
    @Test
    public void testSkillEvolve() {
        Actor actor = new HumanControlledCharacter("Test name");
        actor.addSkill("test");
        actor.evolveSkill("test");
        actor.evolveSkill(null); //Null handle
        assertEquals(actor.getSkillValue("test"), 2); //Existing skill evolve
        actor.evolveSkill("test_skill");
        assertEquals(actor.getSkillValue("test_skill"), 0); //Absent skill evolve
    }
    @Test
    public void testAllSkillsString() {
        Actor actor = new HumanControlledCharacter("Username");
        actor.addSkill(null); //Another null handle
        actor.addSkill("Cracs");
        actor.addSkill("Facs");
        actor.addSkill("Packs");
        assertEquals("Cracs: 1" + eol +
                "Facs: 1" + eol +
                "Packs: 1" + eol, actor.getAllSkills());
    }
}
