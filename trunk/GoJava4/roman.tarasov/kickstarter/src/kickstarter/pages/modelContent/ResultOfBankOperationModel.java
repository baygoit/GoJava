package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;


public class ResultOfBankOperationModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		imodel.goToAndBack(IndexOfPage.END_PAGE.ordinal(), IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal());
	}
}
