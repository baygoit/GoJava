package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class BonusTest{
    private Bonus bonus = new Bonus();

    @Test
    public void testGetId() {
        bonus.setId(1);
        assertThat(bonus.getId(), is(1));
    }

    @Test
    public void testGetProjectId() {
        bonus.setProjectId(15);
        assertThat(bonus.getProjectId(), is(15));
    }

    @Test
    public void testGetAmount() {
        bonus.setAmount(1000.0);
        assertThat(bonus.getAmount(), is(1000.0));
    }

    @Test
    public void testGetBonus() {
        final String bonus2 = "Bonus Test";
        bonus.setBonus(bonus2);
        assertThat(bonus.getBonus(), is(bonus2));
    }

    @Test
    public void testGetProject() {
        Project project = new Project();
        bonus.setProject(project);
        assertThat(bonus.getProject(), is(project));
    }

}
