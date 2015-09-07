package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ProjectDaoImplFileTest {
	private ProjectDao projectsDao = new ProjectDaoImplFile();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddProject() {
		Project project = new Project("test project from testAddProject() implementation for file Art category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details");
		project.asqAQuestion("question1");
		project.getAnswerForQuestion(0L, "answer for first question");
		project.asqAQuestion("additional question");
		project.getAnswerForQuestion(1L, "answer for second question");
		project.addPaymetVariants(10L, "small bonus");
		project.addPaymetVariants(30L, "standart bonus");
		project.addPaymetVariants(50L, "extra bonus");
		projectsDao.addProject(project);

		project = new Project("test project from testAddProject() implementation for file Comics category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 2, "Project details");
		project.asqAQuestion("question1");
		project.getAnswerForQuestion(0L, "answer for first question");
		project.asqAQuestion("additional question");
		project.getAnswerForQuestion(1L, "answer for second question");
		project.addPaymetVariants(10L, "small bonus");
		project.addPaymetVariants(30L, "standart bonus");
		project.addPaymetVariants(50L, "extra bonus");
		projectsDao.addProject(project);
		
	}

	@Test
	public void testGetProjectList() {
		assertTrue(projectsDao.getProjectList().size()>0);
	}

	@Test
	public void testGetProjectDetails() {
		assertEquals("test project from testAddProject() implementation for file Comics category", projectsDao.getProjectList().get(1L).getName());
	}

	@Test
	public void testGetProjectFromCategory() {
		assertFalse(projectsDao.getProjectFromCategory(2).get(0L).getName().isEmpty());
	}
	
	@Test
	public void testGetProjectId(){
		assertEquals("1",projectsDao.getProjectList().get(1L).getProjectId().toString());
	}
	
	@Test
	public void testCommit(){
		Project currentProject = projectsDao.getProjectDetails(0);
		Random random=new Random();
		String newName="MynewName"+String.valueOf(random.nextInt((Integer.MAX_VALUE)));
		currentProject.updateName(newName);
		projectsDao.update(currentProject);
		assertEquals(newName, projectsDao.getProjectDetails(0).getName());
	}

}
