package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.Kickstarter;
import kickstarter.ui.iUserInterface;
import org.junit.Ignore;
import org.junit.Test;

public class FakeConsole {
	Kickstarter kickstarter;
	public iUserInterface ui;

	public FakeConsole() {
		kickstarter = new Kickstarter();
		ui = new TestUI();
		kickstarter.init();
		kickstarter.testUI(ui);

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
//for(int i=0;i<10000;i++){
		for (String command : commands) {
			view();
			put(command);
		}
//}
		view();
	}

	void put(String command) {
		System.out.println("_________   " + command + "  _________");
		kickstarter.controller.updateStateOfModel(command);
	}

	void view() {
		kickstarter.controller.showPage();
	}

}
