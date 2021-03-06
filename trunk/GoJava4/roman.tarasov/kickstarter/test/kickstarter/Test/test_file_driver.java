package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.Runner;
import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.ui.iUserInterface;

import org.junit.Assert;
import org.junit.Test;

public class test_file_driver extends Assert {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;

	public test_file_driver() {
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

	}

}
