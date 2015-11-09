package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.Quote;

public class TestQuote {

	@Test
	public void test() {
		Quote qu = new Quote();
		String str = qu.getQuoteRandom();
		assertEquals(str, qu.getQuoteRandom());
	}

}
