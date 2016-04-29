package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnswerTest {
	
	Answer answer = new Answer();
	
	@Test
	public void setGetIdTest() {
		answer.setId(4L);
		assertThat(answer.getId(), is(4L));
	}
	
	@Test
	public void setGetAnswerTest() {
		answer.setAnswer("testAnswer");
		assertThat(answer.getAnswer(), is("testAnswer"));
	}
	
	@Test
	public void setGetQuestionTest() {
		Question question = new Question();
		answer.setQuestion(question);
		assertThat(answer.getQuestion(), is(question));
	}

}
