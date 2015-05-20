package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MInvest extends PageModel {
	public MInvest(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
	//	Options o = new Options();
		//TODO
	//	o.intOption = intOption;
	//	imodel.setOptions(o);
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			imodel.goToAndBack(ERROR_PAGE, INVEST_PAGE);
			return;
		}
		ModelOptions o = new ModelOptions();
		o.intOption = intOption;
		o.strOption = Double.toString(amount);
		imodel.nextWithOptions(APPLY_TRANSACTION_PAGE, o);
	}
}
