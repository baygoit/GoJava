package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Repository.CategoryList;
import kickstarter.Repository.ProjectList;

public class Categories  {
	CategoryList list;
	ProjectList projects;
	UserInterface ui;

	public Categories(CategoryList list, 
			UserInterface ui) {
		this.list = list;
		this.ui = ui;
	}

	int[] printCategories() {
		return list.printList(ui);
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
						Category categoryToUserProjectsView = list.get(index);
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