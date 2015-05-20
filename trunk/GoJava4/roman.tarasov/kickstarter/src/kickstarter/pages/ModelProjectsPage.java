package kickstarter.pages;



public class ModelProjectsPage extends Model2{
	

	public void execute(String message) {
		saveCategory(iOption);
		if (message.equals("p")) {
			next(CATEGORIES);
			return;
		}

		if (sOptions != null) {
			for (int index = 0; index < sOptions.length; index++) {
				if (message.equals(sOptions[index])) {
					nextWithOptions(DETAILED_PROJECT, iOptions[index], sOptions[index]);
					return;
				}
			}
		}
		goToAndBack(ERROR_PAGE, PROJECTS);
	}
}
