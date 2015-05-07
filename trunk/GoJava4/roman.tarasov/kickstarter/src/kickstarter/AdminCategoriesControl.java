package kickstarter;

public class AdminCategoriesControl extends Page implements UserInterface{
	CategoryList list;


	AdminCategoriesControl( CategoryList list) {

		this.list = list;

	}

	void print(String stringToPrint) {

	}

	void printCategories() {
		list.printList(ui);

	}
	
@Override
	public Page getNextPage() {
		ui.display("////////////////////////");
		ui.display("// Categories Control //");
		ui.display("////////////////////////");
		ui.display("All categories:");

		printCategories();
		ui.display("------------------------");
		ui.display("Commands:");

		while (true) {
			ui.display("r- rename  , d- delete , e- exit to Main Page");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				
				return pages[0];
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
