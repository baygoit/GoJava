package kickstarter.storages;

import static org.junit.Assert.*;
import kickstarter.engine.Category;

import org.junit.Test;

public class CategoriesStorageTest {

	@Test
	public void shouldZeroSize_whenClearStorage() {
		CategoriesStorage storage = new CategoriesStorage();
		assertEquals(0, storage.size());
		assertTrue(storage.isEmpty());
	}

	@Test
	public void shouldCorrectValue_whenAddNewElemetnts() {
		Category category1 = new Category("Name1");
		Category category2 = new Category("Name2");
		Category category3 = new Category("Name3");
		
		CategoriesStorage storage = new CategoriesStorage();
		storage.add(category1);
		assertEquals(1, storage.size());
		storage.add(category2);
		assertEquals(2, storage.size());
		storage.add(category3);
		assertEquals(3, storage.size());
		assertFalse(storage.isEmpty());
		
		assertEquals(category1, storage.get(0));
		assertEquals(category2, storage.get(1));
		assertEquals(category3, storage.get(2));
		
		assertEquals(category1, storage.get(category1.getId()));
		assertEquals(category2, storage.get(category2.getId()));
		assertEquals(category3, storage.get(category3.getId()));
	}	

}
