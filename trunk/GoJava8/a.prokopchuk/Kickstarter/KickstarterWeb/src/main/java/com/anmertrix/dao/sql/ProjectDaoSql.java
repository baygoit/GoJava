package com.anmertrix.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;
import com.anmertrix.dao.sql.HibernateUtil;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsByCategoryId(long categoryId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Project> projects = null;
		try (Session session = sessionFactory.openSession()) {
			ThreadLocalSessionContext.bind(session);
			projects = (List<Project>) sessionFactory.getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("categoryId", categoryId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	@Override
	public boolean projectExists(long projectId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		int count = 0;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Project.class);
			criteria.add(Restrictions.eq("id", projectId));
			criteria.setProjection(Projections.rowCount());
			count = ((Number) criteria.uniqueResult()).intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return count > 0;
	}
	
	@Override
	public Project getProjectById(long projectId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Project project = null;
		try (Session session = sessionFactory.openSession()) {
			project = session.get(Project.class, projectId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return project;
	}

}
