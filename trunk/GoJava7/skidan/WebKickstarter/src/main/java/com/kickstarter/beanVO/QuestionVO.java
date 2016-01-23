package com.kickstarter.beanVO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class QuestionVO {

	@Size(min = 5, max = 150)
    @NotEmpty
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
