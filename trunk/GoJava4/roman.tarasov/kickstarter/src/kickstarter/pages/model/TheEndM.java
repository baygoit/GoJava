package kickstarter.pages.model;

import kickstarter.mvc.interfaces.iModel;

public class TheEndM extends PageModel {

	public TheEndM(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
		System.exit(0);
	}
}
