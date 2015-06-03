package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.Runner;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.ui.iUserInterface;

import org.junit.Test;

public class test_creation_default_database {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;

	public test_creation_default_database() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);
		controller = runner.kickstarter.controller;
		imodel = runner.kickstarter.getModel();
		iview = runner.kickstarter.getView();

	}

	@Test
	public void test() {
		iDAO idao = controller.getDao();
	}
}
