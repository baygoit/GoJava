package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

public interface ProjectDao {
	
	List<Project> getProjectsByCategoryId(int index);

	Project getProjectById(int index);
	
	List<Question> getQuestionByProjectId(int index);
	
	List<Answer> getAnswerByQuestionId(int index);

	void insertQuestion(Question question);

}
