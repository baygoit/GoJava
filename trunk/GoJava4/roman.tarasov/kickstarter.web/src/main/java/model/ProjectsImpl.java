package model;

import java.util.List;
import dao.Dao;
import dao.project.Project;
import database.KickstarterException;


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
