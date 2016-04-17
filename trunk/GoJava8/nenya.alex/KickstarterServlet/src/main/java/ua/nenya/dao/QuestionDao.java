package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Question;

public interface QuestionDao {
	
	List<Question> getQuestions(int proId);
	void writeQuestionInProject(int proId, String question);
	boolean isQuestionValid(int integer, String question);
}
