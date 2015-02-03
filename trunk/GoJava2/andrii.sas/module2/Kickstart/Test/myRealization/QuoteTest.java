package myRealization;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuoteTest {
	Output out = new ConsoleOutput();
	QuoteGenerator quote = new QuoteGenerator(out, new Random());
	@Test
	public void shouldReturnQuote_whenItSended(){
		out.println("");
		assertEquals("If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter", quote.getQuote(0));
	}
}
