package kickstarter.dao.interfaces;

import java.util.List;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.ProjectComment;

public interface iCommentService {

	void addComment(ProjectComment newComment);

	List<ProjectComment> getCommentsByProjectID(int projectID);

	int getCommentLength(int projectID);

	void deleteComment(int projectID, int commentID) throws ServiceException;

}
