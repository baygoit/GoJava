package kickstarter.pages;

public class ModelCategories extends Model2{
	public void execute(String message) {
		if (message.equals("e")) {
			next(END_PAGE);
			return;
		}

		if (sOptions != null) {
			for (int index = 0; index < sOptions.length; index++) {
				if (message.equals(sOptions[index])) {
					nextWithOptions(PROJECTS,iOptions[index], sOptions[index]);
					return;
				}
			}
		}

		goToAndBack(ERROR_PAGE, CATEGORIES);
	}
}
