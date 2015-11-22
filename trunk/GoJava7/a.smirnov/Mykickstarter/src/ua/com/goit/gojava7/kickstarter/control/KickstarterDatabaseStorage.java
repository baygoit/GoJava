package ua.com.goit.gojava7.kickstarter.control;

import ua.com.goit.gojava7.kickstarter.storage_in_database.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_database.FaqStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_database.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_database.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_database.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterDatabaseStorage extends AbstractKickstarter {

	public KickstarterDatabaseStorage() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoriesStorage();
		quotes = new QuotesStorage();
		payments = new PaymentStorage();
		projects = new ProjectsStorage();
		faqs = new FaqStorage();
	}
}
