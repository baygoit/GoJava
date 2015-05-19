package kickstarter.storages;

import static org.junit.Assert.*;
import kickstarter.engine.Category;
import kickstarter.engine.Data;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;

import org.junit.Test;

public class UniversalStorageTest {

	@Test
	public void shouldZeroSize_whenClearStorage() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		assertEquals(0, storage.size());
		assertTrue(storage.empty());
	}

	@Test
	public void shouldCorrectValue_whenAddNewElemetnts() {
		Quote quote = new Quote("Quote");
		Category category = new Category("name");
		Project project = new Project("name", "description", category, 1000, 100);
		
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.add(quote);
		assertEquals(1, storage.size());
		storage.add(category);
		assertEquals(2, storage.size());
		storage.add(project);
		assertEquals(3, storage.size());
		assertFalse(storage.empty());
		
		assertEquals(quote, storage.get(0));
		assertEquals(category, storage.get(1));
		assertEquals(project, storage.get(2));
	}

	@Test
	public void shouldCorrectId_whenAddNewElemetnts() {
		Quote quote1 = new Quote("Quote1");
		Quote quote2 = new Quote("Quote2");
		Quote quote3 = new Quote("Quote3");
		
		UniversalStorage<Quote> storage = new UniversalStorage<Quote>();
		storage.add(quote1);
		storage.add(quote2);
		storage.add(quote3);
		
		assertEquals(quote1, storage.getById(quote1.getId()));
		assertEquals(quote2, storage.getById(quote2.getId()));
		assertEquals(quote3, storage.getById(quote3.getId()));
	}
	
	@Test
	public void shouldCorrectAddSize_whenAddALotElemetnts() {
		UniversalStorage<Quote> storage = new UniversalStorage<Quote>();
		
		for (int i = 0; i < 1000; i++) {
			storage.add(new Quote("Quote"));
		}
		assertEquals(1000, storage.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullAdd() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.add(null);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldException_whenGetFromEmptyStorage() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.get(0);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldException_whenGetByErrorIndex() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.add(new Quote("Quote1"));
		storage.get(1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldException_whenGetByIdFromEmptyStorage() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.getById(0);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldException_whenGetByErrorId() {
		UniversalStorage<Data> storage = new UniversalStorage<Data>();
		storage.add(new Quote("Quote1"));
		storage.getById(-1);
	}
}
