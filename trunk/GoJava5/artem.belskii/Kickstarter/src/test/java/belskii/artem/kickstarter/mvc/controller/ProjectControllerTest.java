package belskii.artem.kickstarter.mvc.controller;

import static org.junit.Assert.*;


import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.model.ProjectModel;

public class ProjectControllerTest {
	private ProjectController project;
	private HashMap<Long, Project> projectForEquals= new HashMap<Long, Project>();
	
	private HashMap<Long, String> paymentVariants;
	@Before
	public void setUp() throws Exception {
		paymentVariants = new HashMap<Long, String>();
		paymentVariants.put(new Long(10), "some bonus");
		paymentVariants.put(new Long(30), "other bonus");
		paymentVariants.put(new Long(50), "extra bonus");
		project = new ProjectController(new ProjectModel());
		projectForEquals.put(new Long(0), new Project("My test project from Art category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
		projectForEquals.put(new Long(1), new Project("My test project1 from Comics category",new Long(2), new Long(2),"29.07.2015","31.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 2,"Project details"));
		projectForEquals.put(new Long(2), new Project("My test project2 from Crafts category",new Long(3), new Long(3),"30.07.2015","01.08.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details"));

	}

	@Test
	public void testProjectController() {
		assertNotNull(project);
	}

	@Test
	public void testAddProject() {
		project.addProject(new Project("testAddProject", new Long(1),new Long(1),"01.01.2015","31.12.2015","https://somwurl.com",1,"project for testAddProject test"));
	}

	@Test
	public void testGetProjectList() {
		assertTrue(project.getProjectList().size()>=1);
	}

	@Test
	public void testGetProjectFromCategory() {
		assertTrue(!project.getProjectFromCategory(1).get(new Long(0)).getName().equals(""));
	}
	
	@Test
	public void testGetProjectIdfromPositionInCategoryList(){
		assertTrue(!project.getProjectFromCategory(1).get(0L).getProjectId().getClass().equals("Long"));
	}
	
	@Test
	public void testAsqAQuestion(){
		project.getProjectById(1).asqAQuestion("My test question");
	}
	
	@Test
	public void testGetAnswerForQuestion(){
		project.getProjectById(1).asqAQuestion("testgetAnswerForQuestion");
		project.getProjectById(1).getAnswerForQuestion(0L, "responce for testgetAnswerForQuestion");
	}
	
	@Test
	public void testGetFaq(){
		Project projectTmp;
		projectTmp=project.getProjectById(1);
		projectTmp.asqAQuestion("Question 1");
		project.save(projectTmp);
		
		projectTmp=project.getProjectById(2);
		projectTmp.asqAQuestion("Question 2");
		projectTmp.asqAQuestion("Question 2.1");
		project.save(projectTmp);

		projectTmp=project.getProjectById(3);
		projectTmp.asqAQuestion("Question 2");
		project.save(projectTmp);
		
		
		System.out.println(project.getProjectById(2).getFaq());
		assertTrue(project.getProjectById(1).getFaq().size()>=1);
		assertTrue(project.getProjectById(2).getFaq().size()>=2);
		assertTrue(project.getProjectById(3).getFaq().size()>=1);
		
	}
	
	@Test
	public void testQustomPayment(){
		Project projectTmp=project.getProjectById(1);
		Long balance=projectTmp.getBalance()+10L;
		projectTmp.updateBalance(10L);
		project.save(projectTmp);
		assertEquals(balance,project.getProjectById(1).getBalance());
	}
}
