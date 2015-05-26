package kickstarter.repository.facade;

import java.util.List;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;

public interface iRepository {

	public abstract Category getCategory(int index) throws RepositoryException;

	public abstract int getCategoriesLength()throws RepositoryException;

	public abstract Quote getRandomQuote()throws RepositoryException;

	public abstract ProjectComments getCommentsByProjectID(int projectID)throws RepositoryException;

	public abstract int getProjectsLength()throws RepositoryException;

	public abstract Project getProject(int index)throws RepositoryException;

	public abstract Project getProjectById(int ID)throws RepositoryException;

	public abstract List<Category> getListAllCategories()throws RepositoryException;

}