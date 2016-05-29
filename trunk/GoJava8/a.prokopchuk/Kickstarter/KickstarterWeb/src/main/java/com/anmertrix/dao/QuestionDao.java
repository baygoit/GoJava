package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Question;

public interface QuestionDao {

	void insertQuestion(Question question);

	List<Question> getQuestions(long projectId);

}
