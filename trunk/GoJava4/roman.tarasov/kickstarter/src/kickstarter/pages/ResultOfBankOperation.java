package kickstarter.pages;

import kickstarter.mvc.Model;

public class ResultOfBankOperation extends Page{
	public ResultOfBankOperation(Model model) {
		navigator = model;
	}

	public String getHeader() {

		String header = "";
		header += "\n============================";
		header += "\n| Result of Bank operation |";
		header += "\n============================";
		header += "\n";
		header += "\n------------------------";
		header += stringParameterForPage;
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
		navigator.savePageBeforeError(BANK_OPERATION_RESULT_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
