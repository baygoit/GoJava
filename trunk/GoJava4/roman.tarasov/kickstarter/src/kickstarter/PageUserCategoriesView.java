package kickstarter;

public class PageUserCategoriesView extends Page {
	CategoryList list;
	ProjectList projects;

	PageUserCategoriesView(CategoryList list, ProjectList projects) {
		this.list = list;
		this.projects = projects;
	}

	int[] printCategories() {
		return list.printList(ui);
	}

	@Override
	public Page getNextPage() {
		ui.display("=========================");
		ui.display("|     Categories        |");
		ui.display("=========================");
		int[] options = printCategories();
		ui.display("------------------------");
		ui.display("Select Category:");

		while (true) {
			ui.display(" e- exit to Login ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return pages[PAGE_LOGIN];
			}
			try {
				int parsed = Integer.parseInt(stringFromUI);
				for (int index = 0; index < options.length; index++) {
					if (parsed == options[index]) {
						categoryToUserProjectsView = list.get(index);
						projects.setTargetCategory(categoryToUserProjectsView);
						return pages[PAGE_USER_PROJECTS_VIEW];
					}
				}
				throw new IndexOutOfBoundsException();

			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				ui.display("input correct command, please");
			}
		}
	}
}