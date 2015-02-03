package ua.com.goit.gojava.m__jane.service;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.question.Question;

public interface QuestionService {
	
	public List<Question> getQuestionList(List<Category> questionCategoryList);
}
