package edu.kickstarter.model;

import java.util.List;
import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;

public class ProjectsImpl implements Model {
	private int categoryID;

	public ProjectsImpl() {
		Dao.getInstance();
	}

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		List<Project> sortedProjects = null;
		if (name.equals("sortedProjects")) {
			Dao.getInstance();
			sortedProjects = Dao.getProjectService().sortProjectsByCategoryID(
					categoryID);
		}
		return sortedProjects;
	}

	@Override
	public void setParameters(Object parameter) {
		categoryID = (Integer) parameter;
	}
}
