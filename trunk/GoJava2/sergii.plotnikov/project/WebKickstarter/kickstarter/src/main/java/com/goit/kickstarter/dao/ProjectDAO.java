package com.goit.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;

@Component
public class ProjectDAO extends AbstractDAO {
	
	@Transactional
	public Project getProject(int id) {
		Project proj = (Project) getSession().get(Project.class, id);

		return proj;
	}

	@Transactional
	public List<Project> getProjects(Category category) {
		Query query = getSession().getNamedQuery("getProjects");
		query.setInteger("category", category.getId());
		return query.list();
	}

	@Transactional
	public void update(Project project) {
		getSession().update(project);
	}
}