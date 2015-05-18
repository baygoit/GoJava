package kickstarter.pages;

import kickstarter.mvc.Model;

public class InvestPage extends Page {
	public InvestPage(Model model) {
		navigator = model;
	}

	public String getHeader() {

		String header = "";
		header += "\n=========================";
		header += "\n|       invest          |";
		header += "\n=========================";
		header += "\n";
		header += "\n------------------------";
		return header;
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		navigator.saveProject(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(DETAILED_PROJECT);
			return;
		}
		navigator.savePageBeforeError(INVEST_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
