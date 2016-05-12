package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class QuestionMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Question q;
	
	@Before
	public void setUp() {
		Question question = new Question();
		question.setName("What?");
		q = em.merge(question);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Question").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testQuestionUsage() {
		List<Question> questions = em.createQuery("select q from Question q").getResultList();
		assertThat(questions.get(0).getName(), is("What?"));

		Question questionTest = em.find(Question.class, q.getId());
		assertThat(questionTest.getName(), is("What?"));
		assertThat(questionTest.getId(), is(q.getId()));
	}
}
