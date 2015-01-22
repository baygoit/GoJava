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
    
}
