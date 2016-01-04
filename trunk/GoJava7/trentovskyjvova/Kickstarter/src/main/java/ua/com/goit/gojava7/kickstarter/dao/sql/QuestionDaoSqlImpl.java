package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Repository
@Transactional
public class QuestionDaoSqlImpl implements QuestionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Question> getQuestions(int projectId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Question.class);	
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Question> questions = criteria.list();
		
		return questions;
	}

	@Override
	public void addQuestion(Question question) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(question);
		
	}

}
