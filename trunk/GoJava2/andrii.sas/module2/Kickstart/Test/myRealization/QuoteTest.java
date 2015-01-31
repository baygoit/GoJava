package myRealization;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuoteTest {
	QuoteGenerator quote = new QuoteGenerator(new StubOutput(), new Random());
	@Test
	public void shouldReturnQuote_whenItSended(){
		quote.printQuote();
		assertEquals("If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter", quote.getQuote(0));
	}
}
