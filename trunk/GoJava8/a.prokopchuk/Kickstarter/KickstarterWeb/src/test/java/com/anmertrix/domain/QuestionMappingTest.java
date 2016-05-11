package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class QuestionMappingTest {
	
	@PersistenceContext
	private EntityManager em;
	private Question q;

	@Before
	public void setUp() {
		Question question1 = new Question();
		question1.setQuestion("Question1");
		
		Question question2 = new Question();
		question2.setQuestion("Question2");
		em.merge(question1);
		q = em.merge(question2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Question").executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Question> questions = em.createQuery("FROM Question").getResultList();
		assertThat(questions.get(0).getQuestion(), is("Question1"));
		assertThat(questions.get(0).getId(), is(1L));
		assertThat(questions.get(1).getQuestion(), is("Question2"));
		assertThat(questions.get(1).getId(), is(2L));

		Question question = em.find(Question.class, q.getId());
		assertThat(question.getQuestion(), is("Question2"));
		assertThat(question.getId(), is(2L));
	}

}
