package ua.com.goit.gojava.m__jane.dao;

import java.util.List;
import ua.com.goit.gojava.m__jane.model.Question;



public interface QuestionDao {
	
	public List<Question> getQuestionList();

	public List<Question> getQuestionList(int profileId);
	
}
