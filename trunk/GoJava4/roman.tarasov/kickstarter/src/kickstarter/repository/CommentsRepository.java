package kickstarter.repository;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.ProjectComments;

public class CommentsRepository {
	List<ProjectComments> allComments;

	public CommentsRepository() {
		allComments = new ArrayList<ProjectComments>();
		ProjectComments comment = new ProjectComments(8);
		comment.addComment(1, "What color will paint?");
		comment.addComment(2, "Paint is Green");
		allComments.add(comment);

		comment = new ProjectComments(23);
		comment.addComment(3, "how much weight the bike?");
		comment.addComment(2, "The weight of bike is 15 kilo");
		allComments.add(comment);
	}

	public ProjectComments getCommentsByProjectID(int projectID) {

		for (int index = 0; index < allComments.size(); index++) {
			if (allComments.get(index).projectID == projectID) {
				return allComments.get(index);
			}
		}
		return null;
	}
}
