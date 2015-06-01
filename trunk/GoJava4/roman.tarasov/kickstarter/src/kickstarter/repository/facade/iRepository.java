package kickstarter.repository.facade;

import java.util.ArrayList;
import java.util.List;

import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;
import kickstarter.repository.facade.entityRepositories.IDcontent;
import kickstarter.repository.facade.entityRepositories.IRepository;

public interface iRepository {

	Category getCategory(int index) throws RepositoryException;

	int getCategoriesLength() throws RepositoryException;

	Quote getRandomQuote() throws RepositoryException;

	List<ProjectComment> getCommentsByProjectID(int projectID)
			throws RepositoryException;

	int getProjectsLength() throws RepositoryException;

	Project getProjectByIndex(int index) throws RepositoryException;

	Project getProjectById(int ID) throws RepositoryException;

	void addNewComment(ProjectComment comment) throws RepositoryException;

	int getCommentLength(int projectID);

	void deleteComment(int projectID, int commentID) throws RepositoryException;

	ArrayList<IRepository<IDcontent>> getAllRepositories();

	void setAllRepositories(ArrayList<IRepository<IDcontent>> allRepositories);

	List<IDcontent> getListAllCategories() throws RepositoryException;

}