package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.repository.facade.Repository;

public class InvestModel extends PageModel {
	public InvestModel(Repository repository, iModel imodel) {
		super(imodel);

		this.repository = repository;
		this.imodel = imodel;
	}

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		modelOptions = imodel.getModelOptions();
		project = repository.getProjectByCategoryIDandProjectID(modelOptions.intSelectedCategory,modelOptions.intSelectedProject);
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(ERROR_PAGE, INVEST_PAGE);
			return;
		}
		modelOptions.intOption = intOption;
		modelOptions.amountToInvest = Double.toString(amount);
		imodel.nextWithOptions(APPLY_TRANSACTION_PAGE, modelOptions);
	}
}
