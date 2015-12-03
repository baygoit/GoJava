package ua.com.goit.gojava7.kickstarter;



import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.controller.console.Kickstarter;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterRunner {
	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;
	private DaoProvider daoProvider;
	private DataSource dataSource;
	private CategoryDao categoryDao;
	private ProjectDao projectDao;
	private QuoteDao quoteDao;
	private FaqDao faqDao;
	private PaymentDao paymentDao;
	private Kickstarter kickstarter;

	public static void main(String[] args) throws IOException {		
		new KickstarterRunner().runProgram();
	}

	private void runProgram() {
		dataSource = DataSource.MYSQL;
		init(dataSource);
	}

	public void init(DataSource dataSource) {
		daoProvider = new DaoProvider(dataSource);
		daoProvider.open();
		consolePrinter = new ConsolePrinter();
		consoleScanner = new ConsoleScanner();
		categoryDao = daoProvider.getCategoryDao();
		projectDao = daoProvider.getProjectDao();
		quoteDao = daoProvider.getQuoteDao();
		faqDao = daoProvider.getFaqDao();
		paymentDao = daoProvider.getPaymentDao();

		kickstarter = new Kickstarter(consolePrinter, consoleScanner,
				categoryDao, projectDao, quoteDao, paymentDao, faqDao);
		kickstarter.start();
		kickstarter.stop();
		daoProvider.close();
	}
}
