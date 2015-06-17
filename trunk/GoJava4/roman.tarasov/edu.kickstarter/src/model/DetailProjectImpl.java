package model;

import java.sql.Connection;
import java.util.List;

import dao.comments.CommentService;
import dao.comments.DBcommentServiceImpl;
import dao.comments.DefaultCommentServiceImpl;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;
import dao.project.ProjectService;

public class DetailProjectImpl implements Model {
	private Integer projectID;

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		if (name.equals("detailedProject")) {
			Project project = null;
			ProjectService ps = null;
			
			try {
				Connection conn = Pool.getInstance().getConnection();
				ps = new DBprojectServiceImpl(conn);
			} catch (KickstarterException e1) {
				ps = new DefaultProjectServiceImpl();
			}
			project = ps.getProjectById(projectID);
			return project;

		}
		if (name.equals("comments")) {
			List<ProjectComment> comments = null;
			CommentService cs=null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				cs = new DBcommentServiceImpl(conn);
			} catch (KickstarterException e1) {
				cs = new DefaultCommentServiceImpl();
			}
			comments = cs.getCommentsByProjectID(projectID);
			return comments;
		}
		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		projectID = (Integer) parameter;
	}

}
