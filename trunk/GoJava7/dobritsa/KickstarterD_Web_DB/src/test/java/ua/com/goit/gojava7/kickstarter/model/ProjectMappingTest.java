package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:H2ApplicationContext*.xml")
@Transactional
public class ProjectMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	@Ignore
	public void testBasicUsage() {
		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Category category2 = new Category();
		category2.setName("TestCategory 2");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Project project2 = new Project();
		project2.setName("TestName2");
		project2.setDescription("TestDescription2");
		project2.setGoal(200L);
		project2.setDaysToGo(2L);
		project2.setHistory("TestHistory2");
		project2.setLink("TestLink2");
		project2.setCategory(category2);

		em.persist(project1);
		em.persist(project2);
		Long projectId1 = project1.getProjectId();
		Long categoryId1 = category1.getCategoryId();

		System.out.println("\n-----Get Project by id = 1-----");	
		Project project = em.find(Project.class, projectId1);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");	
		Category category = em.find(Category.class, categoryId1);
		System.out.println("Category: " + category);
	
//		System.out.println("\n-----Get list of projects-----");
//		List<Project> projects = (List<Project>) session.createQuery("from Project q").list();
//		for (Project resultProject : projects) {
//			System.out.println("Project: " + resultProject);
//		}
	}
}
