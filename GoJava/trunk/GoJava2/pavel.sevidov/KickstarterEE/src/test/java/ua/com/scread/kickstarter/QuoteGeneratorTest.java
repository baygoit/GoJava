package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import ua.com.scread.kickstarter.dao.QuoteDAO;

public class QuoteGeneratorTest {

	public class FakeRandom extends Random {
		private List<Integer> numbers;
		
		public FakeRandom(Integer... numbers) {
			this.numbers = new LinkedList(Arrays.asList(numbers));
		}
		
		@Override
		public int nextInt(int i) {
			return numbers.remove(0);
		}
	}
//	
//	@Test
//	public void shouldBeQuote_whenGetQuote() {
//		QuoteDAO quoteGenerator = new QuoteDAO(new FakeRandom(1, 2, 3, 4));
//		
//		String quote = quoteGenerator.getQuote();
//		
//		assertEquals("Look at successful and unsuccessful campaigns (c) Kickstart", quote);
//		
//		String quote2 = quoteGenerator.getQuote();
//		
//		assertEquals("Give good rewards (c) Kickstart", quote2);
//	}
}
