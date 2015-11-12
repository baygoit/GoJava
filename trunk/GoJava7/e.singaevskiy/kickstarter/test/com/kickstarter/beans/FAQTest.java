package com.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FAQTest {
	
	FAQ testObject = new FAQ("testQ", "testA");

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
