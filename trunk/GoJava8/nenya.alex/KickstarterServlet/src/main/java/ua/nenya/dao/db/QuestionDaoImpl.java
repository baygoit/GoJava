package ua.nenya.dao.db;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private static final String GET_QUESTIONS_BY_PROJECT_ID = "FROM Question q WHERE q.project.id=:projectId ORDER BY q.id";
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_QUESTIONS_BY_PROJECT_ID);
		query.setParameter("projectId", projectId);
		return query.list();
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public int writeQuestionInProject(Question question) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(question);
		return id;
	}

}
