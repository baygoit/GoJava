package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public interface QuestionDao extends Dao{
	List<Question> getQuestions(Long projectId);
	
	void addQuestion(Question question);

}
