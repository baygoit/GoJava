package kickstarter;

import kickstarter.dao.databaseServices.iDatabaseService;
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
	private iDatabaseService dbService;

	private volatile static Kickstarter uniqueInstance;

	private Kickstarter() {
	}

	public static Kickstarter getInstance() {
		if (uniqueInstance == null) {
			synchronized (Kickstarter.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Kickstarter();
				}
			}
		}
		return uniqueInstance;
	}

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

	public Model getModel() {
		return model;
	}

	public View getView() {
		return view;
	}

	public void setUI(iUserInterface ui) {
		this.ui = ui;
	}

	public void setDatabaseService(iDatabaseService dbService) {
		this.dbService = dbService;
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
