package model;

import java.sql.SQLException;
import java.util.List;

import dao.Dao;
import dao.comments.ProjectComment;
import dao.project.Project;
import database.KickstarterException;

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
