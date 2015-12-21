package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Question;

public interface QuestionDaoInterface {

	public List<Question> getProjectQuestions(String pojectTitle);
	
	public void add(String newQuestion, String pojectTitle);
}
