package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

public interface QuestionDao {

	public List<Question> getProjectQuestions(int pojectId);
	
	public void add(String newQuestion, Project project);
}
