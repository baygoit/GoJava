package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.dao.database.CategoryDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.database.FaqDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.database.PaymentDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.database.ProjectDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.database.QuoteDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterDatabase extends AbstractKickstarter {

	public KickstarterDatabase() {
		consoleScanner = new ConsoleScanner();
		consolePrinter = new ConsolePrinter();
		categories = new CategoryDaoMysqlImpl();
		quotes = new QuoteDaoMysqlImpl();
		payments = new PaymentDaoMysqlImpl();
		projects = new ProjectDaoMysqlImpl();
		faqs = new FaqDaoMysqlImpl();
	}
}
