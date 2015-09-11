package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectDaoImplHiberTest {

	@Test
	public void testAddProject() {
		ProjectDao project = new ProjectDaoImplHiber();
		Project projectForSave= new Project("Hiber test", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details");
		projectForSave.asqAQuestion("some test question");
		projectForSave.addPaymetVariants(100L, "thanks :)");
		project.addProject(projectForSave);
		
	}

	@Test
	public void testGetProjectList() {
		ProjectDao project = new ProjectDaoImplHiber();
		assertTrue(project.getProjectList().size()>0);
	}

	@Test
	public void testGetProjectDetails() {
		ProjectDao project = new ProjectDaoImplHiber();
		assertEquals("Project details",project.getProjectDetails(1).getDetails());
	}

	@Test
	public void testGetProjectFromCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitDemoDB() {
		fail("Not yet implemented");
	}

}
