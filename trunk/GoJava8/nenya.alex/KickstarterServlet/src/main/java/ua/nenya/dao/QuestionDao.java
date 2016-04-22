package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Question;

public interface QuestionDao {
	
	List<Question> getQuestions(int proId);
	int writeQuestionInProject(int proId, String question);
	boolean isQuestionAbsent(int integer, String question);
}
