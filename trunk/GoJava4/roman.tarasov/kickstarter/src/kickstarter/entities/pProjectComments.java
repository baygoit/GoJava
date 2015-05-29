package kickstarter.entities;

import java.io.Serializable;

public class pProjectComments implements Serializable, iComments{

	private static final long serialVersionUID = -4689189179769667015L;
	public int[] usersID;
	private String[] comment;
	private int commentIndex = 0;
	final int INIT_SIZE = 10;
	final int ADD_TO_SIZE = 10;
	public int projectID;

	public pProjectComments(int projectID) {
		this.projectID = projectID;
		usersID = new int[INIT_SIZE];
		setComment(new String[INIT_SIZE]);
	}

	/* (non-Javadoc)
	 * @see kickstarter.entities.iComments#addComment(int, java.lang.String)
	 */
	@Override
	public void addComment(int userID, String newComment) {
		int len = getComment().length;
		if (commentIndex >= len) {
			String[] newComments = new String[getComment().length + ADD_TO_SIZE];
			System.arraycopy(getComment(), 0, newComments, 0,
					getComment().length);
			setComment(newComments);

			int[] newUsersID = new int[len + ADD_TO_SIZE];
			System.arraycopy(usersID, 0, newUsersID, 0, getCommentLength());

			usersID = newUsersID;
		}
		getComment()[commentIndex] = newComment;
		usersID[commentIndex] = userID;
		commentIndex++;
	}

	/* (non-Javadoc)
	 * @see kickstarter.entities.iComments#getCommentLength()
	 */
	@Override
	public int getCommentLength() {
		return commentIndex;
	}

	/* (non-Javadoc)
	 * @see kickstarter.entities.iComments#deleteComment(java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteComment(String userID, String commentID)
			throws NullPointerException, NumberFormatException {

		int intUserID = Integer.parseInt(userID);
		int intCommentID = Integer.parseInt(commentID);
		if (intCommentID < 0 || intCommentID >= commentIndex
				|| usersID[intCommentID] != intUserID) {
			throw new NullPointerException(null);
		}
		usersID[intCommentID] = 0;// 0 - deleted comment
	}

	/* (non-Javadoc)
	 * @see kickstarter.entities.iComments#getComment()
	 */
	@Override
	public String[] getComment() {
		return comment;
	}

	/* (non-Javadoc)
	 * @see kickstarter.entities.iComments#setComment(java.lang.String[])
	 */
	@Override
	public void setComment(String[] comment) {
		this.comment = comment;
	}
}
