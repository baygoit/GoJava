package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.ui.UserInterface;

public class View {
	Model model;
	Page page;
	private UserInterface ui;

	public View(Model model, UserInterface ui) {
		this.model = model;
		this.ui = ui;
	}

	public void print() {
		page = model.getPage();
		int index = model.getPageIndex();
		int[] parameter = model.getParameterForPrint();
		if (parameter != null) {
			page.print(parameter);

		} else {
			page.print();
		}

		if (page.getOptions() != null) {
			model.setOptions(page.getOptions());
		} else {
			model.setOptions(null);
		}
		String[] stringCommands=model.getStringCommands();
		
		ui.display(stringCommands[index]);
	}
}
