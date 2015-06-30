package ua.goit.web.model.dao;

import java.util.List;

public interface IDao  {

	Quote getRandomQuote() throws KickstarterException;

	void addComment(Comment newComment) throws KickstarterException;

	List<Category> getAllCategories() throws KickstarterException;

	List<Project> sortProjectsByCategoryID(int categoryID)
			throws KickstarterException;

	Project getProjectById(int ID) throws KickstarterException;

	void updateProject(Project project) throws KickstarterException;

	List<Comment> getCommentsByProjectID(int projectID)
			throws KickstarterException;

	List<String> getUsersNamesByListComments(List<Comment> comments) throws KickstarterException;

	User getUserInfo(String login, String password) throws KickstarterException;

}
