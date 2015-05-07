
package kickstarter;

public class PageUserCategoriesView extends Page {
	CategoryList list;
	final int PAGE_USER_PROJECTS_VIEW=3;
	PageUserCategoriesView( CategoryList list) {
		this.list = list;
	}

	void printCategories() {
		list.printList(ui);
	}
	
@Override
	public Page getNextPage() {
		ui.display("////////////////////////");
		ui.display("// Categories         //");
		ui.display("////////////////////////");
		printCategories();
		ui.display("Select Category:");

		while (true) {
			ui.display(" e- exit to Login Page");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return pages[0];
			}
			try {
				int parsed = Integer.parseInt(stringFromUI);
				categoryToProjectsView = list.get(parsed);
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				//throw new IllegalArgumentException();
				ui.display("input correct command, please");
				continue;
			}
			ui.display(categoryToProjectsView.name);
			
			
		}
	}
}