package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Project> getProjectsByCategoryId(long categoryId) {
		List<Project> projects = em.createNamedQuery("Project.getProjects", Project.class)
				.setParameter("categoryId", categoryId).getResultList();
		projects.forEach(b -> b.setGatheredBudget(paymentDao.getGatheredBudgetByProjectId(b.getId())));
		return projects;
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean projectExists(long projectId){
		return em.createNamedQuery("Project.count", Long.class).getSingleResult() > 0;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Project getProjectById(long projectId) {
		Project project = em.find(Project.class, projectId);
		project.setGatheredBudget(paymentDao.getGatheredBudgetByProjectId(project.getId()));
		return project;
	}
	
}
