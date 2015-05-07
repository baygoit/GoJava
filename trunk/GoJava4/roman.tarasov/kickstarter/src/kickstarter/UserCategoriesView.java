
package kickstarter;

public class UserCategoriesView extends Page implements UserInterface{
	CategoryList list;
	UserCategoriesView( CategoryList list) {
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
			ui.display("input correct command, please");
		}
	}
}