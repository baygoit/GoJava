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
public class QuestionMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	@Ignore
	public void testBasicUsage() {
		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Question question1 = new Question();		
		question1.setTime("TestTime1");
		question1.setQuestion("TestQuestion1");
		question1.setAnswer("TestAnswer1");
		question1.setProject(project1);

		Question question2 = new Question();
		question2.setTime("TestTime2");
		question2.setQuestion("TestQuestion2");
		question2.setAnswer("TestAnswer2");
		question2.setProject(project1);

		em.persist(question1);
		em.persist(question2);

		Long questionId1 = question1.getQuestionId();
		Long projectId1 = project1.getProjectId();
		Long categoryId1 = category1.getCategoryId();


		System.out.println("\n-----Get Question by id = 1-----");
		Question question = em.find(Question.class, questionId1);
		System.out.println("Question: " + question);
		
		System.out.println("\n-----Get Project by id = 1-----");
		Project project = em.find(Project.class, projectId1);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");
		Category category = em.find(Category.class, categoryId1);
		System.out.println("Category: " + category);		
		
//		System.out.println("\n-----Get list of questions-----");
//		List<Question> questions = (List<Question>) session.createQuery("from Question q").list();
//		for (Question resultQuestion : questions) {
//			System.out.println(resultQuestion);
//		}
	}
}
