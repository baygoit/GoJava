package myRealization;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuoteTest {
	public class FakeRandom extends Random {
		@Override
		public int nextInt(int some){
			return 0;
		}
	}
	QuoteGenerator quote = new QuoteGenerator(new ConsoleOutput(), new FakeRandom());
	
	@Test
	public void shouldReturnQuote_whenItSended(){
		quote.printQuote();
		assertEquals("If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter", quote.generateQuote());
	}
}
