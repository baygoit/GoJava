package kickstarter.repository.facade.entityRepositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.ProjectComment;

public class CommentsRepository implements Serializable {

	private static final long serialVersionUID = -6568585281880977465L;

	private int projectID;

	HashMap<Integer, ArrayList<ProjectComment>> allComments;

	public CommentsRepository() {
		allComments = new HashMap<Integer, ArrayList<ProjectComment>>();
	}

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

	public List<ProjectComment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	public int getCommentLength(int projectID) {

		List<ProjectComment> listFromAllComments = allComments.get(projectID);
		if (listFromAllComments != null) {
			return listFromAllComments.size();
		}
		return 0;
	}

	public void deleteComment(int projectID, int commentID)
			throws  RepositoryException {
		List<ProjectComment> listFromAllComments = getCommentsByProjectID(projectID);
		if(listFromAllComments!=null){
			listFromAllComments.remove(commentID);
			return;
		}
		throw new RepositoryException("error delete comment ");
	}
}
