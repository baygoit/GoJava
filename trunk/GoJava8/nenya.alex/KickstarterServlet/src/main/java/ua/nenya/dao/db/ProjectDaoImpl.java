package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;
import ua.nenya.util.HibernateUtil;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Project> projects = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Project.class);
			criteria.add(Restrictions.eq("categoryId", id));
			criteria.addOrder(Order.asc("name"));
			projects = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public Project getProject(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Project project = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			project = session.get(Project.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public boolean isProjectExist(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		long count = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Project.class);
			criteria.add(Restrictions.eq("id", id));
			count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return count == 1;
	}

	@Override
	public int getCategoryId(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Project project = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Project.class);
			criteria.add(Restrictions.eq("id", id));
			project = session.get(Project.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return project.getCategoryId();
	}
	

}
