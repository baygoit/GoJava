package edu.kickstarter.model;

import java.sql.SQLException;
import java.util.List;
import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;

public class ProjectsModelImpl implements Model {
	private int categoryID;

	public ProjectsModelImpl() {
		Dao.getInstance();
	}

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		List<Project> sortedProjects = null;
		if (name.equals("sortedProjects")) {

			try {
				Dao.getInstance();
				sortedProjects = Dao.getProjectService()
						.sortProjectsByCategoryID(categoryID);
			} catch (SQLException e) {
				sortedProjects = null;
			}
		}
		return sortedProjects;
	}

	@Override
	public void setParameters(Object parameter) {
		categoryID = (Integer) parameter;
	}
}
