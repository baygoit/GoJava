package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class ResultOfBankModel extends PageModel {
	public ResultOfBankModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void update(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, BANK_OPERATION_RESULT_PAGE);
	}
}
