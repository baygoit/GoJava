package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.domain.Project;
import ua.nenya.domain.Question;
import ua.nenya.util.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(locations="classpath*:/aplicationContextTest.xml"),
	  @ContextConfiguration(locations="classpath*:/QuestionTest.hbm.xml")
	})
public class QuestionDaoImplTest {

	private static EmbeddedDatabase db;
	private QuestionDaoImpl questionDaoImpl = new QuestionDaoImpl();

	private static List<Question> questions = new ArrayList<>();
	private static Question question3;

	@BeforeClass
	public static void setUp() {
		initQuestions();

		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
.addScript("/insertProject.sql")
	    		.addScript("/insertQuestion.sql")
	    		.build();
	}


	@AfterClass
	public static void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deleteQuestion.sql")
				.addScript("/deleteProject.sql")
	    		.build();
	}

	@Test
	public void testGetQuestions() {

		Collections.sort(questions, new Comparator<Question>() {
			@Override
			public int compare(Question o1, Question o2) {
				return o1.getId()-o2.getId();
			}
		});
		
		List<Question> testQuestions = questionDaoImpl.getQuestions(12);
		assertNotNull(testQuestions);
		assertThat(testQuestions, is(questions));

	}

	@Test
	public void testGetQuestionsByProjectName() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Project project = new Project();
		String name = "projectName";
		project.setName(name);
		project.setDescription("description");
		project.setNeededAmount(123);
		project.setDaysRemain(12);

		session.save(project);
		session.flush();

		Question question = new Question();
		question.setProject(project);
		question.setName("question");

		session.save(question);
		session.flush();

		List<Question> testQuestions = questionDaoImpl.getByProjectName(name);
		assertThat(testQuestions.isEmpty(), is(false));
	}

	@Test
	public void testWriteQuestionInProject() throws SQLException {

		int id = questionDaoImpl.writeQuestionInProject(12, "Wow!?");
		assertThat(id, is(4));
	}
	
	@Test
	public void testIsQuestionAbsentNo() {
		boolean testQuestion = questionDaoImpl.isQuestionAbsent(22, "What?");
		assertThat(testQuestion, is(false));
	}
	
	@Test
	public void testIsQuestionAbsentYes() {
		boolean testQuestion = questionDaoImpl.isQuestionAbsent(22, "Why?");
		assertThat(testQuestion, is(true));
	}
	
	private static void initQuestions() {
		Question question1 = new Question();
		question1.setId(1);
		question1.setName("Why?");
		// question1.setProjectId(12);
		
		Question question2 = new Question();
		question2.setId(2);
		question2.setName("Who?");
		// question2.setProjectId(12);
		
		question3 = new Question();
		question3.setId(3);
		question3.setName("What?");
		// question3.setProjectId(22);
		questions.add(question1);
		questions.add(question2);
	}
}
