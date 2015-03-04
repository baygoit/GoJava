package ua.com.goit.gojava.m__jane.service.implXML;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImplXML implements QuestionService {

	
	@Override
	public List<Question> getQuestionList(List<Category> categoryList) {
		// TODO add some logic for getting questions
		//now just all questions from categories
		//maybe there needs some additional object for the logic params(or quiz) 
		List<Question> questionList = new ArrayList<Question>();
		
		for (Category category : categoryList) {
			questionList.addAll(category.getQuestionList());
		}			
		return questionList;
	}

	@Override
	public List<Question> getQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveQuestion(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SimpleQuestion getQuestion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuestion(SimpleQuestion question) {
		// TODO Auto-generated method stub
		
	}
}
