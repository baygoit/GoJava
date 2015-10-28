package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;

import kickstarter.Runner;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.ui.iUserInterface;

import org.junit.Test;

public class test_dao {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;

	public test_dao() {
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
