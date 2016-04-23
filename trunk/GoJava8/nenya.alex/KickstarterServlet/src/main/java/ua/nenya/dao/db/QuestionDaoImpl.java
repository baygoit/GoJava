package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;
import ua.nenya.util.HibernateUtil;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(int projectId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Question> questions = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Question.class);
			criteria.add(Restrictions.eq("projectId", projectId));
			criteria.addOrder(Order.asc("id"));
			questions = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public int writeQuestionInProject(int projectId, String stringQuestion) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		Question question = new Question();
		// question.setProjectId(projectId);
		question.setName(stringQuestion);

		int id = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			id = (int) session.save(question);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return id;
	}

	public List<Question> getByProjectName(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Question> questions = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Question q where q.project.name=:projectName");
			query.setParameter("projectName", name);
			questions = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception te) {
					te.printStackTrace();
				}
			}
			throw e;
		}
		return questions;
	}

	public boolean isQuestionAbsent(int projectId, String question) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		long count = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Question.class);
			criteria.add(Restrictions.eq("projectId", projectId));
			criteria.add(Restrictions.eq("name", question));
			count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return count == 0;
	}

}
