package goit.nz.kickstartermvc.test.model;

import goit.nz.kickstartermvc.model.MainPageModel;
import goit.nz.kickstartermvc.test.MockStorage;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainPageModelTest {

	@Test
	public void whenUpdateThenModelIsUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		MainPageModel model = new MainPageModel(storage);
		model.update();
		int actual = model.getCategories().size();
		int expected = 4;

		assertEquals(expected, actual);

		actual = model.size();

		assertEquals(expected, actual);
	}

	@Test
	public void whenGetCategoryThenCategoryReturned() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		MainPageModel model = new MainPageModel(storage);
		model.update();
		String actual = model.getCategory(0).getName();
		String expected = storage.getCategories().get(0).getName();

		assertEquals(expected, actual);
	}

	@Test
	public void whenGetRandomQuoteThenRandomQuoteReturned() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		MainPageModel model = new MainPageModel(storage);
		String result = model.getRandomQuote();

		assertNotNull("Random quote is null", result);
	}

}
