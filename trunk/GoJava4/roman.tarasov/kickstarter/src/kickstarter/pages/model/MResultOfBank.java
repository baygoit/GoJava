package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MResultOfBank extends PageModel {
	public MResultOfBank(iModel imodel) {
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
