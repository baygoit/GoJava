package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Menu;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.model.UserSettings;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class UserManager {
	private ConsolePrinter consolePrinter;
	public ConsolePrinter getConsolePrinter() {
		return consolePrinter;
	}

	public void setConsolePrinter(ConsolePrinter consolePrinter) {
		this.consolePrinter = consolePrinter;
	}

	private CategoryStorage categoryStorage;
	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
	}

	private ConsoleScanner consoleScanner;
	public ConsoleScanner getConsoleScanner() {
		return consoleScanner;
	}

	public void setConsoleScanner(ConsoleScanner consoleScanner) {
		this.consoleScanner = consoleScanner;
	}

	private Kickstarter kickStarter;

	public UserManager(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner, CategoryStorage categoryStorage,
			Kickstarter kickstarter) {
		this.consolePrinter = consolePrinter;
		this.categoryStorage = categoryStorage;
		this.consoleScanner = consoleScanner;
		this.kickStarter = kickstarter;
	}

	public void generateMenu(User u) {
		new Menu(this,u);
	
	}



	public Kickstarter getKickStarter() {
		return kickStarter;
	}

	public void setKickStarter(Kickstarter kickStarter) {
		this.kickStarter = kickStarter;
	}
}
