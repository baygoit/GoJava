package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class TheEndModel extends PageModel {

	public TheEndModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void updateStateOfPageModel(String message) {
		System.exit(0);
	}
}
