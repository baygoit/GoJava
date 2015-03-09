package ua.com.goit.gojava2.vova.kickstarter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.Connection;

import org.junit.Test;

import ua.com.goit.gojava2.vova.kickstarter.model.Quotes;
import ua.com.goit.gojava2.vova.kickstarter.model.QuotesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.presenter.ConnectToDB;

public class QuoteIsNotEmpty {

	ConnectToDB connectToDB = new ConnectToDB();
	Connection connection = connectToDB.createStatement();
	Quotes quote = new QuotesFromDB(connection);
	
	@Test
	public void shouldLengthMoreZero_expectedLengthZero() throws FileNotFoundException {
		String rezult = quote.getQuote();
		assertFalse(rezult.length() == 0); 
	 }
	
	@Test
	public void shouldNotNull_expectedNull() throws FileNotFoundException {
		String rezult = quote.getQuote();
		assertFalse(rezult == null); 
	 }
	
	@Test
	public void shouldNotisEmpty_expectedEmpty() throws FileNotFoundException {
		String rezult = quote.getQuote();
		assertFalse(rezult.isEmpty()); 
	 }
	
}