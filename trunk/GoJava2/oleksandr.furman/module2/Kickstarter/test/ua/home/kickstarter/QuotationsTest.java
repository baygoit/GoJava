package ua.home.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuotationsTest {

	@Test
	public void test() {

		Quotations quotations = new Quotations();
		int  quoteNumber = 1;
		String actual = quotations.nextQuote(quoteNumber);
		String expected = "Я не хочу создавать что-то для того, чтобы мне платили. Я хочу, чтобы мне платили за то, что я что-то создаю. (c) Леонард Коэн";
		assertEquals(actual, expected);
	}
}
