package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

public abstract class QuestionDaoType {

	protected QuestionDaoInterface questionDaoInterface;

	public QuestionDaoType() {

	}

	public List<Question> getProjectQuestions(Project p) {

		return questionDaoInterface.getProjectQuestions(p);
	}

	public void add(String newQuestion, Project p) {
		questionDaoInterface.add(newQuestion, p);

	}
	public void setType(QuestionDaoInterface questionDaoInterface) {
		this.questionDaoInterface = questionDaoInterface;
	}
}
