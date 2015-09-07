package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectDaoImplPsqlTest {
	String CONFIG_PATH="src/test/conf/database.conf";
	ProjectDao project = new ProjectDaoImplPsql(CONFIG_PATH);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProjectDaoImplPsql() {
		assertNotNull(project);
	}

	@Test
	public void testAddProject() {
		project.addProject(new Project("My test project from Art category", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
		project.addProject(new Project("My test project1 from Comics category", new Long(2), new Long(2), "29.07.2015",	"31.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 2, "Project details"));
		project.addProject(new Project("My test project2 from Crafts category", new Long(3), new Long(3), "30.07.2015",	"01.08.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details"));
		Project tmpProject = project.getProjectDetails(1); 
		tmpProject.addPaymetVariants(10L, "small bonus for project 1");
		tmpProject.addPaymetVariants(30L, "standart bonus for project 1");
		tmpProject.addPaymetVariants(50L, "extra bonus for project 1");
		tmpProject.asqAQuestion("firs question");
		tmpProject.asqAQuestion("second question");
		project.update(tmpProject);
		
		tmpProject = project.getProjectDetails(2);
		tmpProject.addPaymetVariants(10L, "small bonus for project 2");
		tmpProject.addPaymetVariants(30L, "standart bonus for project 2");
		tmpProject.addPaymetVariants(50L, "extra bonus for project 2");
		tmpProject.asqAQuestion("firs question");
		tmpProject.asqAQuestion("second question");
		project.update(tmpProject);
		
		tmpProject = project.getProjectDetails(3);
		tmpProject.addPaymetVariants(10L, "small bonus for project 3");
		tmpProject.addPaymetVariants(30L, "standart bonus for project 3");
		tmpProject.addPaymetVariants(50L, "extra bonus for project 3");
		tmpProject.asqAQuestion("firs question");
		tmpProject.asqAQuestion("second question");
		project.update(tmpProject);
	}

	@Test
	public void testGetProjectList() {
		assertNotNull(project.getProjectList().get(0L).getName());
		assertNotNull(project.getProjectList().get(0L).getPaymetVariants());
	}

	@Test
	public void testGetProjectDetails() {
		assertNotNull(project.getProjectDetails(1).getDetails());
		assertNotNull(project.getProjectDetails(2).getStartDate());
	}

	@Test
	public void testGetProjectFromCategory() {
		assertEquals("My test project from Art category", project.getProjectFromCategory(1).get(0L).getName());
		assertEquals("My test project1 from Comics category", project.getProjectFromCategory(2).get(0L).getName());
		assertEquals("My test project2 from Crafts category", project.getProjectFromCategory(3).get(0L).getName());
	}

	@Test
	public void testCommit() {
		// fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		Project updatedProject = project.getProjectDetails(1);
		updatedProject.updateName("New Name");
		assertEquals("New Name", updatedProject.getName());
		project.update(updatedProject);
		ProjectDao projectFromDb = new ProjectDaoImplPsql(CONFIG_PATH);
		assertEquals("New Name", projectFromDb.getProjectDetails(1).getName());

	}

}
