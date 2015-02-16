package mainkick;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import model.Quotes;

import org.junit.Test;

public class QuoteIsNotEmpty {
	
	@Test
	public void shouldLengthMoreZero_expectedLengthZero() throws FileNotFoundException {
		Quotes quote = new Quotes();
		String rezult = quote.getQuote();
		assertFalse(rezult.length() == 0); 
	 }
	
	@Test
	public void shouldNotNull_expectedNull() throws FileNotFoundException {
		Quotes quote = new Quotes();
		String rezult = quote.getQuote();
		assertFalse(rezult == null); 
	 }
	
	@Test
	public void shouldNotisEmpty_expectedEmpty() throws FileNotFoundException {
		Quotes quote = new Quotes();
		String rezult = quote.getQuote();
		assertFalse(rezult.isEmpty()); 
	 }
	
}