package kickstarter.pages.modelContent;


public class ResultOfBankOperationModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, BANK_OPERATION_RESULT_PAGE);
	}
}
