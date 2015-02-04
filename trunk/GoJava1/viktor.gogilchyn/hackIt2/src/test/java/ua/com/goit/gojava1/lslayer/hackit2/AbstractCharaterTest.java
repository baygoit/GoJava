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
        assertEquals(actor.getSkill("test"), 1);
        assertFalse(actor.getSkill("test_skill") >= 1); //Absent skill value is 0;
        actor.addSkill("test"); //Additional adding don't modify anything;
        assertEquals(actor.getSkill("test"), 1);
        actor.addSkill(null);
        assertEquals(0, actor.getSkill(null)); //null should be handled
    }
    @Test
    public void testSkillEvolve() {
        Actor actor = new HumanControlledCharacter("Test name");
        actor.addSkill("test");
        actor.incSkill("test", 1);
        actor.incSkill(null, 1); //Null handle
        assertEquals(actor.getSkill("test"), 2); //Existing skill evolve
        actor.incSkill("test_skill", 1);
        assertEquals(actor.getSkill("test_skill"), 0); //Absent skill evolve
    }
    @Test
    public void testAllSkillsString() {
        Actor actor = new HumanControlledCharacter("Username");
        actor.addSkill(null); //Another null handle
        actor.addSkill("Cracs");
        actor.addSkill("Facs");
        actor.addSkill("Packs");
        assertEquals("{Cracs=1, Facs=1, Packs=1}", actor.getSkills().toString());
        assertEquals("Username" + eol +
                     "{Cracs=1, Facs=1, Packs=1}", actor.getStringForOutput());
        assertEquals("Actor [name=Username, skills={Cracs=1, Facs=1, Packs=1}]", actor.toString());
    }
    
    @Test
    public void testAttributes() {
        Actor actor = new HumanControlledCharacter("UserName");
        actor.addAttribute("CCN", "1234 5678 6543 2345");
        assertEquals("1234 5678 6543 2345", actor.getAttribute("CCN"));
        assertEquals(1, actor.getAttributes().size());
        assertEquals("",actor.getAttribute("None"));
    }
    
}
