package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

public interface ProjectDao {
	
	List<Project> getProjectsByCategoryId(int category_id);

	Project getProjectById(int project_id);
	
	List<Question> getQuestionByProjectId(int project_id);
	
	List<Answer> getAnswerByQuestionId(int question_id);

	void insertQuestion(Question question);

	List<Payment> getPaymentsByProjectId(int project_id);

	void insertPayment(Payment payment);

}
