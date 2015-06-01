package kickstarter.repository.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entity.Quote;
import kickstarter.repository.facade.entityRepositories.CommentsRepository;
import kickstarter.repository.facade.entityRepositories.IDcontent;
import kickstarter.repository.facade.entityRepositories.IRepository;
import kickstarter.repository.facade.entityRepositories.Repository;

public class MemoryRepository implements iRepository, Serializable {

	private static final long serialVersionUID = -9048596809324290852L;
	private CommentsRepository commentsRepository;

	private Repository<Quote> quotesRepository;
	private Repository<Category> categoriesRepository;
	private Repository<Project> projectsRepository;

	private IRepository<IDcontent> icategories;
	private IRepository<IDcontent> iprojects;
	private IRepository<IDcontent> iquotes;

	private ArrayList<IRepository<IDcontent>> allRepositories;

	public MemoryRepository() {
		allRepositories = new ArrayList<IRepository<IDcontent>>();

		quotesRepository = new Repository<Quote>();
		iquotes = quotesRepository;
		iquotes.setEntityName("quote");
		iquotes.setFolderName("Quotes");
		Quote quote = new Quote();
		quote.setID(1);
		quote.setQuote("Explore iprojects, everywhere");
		iquotes.addEntity(quote);

		quote = new Quote();
		quote.setID(2);
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		iquotes.addEntity(quote);

		// ----------------------------------------------------------
		categoriesRepository = new Repository<Category>();
		icategories = categoriesRepository;
		icategories.setEntityName("category");
		icategories.setFolderName("Categories");
		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		icategories.addEntity(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		icategories.addEntity(category);

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
		projectsRepository = new Repository<Project>();
		iprojects = projectsRepository;
		iprojects.setEntityName("project");
		iprojects.setFolderName("Projects");
		int categoryID = 5;

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
		iprojects.addEntity(project);

		categoryID = 4;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Paint the fence of the school");
		project.setDescription("raising money for paint");
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.setAmount(new double[] { 1, 10, 40 });
		project.setID(8);
		iprojects.addEntity(project);

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
		iprojects.addEntity(project);

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
		iprojects.addEntity(project);
		allRepositories.add(iprojects);
		allRepositories.add(icategories);
		allRepositories.add(iquotes);

	}

	@Override
	public ArrayList<IRepository<IDcontent>> getAllRepositories() {
		return allRepositories;

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

	@Override
	public Category getCategory(int index) {
		return null;
		// return icategories.get(index);
	}

	@Override
	public int getCategoriesLength() {
		return 0;
		// return icategories.size();
	}

	@Override
	public Quote getRandomQuote() {
		 List<IDcontent> list = quotesRepository.getList();
		return (Quote) quotesRepository.getList().get(
				new Random().nextInt(list.size()));

	}

	@Override
	public int getProjectsLength() {
		return 0;
		// return iprojects.size();
	}

	@Override
	public Project getProjectByIndex(int index) {
		List<IDcontent>  list = projectsRepository.getList();
		return (Project) list.get(index);
		
	}

	@Override
	public Project getProjectById(int ID) {
		List<IDcontent> list = projectsRepository.getList();

		int length = list.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = (Project) list.get(index);
			if (currentProject.getID() == ID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public   List<IDcontent> getListAllCategories() {
		List<IDcontent> list = categoriesRepository.getList();
		return  list;
	}

	@Override
	public void addNewComment(ProjectComment comment) {
		commentsRepository.addComment(comment);
	}

	@Override
	public void setAllRepositories(
			ArrayList<IRepository<IDcontent>> allRepositories) {
		// TODO Auto-generated method stub

	}
}
