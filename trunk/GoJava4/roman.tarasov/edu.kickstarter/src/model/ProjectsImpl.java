package model;

import java.sql.Connection;
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
			ProjectService ps = null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				ps = new DBprojectServiceImpl(conn);
			} catch (KickstarterException e1) {
				ps = new DefaultProjectServiceImpl();
			}
			sortedProjects = ps.sortProjectsByCategoryID(categoryID);
			return sortedProjects;
		}
		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		categoryID = (Integer) parameter;
	}
}
