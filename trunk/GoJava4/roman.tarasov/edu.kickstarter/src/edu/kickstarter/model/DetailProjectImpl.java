package edu.kickstarter.model;

import java.sql.SQLException;
import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;

public class DetailProjectImpl implements Model {

	private Integer projectID;

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		Project project = null;
		if (name.equals("detailedProject")) {
			try {
				project = Dao.getProjectService().getProjectById(projectID);
			} catch (SQLException e) {
				project = null;
				throw new KickstarterException(" DetailedProject exception", e);
			}
		}
		return project;
	}

	@Override
	public void setParameters(Object parameter) {
		projectID = (Integer) parameter;
	}

}
