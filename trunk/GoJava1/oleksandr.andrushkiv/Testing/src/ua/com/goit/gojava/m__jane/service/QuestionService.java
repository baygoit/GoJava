package ua.com.goit.gojava.m__jane.service;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.Question;

public interface QuestionService {

	
	public List<Question> getAllQuestions();

    public int getCount();

    public Question getQuestionByNumber(String number);
}
