package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.QuoteManager;


public class KickstarterRun {
	public static void main(String[] args) {				
		QuoteManager quoteManager = new QuoteManager();
		CategoryManager categoryManager = new CategoryManager();

		Kickstarter kickstarter = new Kickstarter(categoryManager, quoteManager);
		kickstarter.run();
		kickstarter.shutdown();
	}
}
