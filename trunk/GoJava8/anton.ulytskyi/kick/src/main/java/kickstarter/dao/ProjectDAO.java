package kickstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import kickstarter.domain.Project;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO  {

	@PersistenceContext
    protected EntityManager emf;
	

	@SuppressWarnings("unchecked")
	public List<Project> findProjectsOfCategory(String category) {
		return emf.createQuery("from projects where category = '"+category+"'").getResultList();
	}
	public Project openProject(int id) {
		Query query = emf.createQuery("from projects where id = '"+id+"'");
		return (Project) query.getSingleResult();
	}

}

