package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;

public class DetailedProjectModel extends PageModel {
	public DetailedProjectModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void update(String message) {

		if (message.equals("p")) {
			ModelOptions o = imodel.getModelOptions();
			imodel.nextWithOptions(PROJECTS, o);
			return;
		}
		if (message.equals("c")) {
			imodel.next(COMMENT_PAGE);
			return;
		}
		if (message.equals("i")) {
			ModelOptions o = imodel.getModelOptions();
			o.intOption = intOption;
			imodel.nextWithOptions(INVEST_PAGE, o);
			return;
		}
		if (message.equals("d")) {
			ModelOptions o = imodel.getModelOptions();
			o.intOption = intOption;
			imodel.nextWithOptions(DONATE_PAGE, o);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, DETAILED_PROJECT);
	}
}
