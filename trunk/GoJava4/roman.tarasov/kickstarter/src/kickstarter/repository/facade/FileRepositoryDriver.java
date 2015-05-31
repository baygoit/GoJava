package kickstarter.repository.facade;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;
import kickstarter.repository.facade.entityRepositories.CategoriesRepository;
import kickstarter.repository.facade.entityRepositories.ProjectsRepository;
import kickstarter.repository.facade.entityRepositories.QuotesRepository;

//TODO
public class FileRepositoryDriver implements iRepository {
	ProjectsRepository projectsRepository;
	QuotesRepository quotes;
	CategoriesRepository categories;
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

		quotes = new QuotesRepository();
		ArrayList<Quote> listQuotes = new ArrayList<Quote>();
		Path path = FileSystems.getDefault().getPath("repository/quotes");
		Quote quoteFromUnmarshall = null;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path,
				"*.{xml}")) {
			for (Path entry : stream) {
				try {
					File file = new File(entry.toString());
					JAXBContext jaxbContext = JAXBContext
							.newInstance(Quote.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext
							.createUnmarshaller();
					quoteFromUnmarshall = (Quote) jaxbUnmarshaller
							.unmarshal(file);
					listQuotes.add(quoteFromUnmarshall);

				} catch (JAXBException e) {
					throw new RepositoryException(
							"unmarshalling quotes has error");
				}
			}
			quotes.setQuotes(listQuotes);
		} catch (IOException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can // only be thrown by newDirectoryStream.
			throw new RepositoryException("unmarshalling quotes has error");
		}
		return listQuotes.get(new Random().nextInt(listQuotes.size()));
	}

	@Override
	public int getProjectsLength() throws RepositoryException {
		throw new RepositoryException("");
	}

	@Override
	public Project getProjectByIndex(int projectID) throws RepositoryException {
		projectsRepository = new ProjectsRepository();
		ArrayList<Project> listProjects = new ArrayList<Project>();
		Path path = FileSystems.getDefault().getPath("repository/projects");
		Project projectFromUnmarshall = null;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path,
				"*.{xml}")) {
			for (Path entry : stream) {
				try {
					File file = new File(entry.toString());
					JAXBContext jaxbContext = JAXBContext
							.newInstance(Project.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext
							.createUnmarshaller();
					projectFromUnmarshall = (Project) jaxbUnmarshaller
							.unmarshal(file);
					listProjects.add(projectFromUnmarshall);

				} catch (JAXBException e) {
					throw new RepositoryException(
							"unmarshalling projects has error");
				}
			}
			projectsRepository.setProjects(listProjects);
		} catch (IOException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can // only be thrown by newDirectoryStream.
			throw new RepositoryException("unmarshalling projects has error");
		}

		int length = listProjects.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = listProjects.get(index);
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
		categories = new CategoriesRepository();
		ArrayList<Category> listCategories = new ArrayList<Category>();
		Path path = FileSystems.getDefault().getPath("repository/categories");
		Category categoryFromUnmarshall = null;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path,
				"*.{xml}")) {
			for (Path entry : stream) {
				try {
					File file = new File(entry.toString());
					JAXBContext jaxbContext = JAXBContext
							.newInstance(Category.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext
							.createUnmarshaller();
					categoryFromUnmarshall = (Category) jaxbUnmarshaller
							.unmarshal(file);
					listCategories.add(categoryFromUnmarshall);

				} catch (JAXBException e) {
					throw new RepositoryException(
							"unmarshalling categories has error");
				}
			}
			categories.setCategories(listCategories);
		} catch (IOException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can // only be thrown by newDirectoryStream.
			throw new RepositoryException("unmarshalling categories has error");
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
	public void addNewComment(ProjectComment comment)
			throws RepositoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCommentLength(int projectID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProjectComment> getCommentsByProjectID(int projectID)
			throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(int projectID, int commentID) {
		// TODO Auto-generated method stub

	}
}
