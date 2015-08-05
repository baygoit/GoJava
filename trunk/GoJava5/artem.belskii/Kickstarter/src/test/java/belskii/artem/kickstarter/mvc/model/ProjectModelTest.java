package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;
import belskii.artem.kickstarter.dao.project.ProjectDaoImplHardCoding;

public class ProjectModelTest {
	ProjectDao projects;
	private HashMap<Long, String> paymentVariants;
	@Before
	public void setUp() throws Exception {
		projects = new ProjectDaoImplHardCoding();
		paymentVariants = new HashMap<Long, String>();
		paymentVariants.put(new Long(10), "some bonus");
		paymentVariants.put(new Long(30), "other bonus");
		paymentVariants.put(new Long(50), "extra bonus");
		
	}

	@Test
	public void testAddProject() {
		Project testProject = new Project("My test project",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "My super project!");
		projects.addProject(testProject);
		
		assertEquals("My test project from Art category", projects.getProjectDetails(0).getName()); //TODO: return newProjectId and check it
	}

	@Test
	public void testGetProjectList() {
		assertNotNull(projects.getProjectList());
	}

	@Test
	public void testGetProjectDetails() {
		assertEquals("My test project from Art category", projects.getProjectDetails(0).getName());
	}
	
	@Test
	public void getProjectFromCategory(){
		Project projectFromCategory = new Project("Project from category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 5, "My super project2!");
		projects.addProject(projectFromCategory);
		assertEquals("My test project from Art category", projects.getProjectFromCategory(1).get(new Long(0)).getName());
	}

}
