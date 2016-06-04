package ua.nenya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@Transactional
@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Project> getProjectsByCategoryId(Long categoryId) {
		Query query = em.createNamedQuery("Project.getByCategoryId");
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Project getProjectByProjectId(Long projectId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		Root<Project> root = criteriaQuery.from(Project.class);
		criteriaQuery.select(root);
		Predicate criteria = criteriaBuilder.equal(root.get("id"), projectId);
		criteriaQuery.where(criteria);
		TypedQuery<Project> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reward> getRewardsByProjectId(Long projectId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Reward> criteriaQuery = criteriaBuilder.createQuery(Reward.class);
		Root<Reward> root = criteriaQuery.from(Reward.class);
		root.fetch("project", JoinType.INNER);
		criteriaQuery.select(root);
		Predicate criteria = criteriaBuilder.equal(root.get("project").get("id"), projectId);
		criteriaQuery.where(criteria);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		TypedQuery<Reward> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getResultList();		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Project> getProjects() {
		Query query = em.createNamedQuery("Project.getProjects");
		return query.getResultList();
	}

	@Override
	public Project deleteProjectByProjectId(Long projectId) {
		Project project = getProjectByProjectId(projectId);
		em.remove(project );
		return project;
	}

	@Override
	public Project saveProject(Project project) {
		return em.merge(project);
	}
	
	@Override
	@Transactional(readOnly = true)
	public long getPaymentSum(Long projectId) {
		long paymentSum;
		Query query = em.createNamedQuery("Payment.getAmount");
		query.setParameter("projectId", projectId);
		try {
			paymentSum = (long) query.getSingleResult();
		} catch (NoResultException e) {
			logger.info("Project with id = "+projectId+" is without payments!");
			logger.trace("Exception: ", e);
			return 0;
		}
		return paymentSum;
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean isProjectExistById(Long projectId) {
		Query query = em.createNamedQuery("Project.Count");
		query.setParameter("projectId", projectId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isProjectExistByName(String projectName) {
		Query query = em.createNamedQuery("Project.CountByName");
		query.setParameter("projectName", projectName);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
