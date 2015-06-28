package ua.goit.web.model.dao;

import java.util.List;


public interface CommentDao {

	List<Comment> getCommentsByProjectID(int projectID)
			throws KickstarterException;

	void addComment(Comment newComment) throws KickstarterException;
}
