package test;

import static org.junit.Assert.assertFalse;
import java.io.FileNotFoundException;
import mainkick.Quotes;
import org.junit.Test;

public class ListOfCategories {
	@Test 
	public void shouldLengthMoreZero_expectedLengthZero() throws FileNotFoundException {
		Quotes quote = new Quotes();
		String rezult = quote.getQuote();
		assertFalse(rezult.length() == 0); 
	 }
}
