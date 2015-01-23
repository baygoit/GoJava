package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractCharaterTest {
    @Test
    public void testSmoke() {
        assertTrue(true);
    }
    @Test
    public void testSkillCreation() {
        Skill s = new Skill("SkillName");
        assertNotNull(s);
    }
    @Test
    public void testSkillName() {
        Skill s = new Skill("SkillName");
        assertEquals(s.getName(), "SkillName");
    }
    @Test
    public void testStaticSkill() {
        assertNull(Skill.getRandomSkills(1));
    }
}
