package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Question;

public interface QuestionDao {

	List<Question> getQuestionsByProjectId(int projectId);
	
	void insertQuestion(Question question);

}
