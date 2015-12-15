package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;

public class KickstarterRunner {

	public static void main(String[] args) throws IOException, SQLException {
		
		String getenv = System.getProperty("start");
		
		ConsoleReader consoleReader = new ConsoleReader();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		Initializator initialization = new Initializator(getenv);

		AbstractQuoteStorage quoteStorage = initialization.getQuoteStorage();
		AbstractCategoryStorage categoryStorage = initialization.getCategoryStorage();
		AbstractProjectStorage projectStorage = initialization.getProjectStorage();
		AbstractPaymentStorage paymentStorage = initialization.getPaymentStorage();
		AbstractQuestionStorage questionStorage = initialization.getQuestionStorage();

		Kickstarter kickstarter = new Kickstarter(consoleReader, consolePrinter,
				quoteStorage, categoryStorage, projectStorage, paymentStorage, questionStorage);
		kickstarter.start();
		kickstarter.stop();
		
	}
}
