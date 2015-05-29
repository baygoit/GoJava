package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.Project;

public class InvestModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {

		if (message.equals("p")) {
			getImodel().next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		modelValues = getImodel().getModelValues();
		Project project = getRepository().getProjectById(modelValues.getIntSelectedProject());
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
					IndexOfPage.INVEST_PAGE.ordinal());
			return;
		}
		modelValues.setAmountToInvest(Double.toString(amount));
		getImodel().nextWithValues(IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal(),
				modelValues);
	}
}
