package kickstarter.repository.facade;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;

//TODO
public class FileRepositoryDriver implements iRepository {
	String fileName = "default";

	@Override
	public Category getCategory(int index) throws RepositoryException {
		throw new RepositoryException("");
	}

	@Override
	public int getCategoriesLength() throws RepositoryException {
		throw new RepositoryException("");
	}

	@Override
	public Quote getRandomQuote() throws RepositoryException {
		throw new RepositoryException("");
	}


	@Override
	public int getProjectsLength() throws RepositoryException {
		throw new RepositoryException("");
	}

	@Override
	public Project getProjectByIndex(int projectID) throws RepositoryException {
		ProjectsRepository projectsRepository;

		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("projects.ser")))) {
			projectsRepository = (ProjectsRepository) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new RepositoryException("reading projects.ser error");
		}
		List<Project> projects = projectsRepository.getProjects();
		int length = projects.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.get(index);
			if (currentProject.getID() == projectID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public Project getProjectById(int ID) throws RepositoryException {
		throw new RepositoryException("");
	}

	@Override
	public List<Category> getListAllCategories() throws RepositoryException {
		CategoriesRepository categories;
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("categories.ser")))) {
			categories = (CategoriesRepository) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new RepositoryException("reading categories.ser error");
		}
		return categories.getCategories();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameOfRepository() {
		return fileName;
	}


	@Override
	public void createFileSystemRepository() throws RepositoryException {

	}

	@Override
	public void addNewComment(ProjectComments comment)throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCommentLength(int projectID){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProjectComments> getCommentsByProjectID(int projectID)
			throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(int projectID, int commentID) {
		// TODO Auto-generated method stub
		
	}
}
