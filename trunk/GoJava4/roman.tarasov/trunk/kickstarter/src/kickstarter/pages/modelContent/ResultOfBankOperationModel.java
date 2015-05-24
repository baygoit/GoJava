package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class ResultOfBankOperationModel extends PageModel {
	public ResultOfBankOperationModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, BANK_OPERATION_RESULT_PAGE);
	}
}
