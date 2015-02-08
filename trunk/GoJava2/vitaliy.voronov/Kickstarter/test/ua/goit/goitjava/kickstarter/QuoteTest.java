package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void shoudWithdrawQuote() {
		Quote q = new Quote();
		assertEquals("Journey of a thousand miles \nbegins with a single step\n\t\t\tLao Tzu", q.getLaoTzu());
	}

}
