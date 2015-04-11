package ua.com.goit.gojava2.vova.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Question;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDao dao;
	
	@Override
	public void saveQuestion(Question question) {
		dao.saveQuestion(question);
	}

	@Override
	public void deleteQuestionById(int id) {
		dao.deleteQuestionById(id);
	}

	@Override
	public List<Question> findAllQuestions(int id) {
		return dao.findAllQuestions(id);
	}

	@Override
	public Question getQuestion(int id) {
		return dao.getQuestion(id);
	}

}
