package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public abstract class AbstractQuoteDao {

	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(Quote element);

	public abstract void remove(Quote element);
	
	public abstract int getSize();
	
	public abstract Quote getRandomQuote();
	
}
