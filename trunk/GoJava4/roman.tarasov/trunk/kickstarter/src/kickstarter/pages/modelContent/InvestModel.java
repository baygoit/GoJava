package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;


public class InvestModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) throws RepositoryException  {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		modelOptions = imodel.getModelOptions();
		project = repository.getProjectById(modelOptions.intSelectedProject);
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.INVEST_PAGE.ordinal());
			return;
		}
		modelOptions.intOption = intOption;
		modelOptions.amountToInvest = Double.toString(amount);
		imodel.nextWithOptions(IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal(), modelOptions);
	}
}
