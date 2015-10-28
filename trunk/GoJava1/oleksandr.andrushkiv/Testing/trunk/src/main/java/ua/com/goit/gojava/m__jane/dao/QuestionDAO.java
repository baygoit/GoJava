package ua.com.goit.gojava.m__jane.dao;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;

public interface QuestionDAO {

	void saveSimpleQuestion(SimpleQuestion question);

	List<Question> getQuestionList();

	void deleteQuestion(Integer id);

	SimpleQuestion getSimpleQuestion(Integer id);

	void updateSimpleQuestion(SimpleQuestion question);

}
