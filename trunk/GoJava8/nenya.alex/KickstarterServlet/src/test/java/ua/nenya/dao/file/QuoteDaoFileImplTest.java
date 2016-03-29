package ua.nenya.dao.file;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuoteDaoFileImplTest {

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
		QuoteDaoFileImpl qdfi = new QuoteDaoFileImpl();
		qdfi.setFileName("src/test/resources/quotes.json");
		qdfi.initQuotes();
		assertEquals("Healthy curiosity is a great key in innovation.",
				qdfi.getRandomQuote(new FakeRandom(0)).getName());
		assertEquals(
				"Everyone here has the sense that right now is one of those moments when we are influencing the future.",
				qdfi.getRandomQuote(new FakeRandom(1)).getName());
		assertEquals("Great things in business are never done by one person. They're done by a team of people.",
				qdfi.getRandomQuote(new FakeRandom(2)).getName());
	}
}
