package kickstarter.entities;

public interface iComments {

	public abstract void addComment(int userID, String newComment);

	public abstract int getCommentLength();

	public abstract void deleteComment(String userID, String commentID)
			throws NullPointerException, NumberFormatException;

	public abstract String[] getComment();

	public abstract void setComment(String[] comment);

}