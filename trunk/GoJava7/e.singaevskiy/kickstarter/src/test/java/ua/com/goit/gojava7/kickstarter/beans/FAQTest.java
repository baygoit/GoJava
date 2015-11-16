package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.QnA;

public class FAQTest {
	
	QnA testObject = new QnA("testQ", "testA");

	@Test
	public void testFAQ() {
		assertThat(testObject.getQuestion(), is("testQ"));
		assertThat(testObject.getAnswer(), is("testA"));
	}

	@Test
	public void testSetQuestion() {
		String question = "New Question";
		testObject.setQuestion(question);
		assertThat(testObject.getQuestion(), is(question));
	}

	@Test
	public void testSetAnswer() {
		String answer = "New Answer";
		testObject.setAnswer(answer);
		assertThat(testObject.getAnswer(), is(answer));
	}

	@Test
	public void testToString() {
		assertThat(testObject.toString(), not(""));
	}

}
