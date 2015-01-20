package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;

import ua.com.goit.gojava.m__jane.dao.QuestionDao;
import ua.com.goit.gojava.m__jane.dao.impl.QuestionDaoImpl;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao;		
	
	public QuestionServiceImpl() {
		questionDao = new QuestionDaoImpl();
	}

	@Override
	public List<Question> getQuestionList() {		
		return questionDao.getQuestionList();
	}

	@Override
	public int getCount() {		
		return questionDao.getQuestionList().size();
	}

	@Override
	public Question getQuestionById(int id) {
		Question foundQuestion = null;
		//TODO replaced by map
		List<Question> listQuestions = questionDao.getQuestionList();
		for (Question question : listQuestions) {
			if(question.getId() == id) {
				foundQuestion = question;
				break;
			}
		}
		return foundQuestion;
	}

	@Override
	public List<Question> getQuestionListByProfile(Profile profile) {		
		return questionDao.getQuestionList(profile.getId());
	}

}
