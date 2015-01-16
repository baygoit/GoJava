package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;

import ua.com.goit.gojava.m__jane.dao.QuestionDao;
import ua.com.goit.gojava.m__jane.dao.impl.QuestionDaoImpl;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao;		
	
	public QuestionServiceImpl() {
		questionDao = new QuestionDaoImpl();
	}

	@Override
	public List<Question> getAllQuestions() {		
		return questionDao.getAllQuestions();
	}

	@Override
	public int getCount() {		
		return questionDao.getAllQuestions().size();
	}

	@Override
	public Question getQuestionByNumber(String number) {
		Question foundQuestion = null;
		//TODO replaced by map
		List<Question> listQuestions = questionDao.getAllQuestions();
		for (Question question : listQuestions) {
			if(question.getNumber().equals(number)) {
				foundQuestion = question;
				break;
			}
		}
		return foundQuestion;
	}

}
