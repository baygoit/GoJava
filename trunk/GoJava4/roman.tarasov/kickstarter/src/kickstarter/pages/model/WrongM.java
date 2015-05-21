package kickstarter.pages.model;

import kickstarter.mvc.interfaces.iModel;

public class WrongM extends PageModel {
	public WrongM(iModel imodel) {
		super(imodel);
	}
	@Override
	public void execute(String message) {
		if (message.equals("p")) {
			imodel.next(imodel.getSavedPage());
			return;
		}
	}
}
