package kickstarter.repository.facade;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;
import kickstarter.repository.facade.entityRepositories.CategoriesRepository;
import kickstarter.repository.facade.entityRepositories.CommentsRepository;
import kickstarter.repository.facade.entityRepositories.ProjectsRepository;
import kickstarter.repository.facade.entityRepositories.QuotesRepository;

public class MemoryRepository implements iRepository, Serializable {

	private static final long serialVersionUID = -9048596809324290852L;
	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;
	private QuotesRepository quotesRepository;
	private CategoriesRepository categoriesRepository;
	private CommentsRepository commentsRepository;
	private ProjectsRepository projectsRepository;

	public MemoryRepository() {
		quotesRepository = new QuotesRepository();
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setID(1);
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setID(2);
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);
		quotesRepository.setQuotes(quotes);

		// ----------------------------------------------------------
		categoriesRepository = new CategoriesRepository();
		categories = new ArrayList<Category>();
		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		categories.add(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		categories.add(category);
		categoriesRepository.setCategories(categories);
		// ----------------------------------------------------------
		commentsRepository = new CommentsRepository();

		ProjectComment comment = new ProjectComment();
		comment.setComment("What color will paint?");
		comment.setUserID(3);
		comment.setProjectID(8);
		commentsRepository.addComment(comment);

		comment = new ProjectComment();
		comment.setComment("Paint is Green");
		comment.setUserID(2);
		comment.setProjectID(8);
		commentsRepository.addComment(comment);

		comment = new ProjectComment();
		comment.setComment("how much weight the bike?");
		comment.setUserID(4);
		comment.setProjectID(23);
		commentsRepository.addComment(comment);

		comment = new ProjectComment();
		comment.setComment("The weight of bike is 15 kilo");
		comment.setUserID(5);
		comment.setProjectID(23);
		commentsRepository.addComment(comment);

		comment = new ProjectComment();
		comment.setComment("One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
		comment.setUserID(8);
		comment.setProjectID(20);
		commentsRepository.addComment(comment);
		comment = new ProjectComment();
		comment.setUserID(9);
		comment.setProjectID(20);
		comment.setComment("Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
		commentsRepository.addComment(comment);
		// ----------------------------------------------------------
		projectsRepository = new ProjectsRepository();

		int categoryID = 5;
		projects = new ArrayList<Project>();
		Project project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Create electrobike");
		project.setDescription("high efficiency");
		project.setShortDescription("short description");
		project.setHistory("history of bike creation");
		project.setLinkToVideo("www.link.to.demo.video");
		project.setPledged(25);
		project.setGoal(2000);
		project.setID(23);
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.setAmount(new double[] { 1, 10, 40 });
		projects.add(project);

		categoryID = 4;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Paint the fence of the school");
		project.setDescription("raising money for paint");
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.setAmount(new double[] { 1, 10, 40 });
		project.setID(8);
		projects.add(project);

		categoryID = 4;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Help Build ACRE's New Home in Chicago");
		project.setDescription("The renovation of our new space and expansion of our Chicago programming!");
		project.setShortDescription("Help ACRE achieve our most ambitious project to date");
		project.setInvestmentOptions(new String[] { "100$ - ", "150$ -",
				"400$ -" });
		project.setAmount(new double[] { 100, 150, 400 });
		project.setPledged(5000);
		project.setGoal(10000);
		project.setID(1);
		projects.add(project);

		categoryID = 5;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Microduino mCookie");
		project.setDescription("Small, stackable, Arduino-compatible electronics for makers, designers, engineers, students and curious tinkerers of all ages.");
		project.setShortDescription("The smallest electronic modules on LEGO");
		project.setHistory("history of Microduino mCookie");
		project.setLinkToVideo("https://www.microduino.cc/module/view?id=53da0abdc69eee000055f55d");
		project.setPledged(205);
		project.setGoal(20000);
		project.setID(20);
		project.setInvestmentOptions(new String[] { "10$ - ", "20$ -", "100$ -" });
		project.setAmount(new double[] { 10, 20, 100 });
		projects.add(project);
		projectsRepository.setProjects(projects);

	}

	@Override
	public Category getCategory(int index) {
		return categories.get(index);
	}

	@Override
	public int getCategoriesLength() {
		return categories.size();
	}

	@Override
	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}

	@Override
	public int getProjectsLength() {
		return projects.size();
	}

	@Override
	public Project getProjectByIndex(int index) {
		return projects.get(index);
	}

	@Override
	public Project getProjectById(int ID) {
		int length = projects.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.get(index);
			if (currentProject.getID() == ID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public List<Category> getListAllCategories() {
		return categories;
	}

	@Override
	public void addNewComment(ProjectComment comment) {
		commentsRepository.addComment(comment);
	}

	@Override
	public void createFileSystemRepository() throws RepositoryException {
		createRepositoryDir();
		createCategoriesDir();
		createProjectsDir();
		createQuotesDir();
		createCommentsDir();
	}

	private void createRepositoryDir() throws RepositoryException {
		try {
			if (Files.notExists(Paths.get("repository"))) {
				Files.createDirectory(Paths.get("repository"));
			}
		} catch (IOException e) {
			throw new RepositoryException("Error repository directory creation");
		}
	}

	private void createCategoriesDir() throws RepositoryException {
		try {
			if (Files.notExists(Paths.get("repository/categories"))) {
				Files.createDirectory(Paths.get("repository/categories"));
			}
		} catch (IOException e) {
			throw new RepositoryException("Error categories directory creation");
		}
		for (Category category : categoriesRepository.getCategories()) {
			try {
				File file = new File("repository/categories/categoryID."
						+ Integer.toString(category.getID()) + ".xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Category.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(category, file);

			} catch (JAXBException e) {
				throw new RepositoryException("categories marshalling error");
			}
		}
	}

	private void createProjectsDir() throws RepositoryException {
		try {
			if (Files.notExists(Paths.get("repository/projects"))) {
				Files.createDirectory(Paths.get("repository/projects"));
			}
		} catch (IOException e) {
			throw new RepositoryException("Error projects directory creation");
		}
		for (Project project : projectsRepository.getProjects()) {
			try {
				File file = new File("repository/projects/projectID."
						+ Integer.toString(project.getID()) + ".xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Project.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(project, file);

			} catch (JAXBException e) {
				throw new RepositoryException("projects marshalling error");
			}
		}
	}

	private void createQuotesDir() throws RepositoryException {
		try {
			if (Files.notExists(Paths.get("repository/quotes"))) {
				Files.createDirectory(Paths.get("repository/quotes"));
			}
		} catch (IOException e) {
			throw new RepositoryException("Error quotes directory creation");
		}
		for (Quote quote : quotesRepository.getQuotes()) {
			try {
				File file = new File("repository/quotes/quoteID."
						+ Integer.toString(quote.getID()) + ".xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Quote.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(quote, file);

			} catch (JAXBException e) {
				throw new RepositoryException("quotes marshalling error");
			}
		}
	}

	private void createCommentsDir() throws RepositoryException {
		try {
			if (Files.notExists(Paths.get("repository/comments"))) {
				Files.createDirectory(Paths.get("repository/comments"));
			}
		} catch (IOException e) {
			throw new RepositoryException("Error comments directory creation");
		}
		for (Project project : projectsRepository.getProjects()) {
			if (commentsRepository.getCommentLength(project.getID()) != 0) {
				for (ProjectComment projectComment : commentsRepository
						.getCommentsByProjectID(project.getID())) {
					try {
						File file = new File("repository/comments/"
								+ "commentsOfProjectID."
								+ Integer.toString(projectComment
										.getProjectID()) + ".xml");
						JAXBContext jaxbContext = JAXBContext
								.newInstance(ProjectComment.class);
						Marshaller jaxbMarshaller = jaxbContext
								.createMarshaller();
						jaxbMarshaller.setProperty(
								Marshaller.JAXB_FORMATTED_OUTPUT, true);
						jaxbMarshaller.marshal(projectComment, file);

					} catch (JAXBException e) {
						throw new RepositoryException(
								"comments marshalling error");
					}
				}
			}
		}
	}

	@Override
	public int getCommentLength(int projectID) {
		return commentsRepository.getCommentLength(projectID);
	}

	@Override
	public List<ProjectComment> getCommentsByProjectID(int projectID)
			throws RepositoryException {
		return commentsRepository.getCommentsByProjectID(projectID);
	}

	@Override
	public void deleteComment(int projectID, int commentID)
			throws RepositoryException {
		commentsRepository.deleteComment(projectID, commentID);
	}
}
