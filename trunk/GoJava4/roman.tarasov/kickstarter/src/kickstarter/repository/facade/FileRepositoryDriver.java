package kickstarter.repository.facade;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;
import kickstarter.repository.facade.entityRepositories.ArrayListExtendedByID;
import kickstarter.repository.facade.entityRepositories.IDcontent;
import kickstarter.repository.facade.entityRepositories.IRepository;
import kickstarter.repository.facade.entityRepositories.Repository;

//TODO
public class FileRepositoryDriver implements iRepository {
	final private String REPOSITORY_PATH = "REPOSITORY";

	Repository<Project> projectsRepository;// = new Repository<Project>();
	String fileName = "default";
	private ArrayList<IRepository<IDcontent>> allRepositories;

	@Override
	public void setAllRepositories(
			ArrayList<IRepository<IDcontent>> allRepositories) {
		this.allRepositories = allRepositories;
	}

	<T> void creatorFilesFromList(IRepository<IDcontent> irepository,
			String path, String folderName, String entityName)
			throws RepositoryException {
		try {
			if (Files.notExists(Paths.get(path + "/" + folderName))) {
				Files.createDirectory(Paths.get(path + "/" + folderName));
			}
		} catch (IOException e) {
			throw new RepositoryException(" creation of directory has error");
		}
		ArrayListExtendedByID<IDcontent> entityList = irepository.getList();
		for (IDcontent entity : entityList) {
			try {
				File file = new File(path + "/" + folderName + "/" + entityName
						+ "." + Integer.toString(entity.getID()) + ".xml");

				JAXBContext jaxbContext = JAXBContext.newInstance(entity
						.getClass());
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(entity, file);

			} catch (JAXBException e) {
				throw new RepositoryException(" marshalling error");
			}
		}
	}

	public void createFileSystemRepository() throws RepositoryException {
		createRepositoryDir(REPOSITORY_PATH);

		for (IRepository<IDcontent> currentRepository : allRepositories) {
			String entityName = currentRepository.getEntityName();
			String folderName = currentRepository.getFolderName();
			creatorFilesFromList(currentRepository, REPOSITORY_PATH,
					folderName, entityName);
		}
	}

