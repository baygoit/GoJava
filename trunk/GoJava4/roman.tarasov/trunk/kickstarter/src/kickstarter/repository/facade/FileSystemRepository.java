package kickstarter.repository.facade;

import java.util.List;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;

public class FileSystemRepository implements iRepository{

	@Override
	public Category getCategory(int index) throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public int getCategoriesLength() throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public Quote getRandomQuote() throws RepositoryException {
		throw new RepositoryException();
		
	}

	@Override
	public ProjectComments getCommentsByProjectID(int projectID) throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public int getProjectsLength() throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public Project getProject(int index) throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public Project getProjectById(int ID) throws RepositoryException {
		throw new RepositoryException();
	}

	@Override
	public List<Category> getListAllCategories() throws RepositoryException {
		throw new RepositoryException();
	}

}
