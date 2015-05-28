package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;

public class InvestModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		modelValues = imodel.getModelValues();
		Project project = repository.getProjectById(modelValues.getIntSelectedProject());
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
					IndexOfPage.INVEST_PAGE.ordinal());
			return;
		}
		modelValues.setAmountToInvest(Double.toString(amount));
		imodel.nextWithValues(IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal(),
				modelValues);
	}
}
