package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.model.MainPageModel;
import goit.nz.kickstartermvc.output.Output;

public class MainPageView {

	private Output output;

	public MainPageView(Output output) {
		this.output = output;
	}

	public void printHelloMsg(MainPageModel model) {
		output.write(model.getRandomQuote());
	}

	public void printCategories(MainPageModel model) {
		int modelSize = model.size();
		if (modelSize > 0) {
			printTitle();
			int index = 1;
			for (Category category : model.getCategories()) {
				output.write(String.format("(%d). %s", index++,
						category.getName()));
			}
		} else {
			showMsg("Categories are not found!");
		}
		printOptions(modelSize);
	}

	public void showMsg(String msg) {
		output.write("");
		output.write(msg);
	}

	private void printTitle() {
		output.write("");
		output.write("List of categories:");
		output.write("-------------------");
	}

	private void printOptions(int modelSize) {
		output.write("");
		if (modelSize > 0) {
			output.write(String.format(
					"Choose your option [1 - %d] (0 - exit)", modelSize));
		} else {
			output.write("(0 - exit)");
		}
	}
}
