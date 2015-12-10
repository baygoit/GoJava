package com.kickstarter.dao.interfaces;

import java.util.List;


import com.kickstarter.model.Question;

public abstract class QuestionDaoType {

	protected QuestionDaoInterface questionDaoInterface;

	public QuestionDaoType() {

	}

	public List<Question> getProjectQuestions( String pojectTitle) {
		return questionDaoInterface.getProjectQuestions(pojectTitle);
	}

	public void add(String newQuestion, String pojectTitle) {
		questionDaoInterface.add(newQuestion, pojectTitle);

	}

	public void setType(QuestionDaoInterface questionDaoInterface) {
		this.questionDaoInterface = questionDaoInterface;
	}
}
