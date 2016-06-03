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
	public List<Project> getProjects(long categoryId) {
		List<Project> projects = em.createNamedQuery("Project.getProjects", Project.class)
				.setParameter("categoryId", categoryId).getResultList();
		projects.forEach(b -> b.setGatheredBudget(paymentDao.getGatheredBudget(b.getId())));
		return projects;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExists(long projectId){
		return em.createNamedQuery("Project.count", Long.class).setParameter("projectId", projectId).getSingleResult() > 0;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Project getProject(long projectId) {
		Project project = em.createNamedQuery("Project.getProject", Project.class)
				.setParameter("projectId", projectId).getSingleResult();
		project.setGatheredBudget(paymentDao.getGatheredBudget(projectId));
		return project;
	}
	
}
