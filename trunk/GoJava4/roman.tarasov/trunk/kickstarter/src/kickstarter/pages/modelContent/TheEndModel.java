package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;

public class TheEndModel extends PageModel {

	public TheEndModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void update(String message) {
		System.exit(0);
	}
}
