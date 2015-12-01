package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;

public class ProjectManagerTest {
	ProjectManager projectManager = new ProjectManager();
	private ArrayList<Project> projects = new ArrayList<Project>();
	@Test
	public void testAddProject() {
		projectManager.addProject(new Project());
		assertThat(projectManager.getProjects().size(), is(1));
	}
	@Test
	public void testGetProjectsByCategory(){
		Category cat1 = new Category();
		cat1.setCategoryId(5);
		Project project = new Project("Testname", "Test desc", 5, null);
		projectManager.addProject(project);
		
		assertThat(projectManager.getProjectsByCategory(cat1).get(0),is(project));
		
	}
	@Test
	public void testuserContributeToProject(){
		User user = new User();
		Project selectedProject = new Project();
		user.getSettings().setSelectedProject(selectedProject);
		Double amount = 50000.0;
		projectManager.userContributeToProject(user, amount);
		assertThat(selectedProject.getMoneyPledged(),is(amount));
	}
	
	
	@Test
	public void testGetProjectByName() {
		Project project = new Project();
		String projectName = "ProjectName";
		project.setProjectName(projectName);
		projectManager.addProject(project);
		assertThat(projectManager.getProjectByName(projectName), is(project));
	}
	
	@Test
	public void testGetProjectById(){
		Project project = new Project();
		projectManager.addProject(project);
		assertThat(projectManager.getProjectById(0),is(project));
	}
	
	@Test
	public void testSetProjects(){
		projectManager.setProjects(projects);
		assertThat(projectManager.getProjects(),is(projects));
	}

}
