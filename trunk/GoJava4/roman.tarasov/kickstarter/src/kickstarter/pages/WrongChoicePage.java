package kickstarter.pages;

import kickstarter.mvc.Model;
import kickstarter.mvc.iNavigator;

public class WrongChoicePage extends Page{
	iNavigator navigator;
	public WrongChoicePage(Model model) {
		this.navigator=model;
	}
	public void viewWorkedStatus(int status) {
	}
	public String getHeader() {
		
		String header = "";
		header += "\n----- Wrong Choice ----------";
		header += "\ninput correct command, please";
		header += "\n-----------------------------";
		header += "\nOptions:  p- previous page";
		return header;
	}

	public String[] getOptions() {
		return null;
	}
	public void execute(String message) {
		if (message.equals("p")) {
			navigator.pageWillBe(navigator.getSavedPage());
			return;
		}
	}
}
