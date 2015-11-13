package ua.com.goit.gojava7.kickstarter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {

	private static final String QUOTE_BY_MISHA_COLLINS = "I actually think that the most efficacious way of making a difference is to lead by example, and doing random acts of kindness is setting a very good example of how to behave in the world.";
	private static final String QUOTE_BY_PRINCESS_DIANA = "Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you.";

	public Kickstarter() {
		initQuotes();
		initCategories();
		initProjects();
		body = new Body(this, consolePrinter);
	}

	private Body body;
	private ProjectManager projectManager = new ProjectManager(this);

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	private QuoteStorage quoteStorage = new QuoteStorage();
	private CategoryStorage categoryStorage = new CategoryStorage();
	private ConsoleScanner cs = new ConsoleScanner();
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private UserManager userManager = new UserManager(consolePrinter, cs, categoryStorage, this);

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group",
				kickstarter.getCategoryStorage().getCategoryById(1), LocalDateTime.now().plusHours(23));
		kickstarter.getProjectManager().getProjectByName("Catana").setDemoLink("www.catana.game");
		Map<String,String> qa = new HashMap<String,String>();
		qa.put("What is project about?","It is about our goit7 group");
		qa.put("When was it started", "October 2015");
		kickstarter.getProjectManager().getProjectByName("Catana").setQuestionsAndAnswers(qa);
		kickstarter.addProject(project);
		User guest = new User();
		kickstarter.addProject(project);
		kickstarter.getProjectManager().getProjects().forEach(p -> {
			p.setMoneyNeeded(50000);
		});
		kickstarter.getBody().generateMainPage();
		kickstarter.getUserManager().chooseProject(kickstarter.getProjectManager(), kickstarter.getUserManager().chooseCategory(guest));
		//kickstarter.getProjectManager().showCategoryInfo(guest);

	}

	public ConsoleScanner getConsoleScanner() {
		return cs;
	}

	public void setConsoleScanner(ConsoleScanner cs) {
		this.cs = cs;
	}

	

	public QuoteStorage getQuoteStorage() {
		return quoteStorage;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
	}

	public synchronized void addProject(Project pr) {
		projectManager.getProjects().add(pr);
	}

	public void initQuotes() {
		quoteStorage.addQuote(new Quote(
				QUOTE_BY_PRINCESS_DIANA,
				"Princess Diana"));
		quoteStorage.addQuote(new Quote(
				QUOTE_BY_MISHA_COLLINS,
				"Misha Collins"));
	}

	public void initCategories() {
		categoryStorage.addCategory(new Category("Movie", 1));
		categoryStorage.addCategory(new Category("Technology", 2));
		categoryStorage.addCategory(new Category("Games", 3));
		categoryStorage.addCategory(new Category("Books", 4));
	}

	private void initProjects() {
		LocalDateTime dateTime = LocalDateTime.now();
		projectManager.addProject(new Project("Catana", "New sword-fighting game", categoryStorage.getCategoryById(3),
				dateTime.plusDays(14)));
		projectManager.addProject(new Project("Terminator Exodus", "New game about fighting as Terminator",
				categoryStorage.getCategoryById(3), dateTime));
		projectManager.getProjectByName("Catana").addBacker(new User(), Double.valueOf(25000));
		

	}

}
