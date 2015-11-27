package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.FaqDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterMemory extends AbstractKickstarter{

	public KickstarterMemory() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoryDaoMemoryImpl();
		quotes = new QuoteDaoMemoryImpl();
		payments = new PaymentDaoMemoryImpl();
		projects = new ProjectDaoMemoryImpl();
		faqs = new FaqDaoMemoryImpl();
	}
}
