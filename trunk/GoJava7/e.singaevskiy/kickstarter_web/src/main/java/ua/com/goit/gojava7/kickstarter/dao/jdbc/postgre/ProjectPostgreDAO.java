package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
public class ProjectPostgreDAO implements ProjectDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void clear() {
		entityManager.createNamedQuery("Project.removeAll").executeUpdate();
	}

	@Override
	public Project get(Long index) {
		return entityManager.find(Project.class, index);
	}

	@Override
	@Transactional
	public void add(Project element) {
		entityManager.persist(element);
	}

	@Override
	@Transactional
	public void addAll(List<Project> elements) {
		elements.forEach(entityManager::persist);
	}

	@Override
	public List<Project> getAll() {
		return entityManager.createNamedQuery("Project.getAll", Project.class).getResultList();
	}

	@Override
	public List<Project> getByCategory(Long categoryId) {
		TypedQuery<Project> query = entityManager.createNamedQuery("Project.getByCategory", Project.class);
		query.setParameter("category_id", categoryId);
		return query.getResultList();
	}

}
