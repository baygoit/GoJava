package kickstarter.dao.defaultServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kickstarter.dao.interfaces.iCommentService;
import kickstarter.entity.ProjectComment;

public class DefaultCommentsService implements iCommentService {

	private int projectID;
	HashMap<Integer, ArrayList<ProjectComment>> allComments;

	public DefaultCommentsService() {
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
}
