package ua.com.goit.gojava7.kickstarter.database.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.database.contract.ProjectDao;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")	
	public List<Project> getProjectsFromCategory(int categoryId) {
		return entityManager.createNamedQuery("Project.findProjectsFromCategory").setParameter("id", categoryId).getResultList();
	}

	@Override
	public Project getProjectById(int projectId) {
		return (Project) entityManager.createNamedQuery("Project.findProject").setParameter("id", projectId).getSingleResult();
	}

	@Override
	@Transactional
	public void add(Project project) {
		entityManager.persist(project);
	}

	@Override
	@Transactional
	public void remove(Project project) {
		entityManager.remove(project);
	}
}
