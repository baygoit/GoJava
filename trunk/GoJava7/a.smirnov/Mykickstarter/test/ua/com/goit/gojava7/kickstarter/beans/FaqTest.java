package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;

public class FaqTest {

	private String question = "Who?";
	private Faq faq;
	
	@Before
	public void setUp() throws Exception {
		faq = new Faq(question);
	}

	@Test
	public void testFaq() {
		assertThat(faq.getQuestion(), is(question));
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
		assertEquals(faq.getAnswer(), null);
	}

	@Test
	public void testSetAnswer() {
		String myAnswer = "in Kiev!";
		faq.setAnswer(myAnswer);;
		assertThat(faq.getAnswer(), is(myAnswer));
	}

	@Test
	public void testGetProjectID() {
		assertThat(faq.getProjectID(), is(0));
	}

	@Test
	public void testSetProjectID() {
		int projectID = 1;
		faq.setProjectID(projectID);
		assertThat(faq.getProjectID(), is(1));
	}

}
