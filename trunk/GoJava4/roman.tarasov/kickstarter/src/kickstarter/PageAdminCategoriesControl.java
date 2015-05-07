package kickstarter;

public class PageAdminCategoriesControl extends Page {
	CategoryList list;

	PageAdminCategoriesControl(CategoryList list) {

		this.list = list;

	}

	void printCategories() {
		list.printList(ui);

	}

	@Override
	public Page getNextPage() {
		
		ui.display("________________________");
		ui.display("|  Categories Control  |");
		ui.display("|______________________|");
		printCategories();
		ui.display("------------------------");
		ui.display("Commands:");

		while (true) {
			ui.display("r- rename  , d- delete , e- exit to Login Page");
			String stringFromUI = ui.inputString();
			//TODO
			if (stringFromUI.equals("e")) {
				ui.display("exit");

				return pages[PAGE_LOGIN];
			}
			if (stringFromUI.equals("r")) {
				ui.display("rename");
			}
			if (stringFromUI.equals("d")) {
				ui.display("delete");
			}
			ui.display("input correct command, please");
		}

	}
}
