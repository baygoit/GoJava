package kickstarter;

import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.mvc.interfaces.iController;
import kickstarter.ui.iUserInterface;

public class Kickstarter {

	private iUserInterface ui;
	private View view;
	private Model model;
	public Controller controller;
	public iController icontroller;

	public void testUI(iUserInterface ui) {
		this.ui = ui;
		view.setUserInterface(ui);
	}

	void setController(Controller setController) {
		this.controller = setController;
	}

	void setView(View setView) {
		this.view = setView;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setUI(iUserInterface ui) {
		this.ui = ui;
	}

	void run() {
		String message = null;

		while (true) {
			controller.showPage();
			message = ui.inputString();
			controller.updateStateOfModel(message);
		}
	}
}
