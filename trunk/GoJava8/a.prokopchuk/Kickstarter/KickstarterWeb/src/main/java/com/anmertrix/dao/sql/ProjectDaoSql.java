package com.anmertrix.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Project> getProjectsByCategoryId(long categoryId) {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("from Project p where p.category.id=:categoryId");
			query.setParameter("categoryId", categoryId);
			return (List<Project>) query.list();
		}
	}
	
	@Override
	public boolean projectExists(long projectId){
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
		Project project = null;
		try (Session session = sessionFactory.openSession()) {
			project = session.get(Project.class, projectId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return project;
	}

}
