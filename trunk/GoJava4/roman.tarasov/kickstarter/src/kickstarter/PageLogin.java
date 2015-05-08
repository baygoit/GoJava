package kickstarter;

public class PageLogin extends Page {

	public Page getNextPage() {

		ui.display("++++++++++++++++++++++++");
		ui.display("+       Login          +");
		ui.display("++++++++++++++++++++++++");
		ui.display("0- admin");
		ui.display("1- guest");
		ui.display("------------------------");
		ui.display("Login: ");
		while (true) {

			String fromUI = ui.inputString();
			if (fromUI.equals("0")) {
				return pages[ADMIN_CATEGORIES_CONTROL];
			}
			if (fromUI.equals("1")) {
				return pages[USER_CATEGORIES_VIEW];
			}
			ui.display("input correct login, please");
		}
	}
}
