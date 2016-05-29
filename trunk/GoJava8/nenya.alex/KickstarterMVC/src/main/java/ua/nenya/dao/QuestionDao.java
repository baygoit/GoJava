package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Question;

public interface QuestionDao {
	List<Question> getQuestions(Long proId);
	void writeQuestionInProject(Question question);
	boolean isQuestionExist(Question question);
}
