package ua.com.goit.gojava7.kickstarter.domain;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.models.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionTest extends Assert {

	Question question;

	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {
		question = new Question();
		question.setId(11);
		question.setTime("TestTime");
		question.setQuestion("TestQuestion");
		question.setAnswer("TestAnswer");
		question.setProjectId(44);
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(question.getId(), is(11));
		assertThat(question.getTime(), is("TestTime"));
		assertThat(question.getQuestion(), is("TestQuestion"));
		assertThat(question.getAnswer(), is("TestAnswer"));
		assertThat(question.getProjectId(), is(44));
	}
	
	@Test
	public void testToString() {
		System.out.println(question.toString());
		verify(printSteam).println("Time: TestTime; Question: TestQuestion; Answer: TestAnswer; Project: TestProject");
	}

}
