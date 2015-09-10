package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import belskii.artem.kickstarter.dao.project.Project;

public class ProjectModelHiberTest {

	@Test
	public void testAddProject() {
		ProjectModelHiber project = new ProjectModelHiber();
		Project projectForSave= new Project("Hiber test", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details");
		Project projectForSave1= new Project("Hiber test2", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 2, "Project details");
		Project projectForSave2= new Project("Hiber test3", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details");
		projectForSave.asqAQuestion("some test question");
		projectForSave.addPaymetVariants(100L, "thanks :)");
		project.addProject(projectForSave);
		project.addProject(projectForSave1);
		project.addProject(projectForSave2);
		
	}

	@Test
	public void testGetProjectList() {
		ProjectModelHiber project = new ProjectModelHiber();
		assertTrue(project.getProjectList().size()>0);
	}

	@Test
	public void testGetProjectDetails() {
		ProjectModelHiber project = new ProjectModelHiber();
		assertEquals("Project details",project.getProjectDetails(1).getDetails());
	}

	@Test
	public void testGetProjectFromCategory() {
		ProjectModelHiber project = new ProjectModelHiber();
		assertTrue(!project.getProjectFromCategory(1).get(0L).getName().equals(""));
		assertTrue(!project.getProjectFromCategory(2).get(0L).getName().equals(""));
		assertTrue(!project.getProjectFromCategory(3).get(0L).getName().equals(""));
	}

	@Test
	public void testUpdate() {
		ProjectModelHiber project = new ProjectModelHiber();
		Project tmpProject = project.getProjectDetails(1);
		tmpProject.updateName("New name for project");
		project.update(tmpProject);
		assertEquals("New name for project", project.getProjectDetails(1).getName());
	}
	
	@Ignore
	@Test
	public void testInitDemoDB() {
		ProjectModelHiber project = new ProjectModelHiber();
		project.initDemoDB();
	}

}
