package kickstarter.mvc;

import kickstarter.pages.Page;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void printView() {
		view.print();
	}

	public void executeCommand(String command) {
		model.execute(command);
	}

	public void setPage(int pageIndex) {
		model.setPage(pageIndex);
	}

	public void addPage(Page page) {
		model.add(page);
	}
}
