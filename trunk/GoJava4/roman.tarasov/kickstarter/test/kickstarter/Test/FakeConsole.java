package kickstarter.Test;

import kickstarter.Runner;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.IndexOfPage;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;

import kickstarter.ui.iUserInterface;

import org.junit.Assert;

import org.junit.Test;

public class FakeConsole extends Assert {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;



	public FakeConsole() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);
		controller = runner.kickstarter.controller;
		imodel = runner.kickstarter.getModel();
		iview = runner.kickstarter.getView();

	}
	void put(String command) {
		System.out.println("_________   " + command + "  _________");

		runner.kickstarter.controller.updateStateOfModel(command);
	}

	void view() {
		runner.kickstarter.controller.showPage();
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
				"bankir:777:3", "null", "p", "p", "p", "p", "r", "p", "p", "d",
				"p", "r", "d", "r", "i", "r", "c" };

		for (String command : commands) {
			view();
			put(command);
		}
		view();

	}

	// @Ignore
	@Test
	public void test_categories_model() {

		imodel.setPage(0);
		iview.getViewValues().setIntCategories(new int[] { 1, 2 });
		iview.getViewValues().setStrCategories(new String[] { "1", "2" });
		controller.updateStateOfModel("1");
		int page = imodel.getCurrentPage();
		assertEquals(IndexOfPage.PROJECTS.ordinal(), page);

		imodel.setPage(0);
		controller.updateStateOfModel("2");
		page = imodel.getCurrentPage();
		assertEquals(IndexOfPage.PROJECTS.ordinal(), page);

		imodel.setPage(0);
		controller.updateStateOfModel("3");
		page = imodel.getCurrentPage();
		assertEquals(IndexOfPage.ERROR_PAGE.ordinal(), page);

		imodel.setPage(0);
		iview.getViewValues().setStrCategories(null);
		controller.updateStateOfModel("1");
		page = imodel.getCurrentPage();
		assertEquals(IndexOfPage.ERROR_PAGE.ordinal(), page);

	}

}
