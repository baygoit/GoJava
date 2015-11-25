package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

public class KickstarterRunner {

	/**
	 * args[0] is a type of data source
	 * 
	 * Supported types are memory, file and mysql. Memory by default
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource dataSource = DataSource.MEMORY;
		if (args.length != 0 && args[0] != null) {
			try {
				dataSource = DataSource.valueOf(args[0].toUpperCase());
			} catch (IllegalArgumentException e) {
				System.err.println("Type of data source " + args[0] + " if not supported. Fall back to memory");
			}
		}
		System.err.println("Using " + dataSource + " data source");

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleScanner = new ConsoleScanner();

		DaoProvider daoProvider = new DaoProvider(dataSource);
		daoProvider.open();

		QuoteDao quoteDao = daoProvider.getQuoteDao();
		CategoryDao categoryDao = daoProvider.getCategoryDao();

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteDao, categoryDao);
		kickstarter.run();
		kickstarter.shutdown();

		daoProvider.close();
	}
}
