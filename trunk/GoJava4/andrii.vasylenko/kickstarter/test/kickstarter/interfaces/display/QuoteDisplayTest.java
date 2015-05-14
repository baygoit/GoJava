package kickstarter.interfaces.display;

import static org.junit.Assert.*;
import kickstarter.engine.Quote;

import org.junit.Test;

public class QuoteDisplayTest {

	@Test
	public void shouldDescriptionWithName_whenGetDescription() {
		Quote quote = new Quote("Interesting quote");
		Display<Quote> display = new QuoteDisplay();
		
		String result = display.getDescription(quote);

		assertEquals(result, display.getDetailedDescription(quote)); 
		
		assertEquals("Quote: Interesting quote", result); 
	}

}
