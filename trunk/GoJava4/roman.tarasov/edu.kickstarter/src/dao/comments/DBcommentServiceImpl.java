package dao.comments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.Dao;
import database.KickstarterException;

public class DBcommentServiceImpl implements CommentService {

	@Override
	public List<ProjectComment> getCommentsByProjectID(int projectID)
			throws KickstarterException {
		List<ProjectComment> commentsOfProject = new ArrayList<ProjectComment>();
		Dao.getInstance();
		Statement statement;
		try {
			statement = Dao.getDatabaseService().getConnection()
					.createStatement();
			StringBuffer sql = new StringBuffer();

			sql.append("SELECT * FROM comments WHERE id_project=");
			sql.append(Integer.toString(projectID));
			ResultSet rs = statement.executeQuery(sql.toString());
			rs = statement.getResultSet();
			while (rs.next()) {
				ProjectComment newComment = new ProjectComment();
				newComment.setComment(rs.getString("comment"));
				newComment.setProjectID(projectID);
				newComment.setUserID(rs.getInt("id_user"));
				newComment.setCommentID(rs.getInt("id_comment"));
				commentsOfProject.add(newComment);
			}

		} catch (SQLException e) {
			commentsOfProject = null;
		} finally {
			try {
				Dao.getDatabaseService().closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (commentsOfProject == null) {
				throw new KickstarterException("comments not found");
			}
		}

		return commentsOfProject;
	}

	@Override
	public Map<Integer, ArrayList<ProjectComment>> getAll() {
		return null;
	}
}
