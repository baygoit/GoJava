package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.Skill;

public class SkillTest {
    private Skill skill;
    @Test
    public void testSkillCreation() {
        this.skill = new Skill("");
        assertNotNull(skill);
    }
    @Test
    public void testValueEvolving() throws SkillDefaultValueException {
        this.skill = new Skill("TestSkill");
        skill.evolve();
        assertEquals(2, skill.getValue());
    }
    @Test 
    public void testSkillToString() {
        this.skill = new Skill("TestSkill");
        assertEquals("TestSkill - 1", skill.toString());
    }
    @Test
    public void testStaticSkillSet() {
        this.skill = new Skill("TestSkill");
    }
    @Test
    public void testSkillEquals() {
        Skill skillOne = new Skill("_");
        Skill skillTwo = new Skill("_");
        skillOne.evolve();
        assertTrue(skillOne.equals(skillTwo));
        assertNotEquals(skillOne.toString(), skillTwo.toString());
    }
}
