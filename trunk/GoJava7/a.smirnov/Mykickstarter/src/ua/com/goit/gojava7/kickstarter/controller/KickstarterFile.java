package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.FaqFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.PaymentFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileDAO;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterFile extends AbstractKickstarter {

	public KickstarterFile() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoryFileDAO();
		quotes = new QuoteFileDAO();
		payments = new PaymentFileDAO();
		projects = new ProjectFileDAO();
		faqs = new FaqFileDAO();
	}
}