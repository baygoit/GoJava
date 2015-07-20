package goit.nz.kickstartermvc.test;

import goit.nz.kickstartermvc.Bootstrap;

import org.junit.Test;
import static org.junit.Assert.*;

public class BootstrapTest {

	@Test
	public void whenPrepareDataWhenStorageFilledWithData() {
		MockStorage storage = new MockStorage();
		Bootstrap.prepareData(storage);

		assertTrue("Quotes were not loaded", storage.getQuotes().size() > 0);
		assertTrue("Categories were not loaded",
				storage.getCategories().size() > 0);
		String testCategoryName = storage.getCategories().get(3).getName();
		assertTrue("Projects were not loaded",
				storage.getProjects(testCategoryName).size() > 0);
	}

}
