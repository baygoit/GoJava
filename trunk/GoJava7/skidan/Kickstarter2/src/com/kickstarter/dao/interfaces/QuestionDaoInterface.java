package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

public interface QuestionDaoInterface {

	public List<Question> getProjectQuestions(Project p);
	
	public void add(String newQuestion,Project p);
}
