package ua.com.goit.gojava2.vova.kickstarter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import ua.com.goit.gojava2.vova.kickstarter.model.Quotes;
import ua.com.goit.gojava2.vova.kickstarter.model.QuotesFromFile;

public class QuoteIsNotEmpty {

	Quotes quote = new QuotesFromFile();
	
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