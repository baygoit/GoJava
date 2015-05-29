package kickstarter.repository.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kickstarter.entities.ProjectComments;

public class CommentsRepository implements Serializable {

	private static final long serialVersionUID = -6568585281880977465L;

	private int projectID;

	HashMap<Integer, ArrayList<ProjectComments>> allComments;

	public CommentsRepository() {
		allComments = new HashMap<Integer, ArrayList<ProjectComments>>();
	}

	public void addComment(ProjectComments newComment) {
		projectID = newComment.getProjectID();

		ArrayList<ProjectComments> listFromAllComments = allComments
				.get(projectID);
		if (listFromAllComments != null) {
			listFromAllComments.add(newComment);
			return;
		}
		ArrayList<ProjectComments> newList = new ArrayList<ProjectComments>();
		newList.add(newComment);
		allComments.put(projectID, newList);
	}

	public List<ProjectComments> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	public int getCommentLength(int projectID) {

		List<ProjectComments> listFromAllComments = allComments.get(projectID);
		if (listFromAllComments != null) {
			return listFromAllComments.size();
		}
		return 0;
	}

	public void deleteComment(int projectID, int commentID)
			throws  RepositoryException {
		List<ProjectComments> listFromAllComments = getCommentsByProjectID(projectID);
		if(listFromAllComments!=null){
			listFromAllComments.remove(commentID);
			return;
		}
		throw new RepositoryException("error delete comment ");
	}
}
