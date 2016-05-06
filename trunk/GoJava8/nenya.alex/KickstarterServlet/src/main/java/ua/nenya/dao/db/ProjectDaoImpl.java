package ua.nenya.dao.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;

@Transactional(readOnly = true)
@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsByCategoryId(Long categoryId) {
		Query query = em.createNamedQuery("Project.getByCategoryId");
		query.setParameter("categoryId", categoryId);
		List<Project> projects = query.getResultList();
		
		List<Project> resultProjects = new ArrayList<>();
		for(Project it: projects){
			long sum = getPaymentSum(it.getId());
			it.setAvailableAmount(sum);
			resultProjects.add(it);
		}
		return resultProjects;
	}

	@Override
	public Project getProjectByProjectId(Long projectId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		Root<Project> root = criteriaQuery.from(Project.class);
		criteriaQuery.select(root);
		Predicate criteria = criteriaBuilder.equal(root.get("id"), projectId);
		criteriaQuery.where(criteria);
		TypedQuery<Project> typedQuery = em.createQuery(criteriaQuery);
		Project project = typedQuery.getSingleResult();
		project.setAvailableAmount(getPaymentSum(projectId));
		return project;
	}

	@Override
	public boolean isProjectExist(Long projectId) {
		Query query = em.createNamedQuery("Project.Count");
		query.setParameter("projectId", projectId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	private long getPaymentSum(Long projectId){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Payment> payment = criteriaQuery.from(Payment.class);
		criteriaQuery.multiselect(criteriaBuilder.sum(payment.<Long>get("amount")));
		Predicate criteria = criteriaBuilder.equal(payment.get("project").get("id"), projectId);
		criteriaQuery.where(criteria);
		return em.createQuery(criteriaQuery).getSingleResult();
	}

}
