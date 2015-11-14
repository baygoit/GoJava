package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Menu;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class UserManager{
	private ConsolePrinter	consolePrinter;
	private CategoryStorage	categoryStorage;
	private ConsoleScanner	consoleScanner;
	private Kickstarter		kickStarter;

	public UserManager(ConsolePrinter consolePrinter,
			ConsoleScanner consoleScanner, CategoryStorage categoryStorage,
			Kickstarter kickstarter) {
		this.consolePrinter = consolePrinter;
		this.categoryStorage = categoryStorage;
		this.consoleScanner = consoleScanner;
		this.kickStarter = kickstarter;
	}
	public UserManager() {

	}
	public ConsolePrinter getConsolePrinter() {
		return consolePrinter;
	}

	public void setConsolePrinter(ConsolePrinter consolePrinter) {
		this.consolePrinter = consolePrinter;
	}

	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
	}

	public ConsoleScanner getConsoleScanner() {
		return consoleScanner;
	}

	public void setConsoleScanner(ConsoleScanner consoleScanner) {
		this.consoleScanner = consoleScanner;
	}
	public Kickstarter getKickStarter() {
		return kickStarter;
	}

	public void setKickStarter(Kickstarter kickStarter) {
		this.kickStarter = kickStarter;
	}

	public void generateMenu(User u) {
		new Menu(this, u);

	}

}
