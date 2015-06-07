package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.Runner;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.ui.iUserInterface;

import org.junit.Test;

public class test_user_service {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;
	iController iC;

	public test_user_service() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);
		controller = runner.kickstarter.controller;
		imodel = runner.kickstarter.getModel();
		iview = runner.kickstarter.getView();
		iC = controller;

	}
	@Test
	public void test() {
		String message;
		controller.showPage();
		message="d";
		controller.updateStateOfModel(message);
		controller.showPage();
		
		message="c";
		controller.updateStateOfModel(message);
		controller.showPage();
		
		message="d";
		controller.updateStateOfModel(message);
		controller.showPage();
		
		message="d";
		controller.updateStateOfModel(message);
		controller.showPage();
		
		message="u";
		controller.updateStateOfModel(message);
		controller.showPage();
		
		message="user:guest";
		controller.updateStateOfModel(message);
		controller.showPage();
	}

}
