package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuoteGeneratorTest {

	class FakeRandom extends Random {
		private List<Integer> numbers;

		public FakeRandom(Integer... numbers) {
			this.numbers = new LinkedList(Arrays.asList(numbers));  
		}
		
		@Override
		public int nextInt(int i) { 
			return numbers.remove(0);
		}
	}
	
	@Test
	public void shouldGenerateNewQUote() {
		// given
		QuoteGenerator generator = new QuoteGenerator(new FakeRandom(0, 1)); 
		
		// when 
		String quote = generator.nextQuote();
		
		// then
		assertEquals("Каждый человек - творческая личность (с) Саня", quote);
		
		// when 
		String quote2 = generator.nextQuote();
		
		// then
		assertEquals("У тебя все получится - главное начать (с) Саня", quote2);
	} 
}
