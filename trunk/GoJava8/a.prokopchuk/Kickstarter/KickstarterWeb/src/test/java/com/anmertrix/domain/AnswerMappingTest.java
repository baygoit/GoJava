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
public class AnswerMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Answer answer;
	private Question question;

	@Before
	public void setUp() {
		Answer answer1 = new Answer();
		answer1.setAnswer("Answer1");
		
		Answer answer2 = new Answer();
		answer2.setAnswer("Answer2");
		question = new Question();
		answer2.setQuestion(question);
		
		em.merge(answer1);
		answer = em.merge(answer2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Answer").executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Answer> answers = em.createQuery("FROM Answer").getResultList();
		assertThat(answers.get(0).getAnswer(), is("Answer1"));
		assertThat(answers.get(0).getId(), is(1L));
		assertThat(answers.get(1).getAnswer(), is("Answer2"));
		assertThat(answers.get(1).getId(), is(2L));

		Answer answerTest = em.find(Answer.class, answer.getId());
		assertThat(answerTest.getAnswer(), is("Answer2"));
		assertThat(answerTest.getId(), is(2L));
		assertThat(answerTest.getQuestion(), is(question));
		answerTest.setId(5L);
		assertThat(answerTest.getId(), is(5L));
	}
	
}
