package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class QuestionDaoImplTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private QuestionDao questionDao;

	private List<Question> questions = new ArrayList<>();
	private Question question = new Question();
	private Project pro;

	private Question q2;

	@Before
	public void setUp() {
		question.setName("Why?");
		initQuestions();
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Question").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
	}
	
	@Test
	public void testGetQuestions() {
		List<Question> testQuestions = questionDao.getQuestions(pro.getId());
		assertNotNull(testQuestions);
		assertThat(testQuestions.get(0).getName(), is(questions.get(0).getName()));
		assertThat(testQuestions.get(1).getName(), is(q2.getName()));
		assertThat(testQuestions.get(1).getId(), is(q2.getId()));
	}

	@Test
	public void testWriteQuestionInProject() throws SQLException {
		Question newQuestion = questionDao.writeQuestionInProject(question);
		Question questionTest = em.find(Question.class, newQuestion.getId());
		assertThat(questionTest.getName(), is(question.getName()));
	}
	
	private void initQuestions() {
		Project project = new Project();
		project.setName("project");
		pro = em.merge(project);
		
		Question question1 = new Question();
		question1.setName("Who?");
		question1.setProject(pro);
		em.merge(question1);
		
		Question question2 = new Question();
		question2.setName("What?");
		question2.setProject(pro);
		q2 = em.merge(question2);
		
		questions.add(question1);
		questions.add(question2);

	}
}
