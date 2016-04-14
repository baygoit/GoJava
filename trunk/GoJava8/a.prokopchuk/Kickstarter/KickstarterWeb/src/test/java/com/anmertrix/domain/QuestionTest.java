package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuestionTest {
	
	private Question question = new Question();
	
	@Test
	public void setGetIdTest() {
		question.setId(22);
		assertThat(question.getId(), is(22));
	}
	
	@Test
	public void setGetProjectIdTest() {
		question.setProjectId(2);
		assertThat(question.getProjectId(), is(2));
	}
	
	@Test
	public void setGetQuestionTest() {
		question.setQuestion("test2");
		assertThat(question.getQuestion(), is("test2"));
	}

}
