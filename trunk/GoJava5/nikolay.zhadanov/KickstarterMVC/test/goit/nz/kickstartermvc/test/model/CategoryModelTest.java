package goit.nz.kickstartermvc.test.model;

import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.test.MockStorage;
import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryModelTest {

	@Test
	public void whenUpdateThenModelIsUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		CategoryModel model = new CategoryModel(storage);
		model.update(storage.getCategories().get(0).getName());
		int expected = 0;
		int actual = model.size();
		assertEquals(expected, actual);

		model.update(storage.getCategories().get(3).getName());
		expected = 3;
		actual = model.size();
		assertEquals(expected, actual);
	}

	@Test
	public void whenGetProjectsThenProjectsReturned() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		CategoryModel model = new CategoryModel(storage);
		model.update(storage.getCategories().get(0).getName());
		int expected = 0;
		int actual = model.getProjects().size();
		assertEquals(expected, actual);

		model.update(storage.getCategories().get(3).getName());
		expected = 3;
		actual = model.getProjects().size();
		assertEquals(expected, actual);
	}

}
