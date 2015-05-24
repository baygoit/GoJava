package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class WrongChoiceModel extends PageModel {
	public WrongChoiceModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(imodel.getSavedPage());
			return;
		}
	}
}
