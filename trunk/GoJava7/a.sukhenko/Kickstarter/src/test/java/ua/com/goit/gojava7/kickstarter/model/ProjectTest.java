package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectTest{
    Project project = new Project();

    @Test
    public void testSetAndGetMoneyNeeded() {
        project.setMoneyNeeded(1000.0);
        assertThat(project.getMoneyNeeded(), is(1000.0));
    }

    @Test
    public void testProject() {
        assertNotNull(project);
    }

    @Test
    public void testProject4() {
        Category projectCategory = new Category();
        projectCategory.setCategoryId(5);
        LocalDateTime now = LocalDateTime.now();
        String projectName = "project";
        project = new Project();
        project.setProjectName(projectName);
        final String desc = "2";
        project.setProjectDescription(desc);
        project.setEnddate(now);
        assertThat(project.getProjectName(), is(projectName));
        assertThat(project.getProjectDescription(), is(desc));
        assertThat(project.getEnddate(), is(now));
    }

    @Test
    public void testGetProjectEndTime() {
        LocalDateTime now = LocalDateTime.now().plusDays(14).minusHours(1);
        project = new Project();
        project.setEnddate(now);
        assertThat(project.getProjectEndTime(), is("13 days to go"));

        project.setEnddate(LocalDateTime.now().plusHours(4).minusMinutes(1));
        assertThat(project.getProjectEndTime(), is("239 minutes to go"));

        project.setEnddate(LocalDateTime.now().plusHours(4));
        assertThat(project.getProjectEndTime(), is("4 hours to go"));
    }

    @Test
    public void testSetGetProjectName() {
        project.setProjectName("Test");
        assertThat(project.getProjectName(), is("Test"));
    }

    @Test
    public void testSetProjectName() {
        project.setProjectName("One");
        assertNotNull(project.getProjectName());
    }

    @Test
    public void testGetProjectDescription() {
        project.setProjectDescription("Descrption");
        assertThat(project.getProjectDescription(), is("Descrption"));
    }

    @Test
    public void testSetProjectDescription() {
        project.setProjectDescription("TestX");
        assertNotNull(project.getProjectDescription());
    }

    @Test
    public void testGetEndDate() {
        LocalDateTime loc = LocalDateTime.now();
        project.setEnddate(loc);
        assertThat(project.getEnddate(), is(loc));
    }

    @Test
    public void testGetProjectHistory() {
        String projectHistory = "History";
        project.setProjectHistory(projectHistory);
        assertThat(project.getProjectHistory(), is(projectHistory));
    }

    @Test
    public void testGetDemoLink() {
        String demoLink = "Link";
        project.setDemoLink(demoLink);
        assertThat(project.getDemoLink(), is(demoLink));
    }

}
