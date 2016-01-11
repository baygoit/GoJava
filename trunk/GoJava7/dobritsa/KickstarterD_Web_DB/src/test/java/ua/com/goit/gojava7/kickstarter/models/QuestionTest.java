package ua.com.goit.gojava7.kickstarter.models;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.contains;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuestionTest extends Assert {

	Question question;
	Project project = new Project();

	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {
		question = new Question();
		question.setQuestionId(11L);
		question.setTime("TestTime");
		question.setQuestion("TestQuestion");
		question.setAnswer("TestAnswer");
		question.setProject(project);
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(question.getQuestionId(), is(11L));
		assertThat(question.getTime(), is("TestTime"));
		assertThat(question.getQuestion(), is("TestQuestion"));
		assertThat(question.getAnswer(), is("TestAnswer"));
		assertThat(question.getProject(), is(project));
	}
	
	@Test
	public void testToString() {
		Question question = new Question("NewQuestion", project);
		System.out.println(question.toString());
		verify(printSteam).println(contains("NewQuestion"));
	}
}
