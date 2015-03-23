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
	public List<Project> findAllProjects() {
		List<Project> result = (List<Project>) getSession().createQuery("from Project where id_category = :id_category").list();
		return result;
	}

	@Override
	public void deleteProjectById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Projects where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

}
