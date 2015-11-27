package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public class QuoteMemoryDAOTest {
	
	private QuoteDaoMemoryImpl qouteMemory = new QuoteDaoMemoryImpl();
	private Quote quote = new Quote();

	@Test
	public void testQuoteMemoryDAO() {
		assertThat(qouteMemory.getSize(), is(3));
	}

	@Test
	public void testAdd() {
		qouteMemory.add(quote);
		assertThat(qouteMemory.getSize(), is(4));
	}

	@Test
	public void testRemove() {
		qouteMemory.add(quote);
		assertThat(qouteMemory.getSize(), is(4));
		
		qouteMemory.remove(quote);
		assertThat(qouteMemory.getSize(), is(3));
	}

	@Test
	public void testGetSize() {
		assertThat(qouteMemory.getSize(), is(3));
	}

}