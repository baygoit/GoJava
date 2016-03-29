package ua.nenya.dao.memory;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuoteDaoMemoryImplTest {
	
	class FakeRandom extends Random {

		private static final long serialVersionUID = 1L;
		private List<Integer> numbers;

		public FakeRandom(Integer... integers) {
			this.numbers = new LinkedList<>(Arrays.asList(integers));
		}

		@Override
		public int nextInt(int i) {

			return numbers.remove(0);
		}
	}

	@Test
	public void getRandomQuoteTest() {
		QuoteDaoMemoryImpl qdmi = new QuoteDaoMemoryImpl();
		qdmi.setFile(new File("src/test/resources/quotes.json"));
		qdmi.initQuotes();
		assertEquals("Healthy curiosity is a great key in innovation.",
				qdmi.getRandomQuote(new FakeRandom(0)).getName());
		assertEquals(
				"Everyone here has the sense that right now is one of those moments when we are influencing the future.",
				qdmi.getRandomQuote(new FakeRandom(1)).getName());
		assertEquals("Great things in business are never done by one person. They're done by a team of people.",
				qdmi.getRandomQuote(new FakeRandom(2)).getName());
	}

}
