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
		question.setId(22L);
		assertThat(question.getId(), is(22L));
	}
	
	@Test
	public void setGetQuestionTest() {
		question.setQuestion("test2");
		assertThat(question.getQuestion(), is("test2"));
	}
	
	@Test
	public void setGetProjectTest() {
		Project project = new Project();
		question.setProject(project);
		assertThat(question.getProject(), is(project));
	}
	
	@Test
	public void setGetAnswersTest() {
		List<Answer> answers = new ArrayList<>();
		question.setAnswers(answers);
		assertThat(question.getAnswers(), is(answers));
	}

}