	public <T> void loaderFilesToInMemoryRepository(
			IRepository<IDcontent> irepository, String path, String folderName,
			String entityName) throws RepositoryException {

		//ArrayList<T> listProjects = new ArrayList<T>();
		Path pathToFolder = FileSystems.getDefault().getPath(
				path + "/" + folderName);
		IDcontent entityFromUnmarshall = null;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(
				pathToFolder, "*.{xml}")) {
			for (Path entry : stream) {
				try {
					File file = new File(entry.toString());
					JAXBContext jaxbContext = JAXBContext
							.newInstance(Project.class);// newInstance(Project.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext
							.createUnmarshaller();
					entityFromUnmarshall = (IDcontent) jaxbUnmarshaller.unmarshal(file);
					irepository.addEntity(entityFromUnmarshall);

				} catch (JAXBException e) {
					throw new RepositoryException(
							"unmarshalling iprojects has error");
				}
			}
			//irepository.setList(listProjects);
		} catch (IOException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can // only be thrown by newDirectoryStream.
			throw new RepositoryException("unmarshalling iprojects has error");
		}

	}

	private void createRepositoryDir(String path) throws RepositoryException {
		try {
			if (Files.notExists(Paths.get(path))) {
				Files.createDirectory(Paths.get(path));
			}
		} catch (IOException e) {
			throw new RepositoryException(" creation of directory has error");
		}
	}

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
		return null;
		/*
		 * quotes = new QuotesRepository(); ArrayList<Quote> listQuotes = new
		 * ArrayList<Quote>(); Path path =
		 * FileSystems.getDefault().getPath("repository/quotes"); Quote
		 * quoteFromUnmarshall = null; try (DirectoryStream<Path> stream =
		 * Files.newDirectoryStream(path, "*.{xml}")) { for (Path entry :
		 * stream) { try { File file = new File(entry.toString()); JAXBContext
		 * jaxbContext = JAXBContext .newInstance(Quote.class);
		 * 
		 * Unmarshaller jaxbUnmarshaller = jaxbContext .createUnmarshaller();
		 * quoteFromUnmarshall = (Quote) jaxbUnmarshaller .unmarshal(file);
		 * listQuotes.add(quoteFromUnmarshall);
		 * 
		 * } catch (JAXBException e) { throw new RepositoryException(
		 * "unmarshalling quotes has error"); } } quotes.setQuotes(listQuotes);
		 * } catch (IOException x) { // IOException can never be thrown by the
		 * iteration. // In this snippet, it can // only be thrown by
		 * newDirectoryStream. throw new
		 * RepositoryException("unmarshalling quotes has error"); } return
		 * listQuotes.get(new Random().nextInt(listQuotes.size()));
		 */
	}

	@Override
	public int getProjectsLength() throws RepositoryException {
		return 0;
		/*
		 * if (projectsRepository == null) { loadProjectsRepository(); } return
		 * projectsRepository.getProjects().size();
		 */
	}

	void loadProjectsRepository() throws RepositoryException {
		/*
		 * projectsRepository = new ProjectsRepository(); ArrayList<Project>
		 * listProjects = new ArrayList<Project>(); Path path =
		 * FileSystems.getDefault().getPath("repository/iprojects"); Project
		 * projectFromUnmarshall = null; try (DirectoryStream<Path> stream =
		 * Files.newDirectoryStream(path, "*.{xml}")) { for (Path entry :
		 * stream) { try { File file = new File(entry.toString()); JAXBContext
		 * jaxbContext = JAXBContext .newInstance(Project.class);
		 * 
		 * Unmarshaller jaxbUnmarshaller = jaxbContext .createUnmarshaller();
		 * projectFromUnmarshall = (Project) jaxbUnmarshaller .unmarshal(file);
		 * listProjects.add(projectFromUnmarshall);
		 * 
		 * } catch (JAXBException e) { throw new RepositoryException(
		 * "unmarshalling iprojects has error"); } }
		 * projectsRepository.setProjects(listProjects); } catch (IOException x)
		 * { // IOException can never be thrown by the iteration. // In this
		 * snippet, it can // only be thrown by newDirectoryStream. throw new
		 * RepositoryException("unmarshalling iprojects has error"); }
		 */

	}

	@Override
	public Project getProjectByIndex(int index) throws RepositoryException {
		/*
		 * if (projectsRepository == null) { loadProjectsRepository(); } return
		 * projectsRepository.getProjects().get(index);
		 */
		return null;
	}

	@Override
	public Project getProjectById(int projectID) throws RepositoryException {
		/*
		 * int length = projectsRepository.getProjects().size();
		 * 
		 * for (int index = 0; index < length; index++) { Project currentProject
		 * = projectsRepository.getProjects() .get(index);
		 * 
		 * if (currentProject.getID() == projectID) { return currentProject; } }
		 */
		return null;
	}

	@Override
	public List<IDcontent> getListAllCategories() throws RepositoryException {
		return null;
		/*
		 * categories = new CategoriesRepository(); ArrayList<Category>
		 * listCategories = new ArrayList<Category>(); Path path =
		 * FileSystems.getDefault().getPath("repository/icategories"); Category
		 * categoryFromUnmarshall = null; try (DirectoryStream<Path> stream =
		 * Files.newDirectoryStream(path, "*.{xml}")) { for (Path entry :
		 * stream) { try { File file = new File(entry.toString()); JAXBContext
		 * jaxbContext = JAXBContext .newInstance(Category.class);
		 * 
		 * Unmarshaller jaxbUnmarshaller = jaxbContext .createUnmarshaller();
		 * categoryFromUnmarshall = (Category) jaxbUnmarshaller
		 * .unmarshal(file); listCategories.add(categoryFromUnmarshall);
		 * 
		 * } catch (JAXBException e) { throw new RepositoryException(
		 * "unmarshalling icategories has error"); } }
		 * categories.setCategories(listCategories); } catch (IOException x) {
		 * // IOException can never be thrown by the iteration. // In this
		 * snippet, it can // only be thrown by newDirectoryStream. throw new
		 * RepositoryException("unmarshalling icategories has error"); } return
		 * categories.getCategories();
		 */
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameOfRepository() {
		return fileName;
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

	@Override
	public ArrayList<IRepository<IDcontent>> getAllRepositories() {

		return allRepositories;
	}

}
