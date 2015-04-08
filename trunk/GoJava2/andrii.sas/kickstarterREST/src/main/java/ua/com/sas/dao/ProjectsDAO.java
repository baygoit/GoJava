package ua.com.sas.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.sas.model.Project;

@Repository
public class ProjectsDAO extends AbstractDAO implements Projects{

	@Override
	public void add(Project project) {
		Session session = getSession();
        session.save(project);
	}

	@Override
	public Project get(int id) {
		Session session = getSession();
	    return (Project) session.get(Project.class, id);
	}

}
