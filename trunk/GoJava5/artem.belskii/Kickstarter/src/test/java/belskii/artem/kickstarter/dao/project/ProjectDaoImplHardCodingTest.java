package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectDaoImplHardCodingTest {
	private ProjectDao projectsDao = new ProjectDaoImplHardCoding();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetProjectDetails() {
		assertEquals("Project details", projectsDao.getProjectList().get(new Long(0)).getDetails());
	}

	@Test
	public void testProjectDaoImplHardCoding() {
		assertNotNull(projectsDao);	
	}

	@Test
	public void testAddProject() {
		projectsDao.addProject(new Project("test project from testAddProject()",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
	}

	@Test
	public void testGetProjectList() {
		assertNotNull(projectsDao.getProjectList());
	}

	@Test
	public void testGetProjectFromCategory() {
		assertNotNull(projectsDao.getProjectFromCategory(1).get(new Long(0)).getName());
	}

}
