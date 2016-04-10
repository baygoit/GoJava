package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnswerTest {
	
	Answer answer = new Answer();
	
	@Test
	public void setGetIdTest() {
		answer.setId(4);
		assertThat(answer.getId(), is(4));
	}
	
	@Test
	public void setGetAnswerTest() {
		answer.setAnswer("testAnswer");
		assertThat(answer.getAnswer(), is("testAnswer"));
	}
	
	@Test
	public void setGetQuestionIdTest() {
		answer.setQuestionId(2);
		assertThat(answer.getQuestionId(), is(2));
	}

}
