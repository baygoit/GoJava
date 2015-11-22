package ua.com.goit.gojava7.kickstarter.control;

import ua.com.goit.gojava7.kickstarter.storage_in_files.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_files.FaqStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_files.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_files.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_files.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterFilesStorage extends AbstractKickstarter {

	public KickstarterFilesStorage() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoriesStorage();
		quotes = new QuotesStorage();
		payments = new PaymentStorage();
		projects = new ProjectsStorage();
		faqs = new FaqStorage();
	}
}