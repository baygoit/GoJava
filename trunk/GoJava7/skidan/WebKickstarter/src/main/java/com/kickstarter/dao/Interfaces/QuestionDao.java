package com.kickstarter.dao.Interfaces;

import java.util.List;
import com.kickstarter.model.Question;

public interface QuestionDao {

	public List<Question> getProjectQuestions(int pojectId);
	
	public void add(String newQuestion, int projectId);
}
