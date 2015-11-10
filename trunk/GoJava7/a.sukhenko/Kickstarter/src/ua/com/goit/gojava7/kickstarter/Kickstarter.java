package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Calendar;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

/**
 * @author Devian
 * @category Main
 */
public class Kickstarter {
	
	public Kickstarter() {
		initQuotes();
		initCategories();
		initProjects();
		body = new Body(this, consolePrinter);
	}
	
	private Body body;
	private static final boolean LOGS_ENABLED = true;
	private ArrayList<String> logs = new ArrayList<>();
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
	
	private UserManager userManager = new UserManager(consolePrinter, cs, categoryStorage,this);
	

	
	


	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group", kickstarter.getCategoryStorage().getCategoryById(1), Calendar.getInstance());
		kickstarter.addProject(project);
		User guest = new User();
		kickstarter.addProject(project);
		kickstarter.getBody().generateMainPage();
		kickstarter.getUserManager().chooseCategory(guest);
		kickstarter.getProjectManager().showCategoryInfo(guest);
		
		
	}
	
	public ConsoleScanner getConsoleScanner() {
		return cs;
	}

	public void setConsoleScanner(ConsoleScanner cs) {
		this.cs = cs;
	}
	
	public Project getProjectById(int id){
		return projectManager.getProjects().get(id);
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
	
	
	
	public void addProject(Project pr){
		projectManager.getProjects().add(pr);
		
		addLog("Project " + pr.getProjectName() + " added.");
	}
	protected void addLog(String s){
		if(LOGS_ENABLED)
		logs.add(s);
	}
	

	public void initQuotes(){
		quoteStorage.addQuote(new Quote("Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you.", "Princess Diana"));
		quoteStorage.addQuote(new Quote("I actually think that the most efficacious way of making a difference is to lead by example, and doing random acts of kindness is setting a very good example of how to behave in the world.","Misha Collins"));
	}
	
	public void initCategories(){
		categoryStorage.addCategory(new Category("Movie", 1));
		categoryStorage.addCategory(new Category("Technology", 2));
		categoryStorage.addCategory(new Category("Games", 3));
		categoryStorage.addCategory(new Category("Books", 4));
	}
	
	private void initProjects() {
		projectManager.addProject(new Project("Catana", "New sword-fighting game", categoryStorage.getCategoryById(3), Calendar.getInstance()));
		projectManager.addProject(new Project("Terminator Exodus", "New game about fighting as Terminator", categoryStorage.getCategoryById(3), Calendar.getInstance()));
		
	}
	
	
	
	
}
