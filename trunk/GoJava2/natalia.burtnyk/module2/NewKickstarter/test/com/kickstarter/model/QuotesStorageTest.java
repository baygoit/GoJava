package com.kickstarter.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuotesStorageTest {

	private QuotesStorage quoteStorage;

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
	public void shouldGenerateNewQuote() {
		// given
		QuotesStorage quotesStorage = new QuotesStorage(new FakeRandom(0, 1));

		// when
		String quote = quotesStorage.getRundomQuote();

		// then
		assertEquals("Lost time is never found again.\"", quote);

		// when
		String quote2 = quotesStorage.getRundomQuote();

		// then
		assertEquals(
				"The future belongs to those, who believe of their dreams.\"",
				quote2);
	}
}
