package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class QuestionMappingTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testQuestionUsage() {
		int id;
		try (Session session = sessionFactory.openSession()) {
			Question question = new Question();
			question.setName("What?");

			id = (int) session.save(question);
			session.flush();
		}
		try (Session session = sessionFactory.openSession()) {
			List<Question> questions = session.createQuery("FROM Question").list();
			assertThat(questions.get(0).getName(), is("What?"));

			Question question = session.get(Question.class, id);
			assertThat(question.getName(), is("What?"));
		}
	}
}
