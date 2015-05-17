package kickstarter.pages;

import kickstarter.ui.UserInterface;

public class TheEndPage extends Page {
	UserInterface ui;

	public TheEndPage(UserInterface ui) {
		this.ui = ui;
	}

	public void print(String parameter) {
		ui.display("=========================");
		ui.display("|     The End           |");
		ui.display("=========================");
		System.exit(0);
	}
}
