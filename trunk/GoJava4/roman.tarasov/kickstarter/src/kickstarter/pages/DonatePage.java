package kickstarter.pages;

import kickstarter.mvc.Model;

public class DonatePage extends Page{
	public DonatePage(Model model) {
		navigator = model;
	}

	public String getHeader() {

		String header = "";
		header += "\n=========================";
		header += "\n|       donate          |";
		header += "\n=========================";
		header += "\n";
		header += "\n------------------------";
		header += "\nOptions: <p>- previous page  ";
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
		navigator.savePageBeforeError(DONATE_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
