package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.FaqMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteMemoryDAO;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterMemory extends AbstractKickstarter{

	public KickstarterMemory() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoryMemoryDAO();
		quotes = new QuoteMemoryDAO();
		payments = new PaymentMemoryDAO();
		projects = new ProjectMemoryDAO();
		faqs = new FaqMemoryDAO();
	}
}
