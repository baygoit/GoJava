package kickstarter.pages.modelContent;


public class WrongChoiceModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(imodel.getSavedPage());
			return;
		}
	}
}
