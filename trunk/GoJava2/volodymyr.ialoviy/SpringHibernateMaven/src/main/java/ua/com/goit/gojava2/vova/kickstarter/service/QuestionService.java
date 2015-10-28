package ua.com.goit.gojava2.vova.kickstarter.service;

import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.model.Question;

public interface QuestionService {

	List<Question> findAllQuestions(int id);

	void saveQuestion(Question question);

	void deleteQuestionById(int id);

	Question getQuestion(int id);

	void addAnswer(String answer, int id);
}
