package ua.com.goit.gojava.m__jane.service;

import java.util.List;



import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.model.question.Question;

public interface QuestionService {

	public List<Question> getQuestionList(List<QuestionCategory> questionCategoryList);
}
