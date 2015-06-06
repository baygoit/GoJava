package kickstarter.dao.defaultServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kickstarter.dao.interfaces.iCommentService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.ProjectComment;

public class DefaultCommentService implements iCommentService {

	private int projectID;
	HashMap<Integer, ArrayList<ProjectComment>> allComments;
	ArrayList<ProjectComment> commentsInProject;

	public DefaultCommentService() {
		allComments = new HashMap<Integer, ArrayList<ProjectComment>>();
		commentsInProject = new ArrayList<ProjectComment>();
		int projectID = 8;
		ProjectComment comment = new ProjectComment();
		comment.setComment("What color will paint?");
		comment.setUserID(3);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		commentsInProject.add(comment);

		comment = new ProjectComment();
		comment.setComment("Paint is Green");
		comment.setUserID(2);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		commentsInProject.add(comment);
		allComments.put(projectID, commentsInProject);

		projectID = 23;
		commentsInProject = new ArrayList<ProjectComment>();
		comment = new ProjectComment();
		comment.setComment("how much weight the bike?");
		comment.setUserID(4);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		commentsInProject.add(comment);

		comment = new ProjectComment();
		comment.setComment("The weight of bike is 15 kilo");
		comment.setUserID(5);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		commentsInProject.add(comment);
		allComments.put(projectID, commentsInProject);

		projectID = 20;
		commentsInProject = new ArrayList<ProjectComment>();
		comment = new ProjectComment();
		comment.setComment("One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
		comment.setUserID(8);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		commentsInProject.add(comment);

		comment = new ProjectComment();
		comment.setUserID(9);
		comment.setCommentID(1 + commentsInProject.size());
		comment.setProjectID(projectID);
		comment.setComment("Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
		commentsInProject.add(comment);
		allComments.put(projectID, commentsInProject);
	}

	@Override
	public void addComment(ProjectComment newComment) {
		projectID = newComment.getProjectID();

		List<ProjectComment> listFromAllComments = allComments.get(projectID);

		if (listFromAllComments != null && !listFromAllComments.isEmpty()) {
			newComment.setCommentID(searchMaxCommentID(listFromAllComments));
			listFromAllComments.add(newComment);
			return;
		}
		ArrayList<ProjectComment> newList = new ArrayList<ProjectComment>();
		newComment.setCommentID(1);
		newList.add(newComment);
		allComments.put(projectID, newList);
	}

	private int searchMaxCommentID(List<ProjectComment> listFromAllComments) {
		int maxID = listFromAllComments.get(0).getCommentID();
		for (ProjectComment comment : listFromAllComments) {
			int currentID = comment.getCommentID();
			if (currentID > maxID) {
				maxID = currentID;
			}
		}
		return maxID + 1;
	}

	@Override
	public List<ProjectComment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	@Override
	public void deleteComment(int projectID, int commentID)
			throws ServiceException {
		List<ProjectComment> listFromAllComments = getCommentsByProjectID(projectID);
		if (listFromAllComments != null) {
			for (int index = 0; index < listFromAllComments.size(); index++) {
				if (listFromAllComments.get(index).getCommentID() == commentID) {
					listFromAllComments.remove(index);
					return;
				}
			}
		}
		throw new ServiceException("error delete comment ");
	}

	@Override
	public Map<Integer, ArrayList<ProjectComment>> getAll() {
		return allComments;
	}

	@Override
	public void createComments(iDAO sourceDAO) throws SQLException {
	}
}
