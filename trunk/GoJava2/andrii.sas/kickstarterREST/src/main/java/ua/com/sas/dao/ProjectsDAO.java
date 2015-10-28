package ua.com.sas.dao;

import org.springframework.stereotype.Repository;

import ua.com.sas.model.Project;

@Repository
public class ProjectsDAO extends AbstractDAO implements Projects{

	@Override
	public void add(Project project) {
		getSession().save(project);
	}

	@Override
	public Project get(int id) {
	    return (Project) getSession().get(Project.class, id);
	}

}
