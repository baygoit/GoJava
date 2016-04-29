package com.anmertrix.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Project> getProjectsByCategoryId(long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Project p where p.category.id=:categoryId");
		query.setParameter("categoryId", categoryId);
		List<Project> projects = query.list();
		projects.forEach(b -> b.setGatheredBudget(b.getPayments().stream().mapToLong(a -> a.getAmount()).sum()));
		return projects;
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean projectExists(long projectId){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		criteria.setProjection(Projections.rowCount());
		long count = (long) criteria.uniqueResult();
		return count > 0;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Project getProjectById(long projectId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.get(Project.class, projectId);
		List<Payment> payments = project.getPayments();
		long sum = payments.stream().mapToLong(b -> b.getAmount()).sum();
		project.setGatheredBudget(sum);
		return project;
	}
	
}
