package ua.com.goit.gojava.m__jane.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.dao.QuestionDao;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.source.InnerStorage;

public class QuestionDaoImpl implements QuestionDao {

	
	
	@Override
	public List<Question> getAllQuestions() {
		
		List<Question> listQuestions = new ArrayList<>();
		
		InnerStorage innerStorage = new InnerStorage();
		List<String> listString = innerStorage.getQuestions();
		for (int i = 0; i < listString.size(); i++) {
			listQuestions.add(new Question(String.valueOf(i+1), listString.get(i)));
		}
		
		return listQuestions;
	}

	
}
