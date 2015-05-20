package kickstarter.pages.model;

import java.util.Arrays;

import kickstarter.mvc.iModel;

public class MCategories extends PageModel {
	public MCategories(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
		ModelOptions options=imodel.getOptions();
		strOptions=options.strOptions;
		intOptions=options.intOptions;
		System.out.println(Arrays.toString(strOptions));
		if (strOptions != null) {
			for (int index = 0; index < strOptions.length; index++) {
				if (message.equals(strOptions[index])) {
					ModelOptions o =new ModelOptions();
					o.intOption=intOptions[index];
					o.strOption=strOptions[index];
					imodel.nextWithOptions(PROJECTS,o);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, CATEGORIES);
	}
}
