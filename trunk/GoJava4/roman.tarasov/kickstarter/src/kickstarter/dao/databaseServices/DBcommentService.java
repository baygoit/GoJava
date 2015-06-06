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
	private static final int MAX_COMMENT_ID = 2000000000;
	private iDatabaseService dbService;
	private int projectID;
	private HashMap<Integer, ArrayList<ProjectComment>> allComments;

	public DBcommentService(iDatabaseService dbService) {
		this.dbService = dbService;
		allComments = new HashMap<Integer, ArrayList<ProjectComment>>();
	}

	@Override
	public void addComment(ProjectComment newComment) throws SQLException, ServiceException {
		Statement statement = dbService.getConnection().createStatement();
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT ");
		sql.append("MAX ");
		sql.append("(id_comment) ");
		sql.append("AS ");
		sql.append("max_id ");
		sql.append("FROM ");
		sql.append("comments ");
		statement.executeQuery(sql.toString());
		ResultSet rs=statement.getResultSet();
		rs.next();
		int id=1+rs.getInt("max_id");
		if(id>MAX_COMMENT_ID){
			throw new ServiceException("id must be lower than 8");
		}
		PreparedStatement ps = dbService
				.getConnection()
				.prepareStatement(
						"INSERT INTO comments (id_comment, id_project, id_user, comment) values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setInt(2, newComment.getProjectID());
		ps.setInt(3, newComment.getUserID());
		ps.setString(4, newComment.getComment());
		ps.executeUpdate();

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
		int result=statement.executeUpdate(sql.toString());
		if(result==0){
			throw new ServiceException("row not found");
		}
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
		PreparedStatement ps = dbService
				.getConnection()
				.prepareStatement(
						"INSERT INTO comments (id_project, id_user, comment) values(?,?,?)");
		for (Integer key : comments.keySet()) {
			List<ProjectComment> value = comments.get(key);
			for (ProjectComment comment : value) {
				ps.setInt(1, comment.getProjectID());
				ps.setInt(2, comment.getUserID());
				ps.setString(3, comment.getComment());
				ps.executeUpdate();
			}
		}
	}
}
