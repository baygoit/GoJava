package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:H2/H2ApplicationContext*.xml")
@Category(IntegrationTest.class)
@Transactional
public class QuestionMappingTest {
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testBasicUsage() {

		Question question1 = new Question();
		question1.setQuestionText("Question 1");

		Question question2 = new Question();
		question2.setQuestionText("Question 2");

		em.persist(question1);
		em.persist(question2);
		
		Question question = em.find(Question.class, question1.getId());
		
		assertThat(question.getQuestionText(), is(question1.getQuestionText()));
	}
}
