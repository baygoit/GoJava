package ua.com.goit.gojava7.kickstarter.DAO;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public abstract class AbstractQuoteStorage {
	
	public final String DBPASSWORD = "admin";
	public final String DBLOGIN = "admin";
	public final String DATABASE_URL = "jdbc:mysql://localhost:3306/kickstarter";
	
	public abstract Quote getRandomQuote();
	
}
