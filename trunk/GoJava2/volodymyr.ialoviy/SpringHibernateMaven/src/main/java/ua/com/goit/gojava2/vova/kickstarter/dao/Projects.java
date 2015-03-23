package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Project;

@Repository("projectDao")
public class Projects extends AbstractDao implements ProjectDao{

	@Override
	public void saveProject(Project project) {
		persist(project);		
	}
	
	@Override
	public List<Project> findAllProjects(Integer idCategory) {
		Query query = getSession().createQuery("from Project where idCategory = :idCategory");
		query.setInteger("idCategory", idCategory);
		List<Project> rezult = (List<Project>) query.list();
		return rezult;
	}

	@Override
	public void deleteProjectById(Integer idProject) {
		Query query = getSession().createSQLQuery("delete from Projects where idProject = :idProject");
		query.setInteger("idProject", idProject);
		query.executeUpdate();
	}

}
