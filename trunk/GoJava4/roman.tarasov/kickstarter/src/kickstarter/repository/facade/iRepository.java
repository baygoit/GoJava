package kickstarter.repository.facade;

import java.util.List;

import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;

public interface iRepository {

	public abstract Category getCategory(int index) throws RepositoryException;

	public abstract int getCategoriesLength() throws RepositoryException;

	public abstract Quote getRandomQuote() throws RepositoryException;

	public abstract List<ProjectComment> getCommentsByProjectID(int projectID)
			throws RepositoryException;

	public abstract int getProjectsLength() throws RepositoryException;

	public abstract Project getProjectByIndex(int index)
			throws RepositoryException;

	public abstract Project getProjectById(int ID) throws RepositoryException;

	public abstract List<Category> getListAllCategories()
			throws RepositoryException;

	void createFileSystemRepository() throws RepositoryException;

	void addNewComment(ProjectComment comment) throws RepositoryException;

	public abstract int getCommentLength(int projectID);

	public abstract void deleteComment(int projectID, int commentID) throws RepositoryException;

}