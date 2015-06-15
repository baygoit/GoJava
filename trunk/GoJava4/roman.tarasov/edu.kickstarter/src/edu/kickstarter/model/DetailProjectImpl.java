package edu.kickstarter.model;

import java.sql.SQLException;
import java.util.List;

import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;
import edu.kickstarter.entity.ProjectComment;

public class DetailProjectImpl implements Model {
	private Integer projectID;

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		Project project = null;
		List<ProjectComment> comments = null;
		if (name.equals("detailedProject")) {
			try {
				Dao.getInstance();
				project = Dao.getProjectService().getProjectById(projectID);
			} catch (SQLException e) {
				project = null;
				throw new KickstarterException(" project info not found", e);
			}
			return project;
		}
		if (name.equals("comments")) {
			Dao.getInstance();
			comments = Dao.getCommentService()
					.getCommentsByProjectID(projectID);
		}
		return comments;
	}

	@Override
	public void setParameters(Object parameter) {
		projectID = (Integer) parameter;
	}

}
