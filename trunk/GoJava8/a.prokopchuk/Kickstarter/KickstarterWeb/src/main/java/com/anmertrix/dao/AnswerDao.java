package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Answer;

public interface AnswerDao {
	
	List<Answer> getAnswersByProjectId(int projectId);

}
