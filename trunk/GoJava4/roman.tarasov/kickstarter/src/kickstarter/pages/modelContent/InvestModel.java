package kickstarter.pages.modelContent;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.Project;
import kickstarter.mvc.interfaces.IndexOfPage;

public class InvestModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message)
			throws ServiceException {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		modelValues = imodel.getModelValues();
		Project project = idao.getProjectService().getProjectById(modelValues
				.getIntSelectedProject());
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.getAmount()[selected - 1];
			modelValues.setAmountToInvest(Double.toString(amount));
			imodel.next(IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal());
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
					IndexOfPage.INVEST_PAGE.ordinal());
		}
	}
}
