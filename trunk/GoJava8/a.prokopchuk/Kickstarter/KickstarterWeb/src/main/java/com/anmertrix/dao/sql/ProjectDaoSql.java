package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Project> getProjectsByCategoryId(long categoryId) {
		Query query = em.createQuery("from Project p where p.category.id=:categoryId");
		query.setParameter("categoryId", categoryId);
		List<Project> projects = query.getResultList();
		projects.forEach(b -> b.setGatheredBudget(b.getPayments().stream().mapToLong(a -> a.getAmount()).sum()));
		return projects;
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean projectExists(long projectId){
		return em.find(Project.class, projectId) != null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Project getProjectById(long projectId) {
		Project project = em.find(Project.class, projectId);
		for (Question question : project.getQuestions()) {
			question.getAnswers().size();
		}
		project.getRewards().size();
		List<Payment> payments = project.getPayments();
		long sum = payments.stream().mapToLong(b -> b.getAmount()).sum();
		project.setGatheredBudget(sum);
		return project;
	}
	
}
