package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Repository.Storage;

public class Categories {
	Storage<Category> categories;
	UserInterface ui;

	public Categories(Storage<Category> categories, UserInterface ui) {
		this.categories = categories;
		this.ui = ui;
	}

	public int[] printCategories() {
		int pointer = categories.length();
		int[] options = new int[pointer];
		for (int index = 0; index < pointer; index++) {

			ui.display(categories.getEntity(index).id + "- "
					+ categories.getEntity(index).name);
			options[index] = categories.getEntity(index).id;
		}
		return options;
	}

	public Category selectCategory() {
		ui.display("=========================");
		ui.display("|     Categories        |");
		ui.display("=========================");
		int[] options = printCategories();
		ui.display("------------------------");
		ui.display("Select Category:");

		while (true) {
			ui.display(" e- exit  ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("Good Bye");
				return null;
			}
			try {
				int parsed = Integer.parseInt(stringFromUI);
				for (int index = 0; index < options.length; index++) {
					if (parsed == options[index]) {
						Category categoryToUserProjectsView = categories
								.getEntity(index);
						return categoryToUserProjectsView;
					}
				}
				throw new IndexOutOfBoundsException();
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				ui.display("input correct command, please");
			}
		}
	}
}