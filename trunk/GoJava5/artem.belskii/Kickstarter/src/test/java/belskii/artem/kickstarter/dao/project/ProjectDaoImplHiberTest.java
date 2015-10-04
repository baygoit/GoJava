package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ProjectDaoImplHiberTest {

	@Test
	public void testAddProject() {
		ProjectDao project = new ProjectDaoImplHiber();
		project.addProject(new Project("Hiber test", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
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
		assertEquals("Project details", project.getProjectFromCategory(1).get(0L).getDetails());
		
	}

	@Test
	public void testUpdate() {
		ProjectDao project = new ProjectDaoImplHiber();
		Project tmpProject=project.getProjectDetails(1);
		tmpProject.updateName("New Project Name");
		project.update(tmpProject);
		assertEquals("New Project Name", project.getProjectDetails(1).getName());
		
	}

	@Test @Ignore
	public void testInitDemoDB() {
		fail("Not yet implemented");
	}

}
