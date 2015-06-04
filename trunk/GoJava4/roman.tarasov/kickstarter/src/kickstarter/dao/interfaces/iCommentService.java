package kickstarter.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.ProjectComment;

public interface iCommentService {

	void addComment(ProjectComment newComment);

	List<ProjectComment> getCommentsByProjectID(int projectID);

	int getCommentLength(int projectID);

	void deleteComment(int projectID, int commentID) throws ServiceException;

	Map<Integer, ArrayList<ProjectComment>> getAll();

	void createComments(iDAO sourceDAO)
			throws SQLException;
}
