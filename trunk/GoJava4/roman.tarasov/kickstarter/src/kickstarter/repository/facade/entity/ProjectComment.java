package kickstarter.repository.facade.entity;

import java.io.Serializable;

public class ProjectComment implements Serializable {

	private static final long serialVersionUID = 6511337370371120313L;
	private int projectID;
	private int userID;
	private int commentID;
	private String comment;

	public ProjectComment(int projectID, int userID, String comment) {
		super();
		this.projectID = projectID;
		this.userID = userID;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

}
