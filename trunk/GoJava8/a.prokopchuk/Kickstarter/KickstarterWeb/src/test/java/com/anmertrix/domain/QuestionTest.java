package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void setGetAnswersTest() {
		Answer answer = new Answer();
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(answer);
		question.setAnswers(answers);
		assertThat(question.getAnswers(), is(answers));
		assertThat(question.getAnswers().get(0), is(answer));
	}

}
