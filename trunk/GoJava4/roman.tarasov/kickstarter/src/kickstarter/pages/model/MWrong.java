package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MWrong extends PageModel {
	public MWrong(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
		if (message.equals("p")) {
			imodel.next(imodel.getSavedPage());
			return;
		}
	}
}
