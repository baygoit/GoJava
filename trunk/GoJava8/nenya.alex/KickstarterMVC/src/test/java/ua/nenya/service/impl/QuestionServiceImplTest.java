package ua.nenya.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;
import ua.nenya.service.QuestionService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class QuestionServiceImplTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionDao questionDao;

	private Question question = new Question();
	private Project pro;

	@Before
	public void setUp() {
		initQuestions();
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Question").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
	}
	
	@Test
	public void testIsQuestionExistTrue(){
		questionDao.writeQuestionInProject(question);
		assertThat(questionService.isQuestionExist(question), is(true));
	}
	
	@Test
	public void testIsQuestionExistFalse(){
		assertThat(questionService.isQuestionExist(question), is(false));
	}
	
	private void initQuestions() {
		Project project = new Project();
		project.setName("project");
		pro = em.merge(project);
		
		question.setName("Why?");
		question.setProject(pro);
	}
}
