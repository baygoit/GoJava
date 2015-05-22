package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class WrongModel extends PageModel {
	public WrongModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void update(String message) {
		if (message.equals("p")) {
			imodel.next(imodel.getSavedPage());
			return;
		}
	}
}
