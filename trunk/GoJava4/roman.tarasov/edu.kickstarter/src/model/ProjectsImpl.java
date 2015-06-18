package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;
import dao.project.ProjectService;

public class ProjectsImpl implements Model {
	private int categoryID;

	@Override
	public Object getAttribute(String name) throws KickstarterException {

		if (name.equals("sortedProjects")) {
			List<Project> sortedProjects = null;
			ProjectService projectService = null;
			if (connected()) {
				projectService = new DBprojectServiceImpl();
			} else {
				projectService = new DefaultProjectServiceImpl();
			}
			sortedProjects = projectService
					.sortProjectsByCategoryID(categoryID);
			return sortedProjects;
		}
		return null;
	}

	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {
		}
		return connected;
	}

	@Override
	public void setParameters(Object parameter) {
		categoryID = (Integer) parameter;
	}
}
