package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.Kickstarter;
import kickstarter.entities.Quote;
import kickstarter.ui.UserInterface;

import org.junit.Ignore;
import org.junit.Test;

public class FakeConsole {
	Kickstarter kickstarter;
	UserInterface ui;

	public FakeConsole() {
		kickstarter = new Kickstarter();
		ui = new TestUI();
		kickstarter.testUI(ui);
		kickstarter.load();
	}

	// @Ignore
	@Test
	public void test_all_categories_and_projects() {

		String[] commands = new String[] { "5", "23", "c", "5", "4", "c", "4",
				"8", "c" };
		for (String command : commands) {
			view();
			put(command);
		}
	}

	 @Ignore
	@Test
	public void test_quotes_resize() {
		for (int number = 0; number < 30; number++) {
		//	kickstarter.testLoadQuote(Integer.toString(number));
		}
	}

	 @Ignore
	@Test
	public void test_comments_resize() {
//		kickstarter.testLoadComments();
	}

	// @Ignore
	@Test
	public void test_doCommandForProjectsPage() {
		view();
		put("5");
		view();
		put("c");
	}

	@Test
	public void test_doCommandForCategoriesPage_exception() {
		view();
		put("null");
		view();
		put("p");
		

	}

	//@Ignore
	@Test
	public void test_doCommandForProjectsPage_exception() {
		view();
		put("5");
		
		view();
		put("null");
		
		view();
		put("p");
	}

	//@Ignore
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

	void put(String command) {
		kickstarter.controller.executeCommand(command);
	}

	void view() {
		kickstarter.controller.printView();
	}

}
