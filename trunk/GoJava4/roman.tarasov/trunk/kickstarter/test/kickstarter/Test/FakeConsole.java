package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kickstarter.Kickstarter;
import kickstarter.entities.Category;


import kickstarter.ui.iUserInterface;

import org.junit.Ignore;
import org.junit.Test;

public class FakeConsole {
	Kickstarter kickstarter;
	public iUserInterface ui;

	public FakeConsole() {
		kickstarter = new Kickstarter();
		ui = new TestUI();
		kickstarter.testUI(ui);

	}

	// @Ignore
	@Test
	public void test_all_categories_and_projects() {

		String[] commands = new String[] { "5", "23", "c", "a:my", "c","a:a","c",
				"a:my","c", "a:a","c", "a:my", "c","a:a","c", "a:my","c", "a:a","c", "a:my","c", "a:a","c",
				"a:my","c", "a:a", "c","a:my","c", "a:a", "c","a:my","c", "a:a", "c", "d:1:2", "p",
				"p", "4", "8", "null", "p", "p", "null", "null", "p", "p", "5","23","c","d:k","p","d:1:100","p","p","p","p","n","p"};
		for (String command : commands) {
			view();
			put(command);
		}
		view();
	}

	@Ignore
	@Test
	public void test_quotes_resize() {
		for (int number = 0; number < 30; number++) {
			// kickstarter.testLoadQuote(Integer.toString(number));
		}
	}

	@Ignore
	@Test
	public void test_error_deleteComment() {
		
	}


@Ignore
	@Test
	public void test_doCommandForCategoriesPage_exception() {
		view();
		put("null");
		view();
		put("p");

	}

	 @Ignore
	@Test
	public void test_doCommandForProjectsPage_exception() {
		view();
		put("5");

		view();
		put("null");

		view();
		put("p");
	}

	 @Ignore
	@Test
	public void test_doCommandForDetailedProjectPage_exception() {
		view();
		put("5");

		view();
		put("23");

		view();
		put("null");

		view();
		put("null");

		view();
		put("p");
	}

	@Ignore
	@Test
	public void test_exit_from_kickstarter() {
		put("e");
	}
	@Test
	public void verify_names_of_added_categories() {
		List<Category> categories = new ArrayList<Category>();
		// when
		categories.add(new Category("name1"));
		categories.add(new Category("name2"));
		categories.add(new Category("name3"));
		categories.add(new Category("name4"));
		categories.add(new Category("name5"));
		categories.add(new Category("name6"));
		categories.add(new Category("name7"));
		categories.add(new Category("name8"));
		categories.add(new Category("name9"));
		categories.add(new Category("name10"));
		categories.add(new Category("name11"));
		categories.add(new Category("name12"));

		// then
		assertEquals("name1", categories.get(0).name);
		assertEquals("name2", categories.get(1).name);
		assertEquals("name3", categories.get(2).name);
		assertEquals("name4", categories.get(3).name);
		assertEquals("name5", categories.get(4).name);
		assertEquals("name6", categories.get(5).name);
		assertEquals("name7", categories.get(6).name);
		assertEquals("name8", categories.get(7).name);
		assertEquals("name9", categories.get(8).name);
		assertEquals("name10", categories.get(9).name);
		assertEquals("name11", categories.get(10).name);
		assertEquals("name12", categories.get(11).name);
	}

	@Test
	public void verify_null_values() {
		List<Category> categories = new ArrayList<Category>();

		assertNull(categories.get(0));
		assertNull(categories.get(1));
		assertEquals(categories.size(), 0);
	}


	void put(String command) {
		System.out.println("_________   "+command+"  _________");
		kickstarter.controller.update(command);
	}

	void view() {
		kickstarter.controller.printView();
	}

}
