package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class QuestionTest {

	String time = new Date().toString();

		@Test
	public void testNotNullAnswer() {
		Question question = new Question("Question");
		assertNotNull(question.getAnswer());
		question.setAnswer("Answer");
		question.setTime("Time");
	}
	
	@Test
	public void testCreateQuestionWithOneParameter() {
		Question question = new Question("Test Question with One");	
		assertNotNull(question.getTime());
		assertThat(question.getQuestion(), is("Test Question with One"));
		assertThat(question.getAnswer(), is("There is no answer yet"));
	}
	
	
	@Test
	public void testCreateQuestionWithTwoParameters() {
		Question question = new Question(time, "Test Full Question");
		assertThat(question.getTime(), is(time));
		assertThat(question.getQuestion(), is("Test Full Question"));
		assertNotNull(question.getAnswer());
	}
	
	@Test
	public void testCreateQuestionWithThreeParameters() {
		Question question = new Question(time, "Test Full Question", "Test Full answer");
		assertThat(question.getQuestion(), is("Test Full Question"));
	}
}
