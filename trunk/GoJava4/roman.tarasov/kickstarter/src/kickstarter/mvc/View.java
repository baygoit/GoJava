package kickstarter.mvc;

import kickstarter.pages.Page;

public class View {
	Model model;
	Page page;

	public View(Model model) {
		this.model = model;
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
		System.out.println(model.stringCommands[index]);
	}
}
