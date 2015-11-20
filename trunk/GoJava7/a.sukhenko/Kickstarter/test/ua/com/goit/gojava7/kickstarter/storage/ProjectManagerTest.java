package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectManagerTest{
	ProjectManager projectManager = new ProjectManager();

	@Test
	public void testAddProject() {
		projectManager.addProject(new Project());
		assertThat(projectManager.getProjects().size(), is(1));
	}

	@Test
	public void testGetProjectByName() {
		Project project = new Project();
		String projectName = "ProjectName";
		project.setProjectName(projectName);
		projectManager.addProject(project);
		assertThat(projectManager.getProjectByName(projectName), is(project));
	}

}
