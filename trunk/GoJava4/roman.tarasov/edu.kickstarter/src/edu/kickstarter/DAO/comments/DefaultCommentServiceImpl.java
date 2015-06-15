package edu.kickstarter.DAO.comments;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kickstarter.entity.ProjectComment;

public class DefaultCommentServiceImpl implements CommentService {

	private int projectID;
	HashMap<Integer, ArrayList<ProjectComment>> allComments;
	ArrayList<ProjectComment> commentsInProject;

	public DefaultCommentServiceImpl() {
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
	public List<ProjectComment> getCommentsByProjectID(int projectID) {
		return allComments.get(projectID);
	}

	@Override
	public Map<Integer, ArrayList<ProjectComment>> getAll() {
		return allComments;
	}
}
