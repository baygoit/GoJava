package kickstarter.pages;

import kickstarter.mvc.Model;

public class WrongChoicePage extends Page {

	public WrongChoicePage(Model model) {
		this.navigator = model;
	}

	public String getHeader() {
		String header = "";
		header += "\n----- Wrong Choice ----------";
		header += "\ninput correct command, please";
		header += "\n-----------------------------";
		header += "\nOptions:  <p> - previous page";
		return header;
	}

	public void execute(String message) {
		if (message.equals("p")) {
			navigator.next(navigator.getSavedPage());
			return;
		}
	}
}
