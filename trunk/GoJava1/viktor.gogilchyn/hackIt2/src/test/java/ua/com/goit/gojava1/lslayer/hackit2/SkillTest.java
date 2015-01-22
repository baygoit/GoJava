package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkillTest {
    private Skill skill;
    @Test
    public void testSkillCreation() {
        this.skill = new Skill();
        assertNotNull(skill);
    }
    
    @Test
    public void testSkillNamedCreation() {
        this.skill = new Skill("SkillName");
        assertNotNull(skill);
    }
    @Test
    public void testSkillDefaultName() {
        this.skill = new Skill();
        assertEquals("Default", skill.getName());
    }
    @Test
    public void testSkillConcreteName() {
        this.skill = new Skill("Concrete");
        assertEquals("Concrete", skill.getName());
    }
    @Test
    public void testSkillNamedCreationWithNull() {
        this.skill = new Skill(null);
        assertEquals("Default", skill.getName());
    }
    @Test
    public void testSkillDefaultNameException() {
        this.skill = new Skill();
        try {
            skill.evolve();
            fail("Exception expected");
        } catch (SkillDefaultValueException e) {
        }
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
    
}
