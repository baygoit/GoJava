package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Menu;
import ua.com.goit.gojava7.kickstarter.domain.User;
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



	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		// TODO: Initialize the kickstarter
		User guest = new User();
		kickstarter.getBody().generateMainPage(kickstarter.getQuoteStorage(), kickstarter.getProjectManager(),
				kickstarter.getConsolePrinter(), kickstarter.getCategoryStorage());
		kickstarter.generateMenu(guest).showMenu();

	}

	public Menu generateMenu(User u) {
		return new Menu(u, projectManager, categoryStorage);
	}

}
