package kickstarter.pages.model;

import kickstarter.mvc.interfaces.iModel;

public class ResultOfBankM extends PageModel {
	public ResultOfBankM(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, BANK_OPERATION_RESULT_PAGE);
	}
}
