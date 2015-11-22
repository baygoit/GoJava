package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.storage_in_memory.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.FaqStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterMemoryStorage extends AbstractKickstarter{

	public KickstarterMemoryStorage() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoriesStorage();
		quotes = new QuotesStorage();
		payments = new PaymentStorage();
		projects = new ProjectsStorage();
		faqs = new FaqStorage();
	}
}
