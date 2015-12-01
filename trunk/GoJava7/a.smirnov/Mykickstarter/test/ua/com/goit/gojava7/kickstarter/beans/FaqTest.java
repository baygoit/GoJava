package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;

public class FaqTest {

	private String question = "Who?";
	private String answer = "I am";
	private int projectID = 1;
	private Faq faq = new Faq();
	
	@Before
	public void setUp() throws Exception {
		faq.setProjectID(projectID);
		faq.setQuestion(question);
		faq.setAnswer(answer);
	}

	@Test (expected = NullPointerException.class)
	public void testFaq() {
		Faq myFaq = new Faq();
		assertThat(myFaq.getQuestion().length(), is(0));
		assertThat(myFaq.getAnswer().length(), is(0));
		assertThat(myFaq.getProjectID(), is(0));
	}

	@Test
	public void testGetQuestion() {
		assertThat(faq.getQuestion(), is(question));
	}

	@Test
	public void testSetQuestion() {
		String myQuestion = "Where?";
		faq.setQuestion(myQuestion);
		assertThat(faq.getQuestion(), is(myQuestion));
	}

	@Test
	public void testGetAnswer() {
		assertThat(faq.getAnswer().contains(answer), is(true));
	}

	@Test
	public void testSetAnswer() {
		String myAnswer = "in Kiev!";
		faq.setAnswer(myAnswer);;
		assertThat(faq.getAnswer(), is(myAnswer));
	}

	@Test
	public void testGetProjectID() {
		assertThat(faq.getProjectID(), is(projectID));
	}

	@Test
	public void testSetProjectID() {
		int newProjectID = 2;
		faq.setProjectID(newProjectID);
		assertThat(faq.getProjectID(), is(newProjectID));
	}
}
