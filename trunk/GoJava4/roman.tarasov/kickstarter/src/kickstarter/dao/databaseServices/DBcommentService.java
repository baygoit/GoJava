package kickstarter.dao.databaseServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iCommentService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.ProjectComment;

public class DBcommentService implements iCommentService {
	private iDatabaseService dbService;
	private int projectID;
	private HashMap<Integer, ArrayList<ProjectComment>> allComments;

	public DBcommentService(iDatabaseService dbService) {
		this.dbService = dbService;
		allComments = new HashMap<Integer, ArrayList<ProjectComment>>();
	}

	@Override
	public void addComment(ProjectComment newComment) {
		projectID = newComment.getProjectID();

		ArrayList<ProjectComment> listFromAllComments = allComments
				.get(projectID);
		if (listFromAllComments != null) {
			listFromAllComments.add(newComment);
			return;
		}
		ArrayList<ProjectComment> newList = new ArrayList<ProjectComment>();
		newList.add(newComment);
		allComments.put(projectID, newList);
	}

	@Override
	public List<ProjectComment> getCommentsByProjectID(int projectID)
			throws SQLException {
		List<ProjectComment> commentsOfProject = new ArrayList<ProjectComment>();
		Statement statement = dbService.getConnection().createStatement();
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
		return commentsOfProject;
	}

	@Override
	public void deleteComment(int projectID, int commentID)
			throws ServiceException, SQLException {
		Statement statement = dbService.getConnection().createStatement();
		StringBuffer sql = new StringBuffer();

		sql.append("DELETE ");
		sql.append("FROM ");
		sql.append("comments ");
		sql.append("WHERE ");
		sql.append("id_project=");
		sql.append(Integer.toString(projectID));
		sql.append(" AND ");
		sql.append("id_comment=");
		sql.append(Integer.toString(commentID));
		statement.executeUpdate(sql.toString());
	}

	@Override
	public Map<Integer, ArrayList<ProjectComment>> getAll() {
		return null;
	}

	@Override
	public void createComments(iDAO sourceDAO) throws SQLException {
		Map<Integer, ArrayList<ProjectComment>> comments = sourceDAO
				.getCommentService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  comments ");
		StringBuffer sql = new StringBuffer();

		sql.append("CREATE TABLE comments ");
		sql.append("(");
		sql.append("id_comment SERIAL not null PRIMARY KEY, ");
		sql.append("id_project integer, ");
		sql.append("id_user integer, ");
		sql.append("comment varchar(255)");
		sql.append(")");

		statement.executeUpdate(sql.toString());

		for (Integer key : comments.keySet()) {
			List<ProjectComment> value = comments.get(key);
			for (ProjectComment comment : value) {
				PreparedStatement ps = dbService
						.getConnection()
						.prepareStatement(
								"INSERT INTO comments (id_project, id_user, comment) values(?,?,?)");
				ps.setInt(1, comment.getProjectID());
				ps.setInt(2, comment.getUserID());
				ps.setString(3, comment.getComment());
				ps.executeUpdate();
			}
		}
	}
}
