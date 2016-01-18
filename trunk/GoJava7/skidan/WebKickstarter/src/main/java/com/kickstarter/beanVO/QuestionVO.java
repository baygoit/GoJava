package com.kickstarter.beanVO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionVO {

	@Size(min = 3)
	@NotNull
	private String question;

	public QuestionVO() {

	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
