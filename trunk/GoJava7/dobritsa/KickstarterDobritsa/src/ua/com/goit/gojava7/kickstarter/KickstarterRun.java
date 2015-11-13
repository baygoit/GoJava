package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.QuoteManager;


public class KickstarterRun {
	public static void main(String[] args) {		
		ConsoleInspector consoleInspector = new ConsoleInspector();
		QuoteManager quoteManager = new QuoteManager();
		CategoryManager categoryManager = new CategoryManager();

		Kickstarter kickstarter = new Kickstarter(consoleInspector, categoryManager, quoteManager);
		kickstarter.run();
		kickstarter.shutdown();
	}
}
