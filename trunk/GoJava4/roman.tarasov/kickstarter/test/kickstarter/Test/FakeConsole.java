package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;




import kickstarter.Runner;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.Category;
import kickstarter.ui.iUserInterface;

import org.junit.Ignore;
import org.junit.Test;

public class FakeConsole {
	Runner runner;
	public iUserInterface ui;
	void put(String command) {
		System.out.println("_________   " + command + "  _________");
		
			runner.kickstarter.controller.updateStateOfModel(command);

	}

	void view() {
		runner.kickstarter.controller.showPage();
	}
	public FakeConsole() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);

	}

	@Test
	public void test_all_categories_and_projects() {

		String[] commands = new String[] { "5", "23", "c", "a:my", "c", "a:a",
				"c", "a:my", "c", "a:a", "c", "a:my", "c", "a:a", "c", "a:my",
				"c", "a:a", "c", "a:my", "c", "a:a", "c", "a:my", "c", "a:a",
				"c", "a:my", "c", "a:a", "c", "a:my", "c", "a:a", "c", "d:1:2",
				"p", "p", "4", "8", "null", "p", "p", "null", "null", "p", "p",
				"5", "23", "c", "d:k", "p", "d:1:100", "p", "p", "p", "p", "n",
				"p", "5", "23", "i", "1", "bankir:777", "p", "d",
				"bankir:777:500", "p", "d", "p", "d", "0", "p", "d", "p",
				"bankir:800:8", "p", "d", "bankir:777:9000", "p", "i", "p",
				"i", "999999", "p", "3", "bankir:777", "p", "i", "1", "p", "i",
				"2", "null", "p", "b800", "p", "bankir:777", "p", "d",
				"bankir:777:4449", "p", "i", "3", "bankir:777", "p", "d",
				"bankir:777:3", "null", "p" };

		for (String command : commands) {
			view();
			put(command);
		}

		view();
	}

}
