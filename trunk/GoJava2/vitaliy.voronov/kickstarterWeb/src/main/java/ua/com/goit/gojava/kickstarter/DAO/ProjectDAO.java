package ua.com.goit.gojava.kickstarter.DAO;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Model.Category;
import ua.com.goit.gojava.kickstarter.Model.Project;
import ua.com.goit.gojava.kickstarter.Model.Projects;

@Component
public class ProjectDAO extends AbstractDAO implements Projects {

	@Override
	public List<Project> getProjects(Category category) {
		Query query = getSession().createQuery("FROM Project p WHERE p.category_id = :categoryId");
		query.setParameter("categoryId", category.getId());
		List<Project> list = (List<Project>) query.list();
		return list;
	}

	@Override
	public Project getProject(int id) {
		Project project = (Project) getSession().get(Project.class, id);
		return project;
	}

	@Override
	public void addProject(Project project) {

	}
}
