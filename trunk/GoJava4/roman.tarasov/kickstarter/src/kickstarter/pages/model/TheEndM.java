package kickstarter.pages.model;

import kickstarter.mvc.interfaces.iModel;

public class TheEndM extends PageModel {

	public TheEndM(iModel imodel) {
		super(imodel);
	}
	@Override
	public void execute(String message) {
		System.exit(0);
	}
}
