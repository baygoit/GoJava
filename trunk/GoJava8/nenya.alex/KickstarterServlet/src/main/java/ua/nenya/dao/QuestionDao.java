package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Question;

public interface QuestionDao {
	
	List<Question> getQuestions(String projectName);
	void writeQuestionInProject(String projectName, String question);

}
