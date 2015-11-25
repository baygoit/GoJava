package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.dao.database.CategoryMysqlDAO;
import ua.com.goit.gojava7.kickstarter.dao.database.FaqMysqlDAO;
import ua.com.goit.gojava7.kickstarter.dao.database.PaymentMysqlDAO;
import ua.com.goit.gojava7.kickstarter.dao.database.ProjectMysqlDAO;
import ua.com.goit.gojava7.kickstarter.dao.database.QuoteMysqlDAO;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterDatabase extends AbstractKickstarter {

	public KickstarterDatabase() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoryMysqlDAO();
		quotes = new QuoteMysqlDAO();
		payments = new PaymentMysqlDAO();
		projects = new ProjectMysqlDAO();
		faqs = new FaqMysqlDAO();
	}
}
