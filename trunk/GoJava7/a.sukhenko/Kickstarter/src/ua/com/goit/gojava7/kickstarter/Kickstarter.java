package ua.com.goit.gojava7.kickstarter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Menu;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {

	private QuoteStorage quoteStorage = new QuoteStorage();
	private CategoryStorage categoryStorage = new CategoryStorage();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private Body body = new Body();
	private ProjectManager projectManager = new ProjectManager();
	private boolean loadFromFile = false;
	private boolean saveToFile = true;

	public Kickstarter() {

	}

	public void init() {
		initQuotes();
		initCategories();
		initProjects();
	}

	public ConsoleScanner getConsoleScanner() {
		return consoleScanner;
	}

	public void setConsoleScanner(ConsoleScanner cs) {
		this.consoleScanner = cs;
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

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ConsolePrinter getConsolePrinter() {
		return consolePrinter;
	}

	public void setConsolePrinter(ConsolePrinter consolePrinter) {
		this.consolePrinter = consolePrinter;
	}

	public void showCategoryInfo(User guest) {
		projectManager.getProjectsByCategory(guest.getSettings().getCategory()).forEach(project -> {
			getBody().generateProjectInfo(project, consolePrinter);
		});

	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.init();
		User guest = new User();
		kickstarter.getBody().generateMainPage(kickstarter.getQuoteStorage(), kickstarter.getProjectManager(),
				kickstarter.getConsolePrinter());
		kickstarter.saveCagories();
		kickstarter.saveQuotes();
		kickstarter.saveProjects();
		kickstarter.generateMenu(guest).showMenu();

	}

	private void saveProjects() {
		if (saveToFile) {
			FileLoader.saveProjects(projectManager);
		}

	}

	public Menu generateMenu(User u) {
		return new Menu(u, projectManager, categoryStorage);
	}

	public synchronized void addProject(Project pr) {
		projectManager.getProjects().add(pr);
	}

	public void initQuotes() {
		quoteStorage.addQuote(new Quote(QuoteStorage.QUOTE_BY_PRINCESS_DIANA, "Princess Diana"));
		quoteStorage.addQuote(new Quote(QuoteStorage.QUOTE_BY_MISHA_COLLINS, "Misha Collins"));
	}

	public void initCategories() {
		categoryStorage.addCategory(new Category("Movie", 1));
		categoryStorage.addCategory(new Category("Technology", 2));
		categoryStorage.addCategory(new Category("Games", 3));
		categoryStorage.addCategory(new Category("Books", 4));

	}

	private void saveQuotes() {
		if (saveToFile) {
			FileLoader.saveQuotes(quoteStorage);
		}

	}

	protected void saveCagories() {
		if (saveToFile) {
			FileLoader.saveCategories(categoryStorage);
		}
	}

	private void initProjects() {
		LocalDateTime dateTime = LocalDateTime.now();
		projectManager.addProject(new Project("Catana", "New sword-fighting game", categoryStorage.getCategoryById(3),
				dateTime.plusDays(14)));
		projectManager.addProject(new Project("Terminator Exodus", "New game about fighting as Terminator",
				categoryStorage.getCategoryById(3), dateTime));
		projectManager.getProjectByName("Catana").addBacker(new User(), Double.valueOf(25000));
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group",
				getCategoryStorage().getCategoryById(1), LocalDateTime.now().plusHours(23));

		getProjectManager().getProjectByName("Catana").setDemoLink("www.catana.game");
		Map<String, String> qa = new HashMap<String, String>();
		qa.put("What is project about?", "It is about our goit7 group");
		qa.put("When was it started", "October 2015");
		getProjectManager().getProjectByName("Catana").setQuestionsAndAnswers(qa);
		addProject(project);
		getProjectManager().getProjects().forEach(p -> {
			p.setMoneyNeeded(50000);
		});

	}

	public boolean isLoadFromFile() {
		return loadFromFile;
	}

}
