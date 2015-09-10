package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ProjectDaoImplHiberTest {

	@Test
	public void testAddProject() {
		ProjectDao project = new ProjectDaoImplHiber();
		Project projectForSave= new Project("Hiber test", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 150, "Project details");
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
		ProjectDao project = new ProjectDaoImplHiber();
		assertTrue(!project.getProjectFromCategory(1).get(0L).getName().equals(""));
		assertTrue(!project.getProjectFromCategory(150).get(0L).getName().equals(""));
	}

	@Test
	public void testUpdate() {
		ProjectDao project = new ProjectDaoImplHiber();
		Project tmpProject = project.getProjectDetails(1);
		tmpProject.updateName("New name for project");
		project.update(tmpProject);
		assertEquals("New name for project", project.getProjectDetails(1).getName());
	}
	
	@Ignore
	@Test
	public void testInitDemoDB() {
		ProjectDao project = new ProjectDaoImplHiber();
		project.initDemoDB();
	}

}
