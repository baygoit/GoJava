package kickstarter.storages;

import static org.junit.Assert.*;
import kickstarter.engine.Quote;

import org.junit.Test;

public class QuotesStorageTest {

	@Test
	public void shouldZeroSize_whenClearStorage() {
		QuotesStorage storage = new QuotesStorage();
		assertEquals(0, storage.size());
		assertTrue(storage.isEmpty());
	}
	
	/*@Test
	public void shouldCorrectValue_whenAddNewElemetnts() {
		Quote quote1 = new Quote("Quote1");
		Quote quote2 = new Quote("Quote2");
		Quote quote3 = new Quote("Quote3");
		
		QuotesStorage storage = new QuotesStorage();
		storage.add(quote1);
		assertEquals(1, storage.size());
		storage.add(quote2);
		assertEquals(2, storage.size());
		storage.add(quote3);
		assertEquals(3, storage.size());
		assertFalse(storage.empty());
		
		assertEquals(quote1, storage.get(0));
		assertEquals(quote2, storage.get(1));
		assertEquals(quote3, storage.get(2));
		
		assertEquals(quote1, storage.getById(quote1.getId()));
		assertEquals(quote2, storage.getById(quote2.getId()));
		assertEquals(quote3, storage.getById(quote3.getId()));
		
		assertTrue(storage.getRandom().getId() > 0);
	}	

	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldException_whenGetRandomFromEmptyStorage() {
		QuotesStorage storage = new QuotesStorage();
		storage.getRandom();
	}*/
	
}
