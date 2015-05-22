package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.repository.facade.Repository;


public class InvestModel extends PageModel {
	public InvestModel(Repository repository,iModel imodel) {
		super(imodel);
	
	this.repository=repository;
	this.imodel = imodel;
	}

	@Override
	public void update(String message) {

		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		ModelOptions o = imodel.getModelOptions();
		int projectID=o.intSelectedProject;
		project = repository.getProjectById(projectID);
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(ERROR_PAGE, INVEST_PAGE);
			return;
		}
		o = imodel.getModelOptions();
		o.intOption = intOption;
		o.strOption = Double.toString(amount);
		imodel.nextWithOptions(APPLY_TRANSACTION_PAGE, o);
	}
}
