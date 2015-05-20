package kickstarter.pages;

import kickstarter.mvc.Model;

public class ResultOfBankOperation extends Page {
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
		header += sOption;
		header += "\nOptions: <p>- previous page  ";
		return header;
	}

	public void execute(String message) {
		
		if (message.equals("p")) {
			navigator.next(DETAILED_PROJECT);
			return;
		}
		navigator.goToAndBack(ERROR_PAGE,BANK_OPERATION_RESULT_PAGE);

	}
}
