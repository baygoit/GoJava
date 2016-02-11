package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
@Transactional
public class ProjectDaoSqlImpl implements ProjectDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override	
	public List<Project> getProjects(Long categoryId) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		Root<Project> entityRoot = criteriaQuery.from(Project.class);
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(criteriaBuilder.equal(entityRoot.get("category") , categoryId));
		TypedQuery<Project> query = em.createQuery(criteriaQuery);

		return query.getResultList();		
	}

	@Override
	public Project getProject(Long projectId) {

		return em.find(Project.class, projectId);
	}

}
