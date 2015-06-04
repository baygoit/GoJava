package kickstarter.dao.databaseServices;

import java.sql.PreparedStatement;
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
		this.dbService=dbService;
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
	public List<ProjectComment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	@Override
	public int getCommentLength(int projectID) {

		List<ProjectComment> listFromAllComments = allComments.get(projectID);
		if (listFromAllComments != null) {
			return listFromAllComments.size();
		}
		return 0;
	}

	@Override
	public void deleteComment(int projectID, int commentID)
			throws ServiceException {
		List<ProjectComment> listFromAllComments = getCommentsByProjectID(projectID);
		if (listFromAllComments != null) {
			listFromAllComments.remove(commentID);
			return;
		}
		throw new ServiceException("error delete comment ");
	}

	@Override
	public Map<Integer, ArrayList<ProjectComment>> getAll() {
		return allComments;
	}
	
	@Override
	public void createComments(iDAO sourceDAO)
			throws SQLException {
		
		Map<Integer, ArrayList<ProjectComment>> comments = sourceDAO
				.getCommentService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  comments ");
		statement
				.executeUpdate("CREATE TABLE comments (id_comment SERIAL not null PRIMARY KEY,id_project integer,id_user integer, comment varchar(255))");

		for (Integer key : comments.keySet()) {
			System.out.println(key);
			List<ProjectComment> value = comments.get(key);

			for (ProjectComment comment : value) {

				PreparedStatement preparedStatement = dbService.getConnection()
						.prepareStatement("INSERT INTO comments (id_project, id_user, comment) values(?,?,?)");
				preparedStatement.setInt(1, comment.getProjectID());
				preparedStatement.setInt(2, comment.getUserID());
				preparedStatement.setString(3, comment.getComment());
				preparedStatement.executeUpdate();
			}
		}
	}
}
