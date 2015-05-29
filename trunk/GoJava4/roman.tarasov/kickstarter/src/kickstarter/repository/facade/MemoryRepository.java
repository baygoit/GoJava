package kickstarter.repository.facade;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);
		quotesRepository.setQuotes(quotes);

		// ----------------------------------------------------------
		categoriesRepository = new CategoriesRepository();
		categories = new ArrayList<Category>();
		Category category = new Category("Technology");
		category.setID(5);
		categories.add(category);

		category = new Category("Social");
		category.setID(4);
		categories.add(category);
		categoriesRepository.setCategories(categories);
		// ----------------------------------------------------------
		commentsRepository = new CommentsRepository();
		
		ProjectComment comment = new ProjectComment(8, 3,
				"What color will paint?");
		commentsRepository.addComment(comment);
		comment = new ProjectComment(8, 2, "Paint is Green");
		commentsRepository.addComment(comment);

		comment = new ProjectComment(23, 4, "how much weight the bike?");
		commentsRepository.addComment(comment);
		comment = new ProjectComment(23, 5, "The weight of bike is 15 kilo");
		commentsRepository.addComment(comment);

		comment = new ProjectComment(
				20,
				8,
				"One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
		commentsRepository.addComment(comment);
		comment = new ProjectComment(
				20,
				8,
				"Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
		commentsRepository.addComment(comment);
		// ----------------------------------------------------------
		projectsRepository = new ProjectsRepository();

		int categoryID = 5;
		projects = new ArrayList<Project>();
		Project project = new Project("Create electrobike", categoryID);
		project.setDescription("high efficiency");
		project.setShortDescription("short description");
		project.setHistory("history of bike creation");
		project.setLinkToVideo("www.link.to.demo.video");
		project.setPledged(25);
		project.setGoal(2000);
		project.setID(23);
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.amount = new double[] { 1, 10, 40 };
		projects.add(project);

		categoryID = 4;
		project = new Project("Paint the fence of the school", categoryID);
		project.setDescription("raising money for paint");
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.amount = new double[] { 1, 10, 40 };
		project.setID(8);
		projects.add(project);

		categoryID = 4;
		project = new Project("Help Build ACRE's New Home in Chicago",
				categoryID);
		project.setDescription("The renovation of our new space and expansion of our Chicago programming!");
		project.setShortDescription("Help ACRE achieve our most ambitious project to date");
		project.setInvestmentOptions(new String[] { "100$ - ", "150$ -",
				"400$ -" });
		project.amount = new double[] { 100, 150, 400 };
		project.setPledged(5000);
		project.setGoal(10000);
		project.setID(1);
		projects.add(project);

		categoryID = 5;
		project = new Project("Microduino mCookie", categoryID);
		project.setDescription("Small, stackable, Arduino-compatible electronics for makers, designers, engineers, students and curious tinkerers of all ages.");
		project.setShortDescription("The smallest electronic modules on LEGO");
		project.setHistory("history of Microduino mCookie");
		project.setLinkToVideo("https://www.microduino.cc/module/view?id=53da0abdc69eee000055f55d");
		project.setPledged(205);
		project.setGoal(20000);
		project.setID(20);
		project.setInvestmentOptions(new String[] { "10$ - ", "20$ -", "100$ -" });
		project.amount = new double[] { 10, 20, 100 };
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

		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("categories.ser")))) {

			out.writeObject(categoriesRepository);
		} catch (IOException e) {
			throw new RepositoryException("Error categories.ser creation");
		}

		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("projects.ser")))) {

			out.writeObject(projectsRepository);
		} catch (IOException e) {
			throw new RepositoryException("Error projects.ser creation");
		}

		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("quotes.ser")))) {

			out.writeObject(quotesRepository);
		} catch (IOException e) {
			throw new RepositoryException("Error quotes.ser creation");
		}
		
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("comments.ser")))) {

			out.writeObject(commentsRepository);
		} catch (IOException e) {
			throw new RepositoryException("Error comments.ser creation");
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
	public void deleteComment(int projectID, int commentID) throws RepositoryException{
		commentsRepository.deleteComment( projectID, commentID);
		
	}

}
