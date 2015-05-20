package kickstarter.pages;

public class ModelDetailed extends Model2{
	public void execute(String message) {
		
		if (message.equals("p")) {
			nextWithOptions(PROJECTS, getSavedCategory(), "null");
			return;
		}
		if (message.equals("c")) {
			next(COMMENT_PAGE);
			return;
		}
		if (message.equals("i")) {
			nextWithOptions(INVEST_PAGE, iOption, "null");
			return;
		}
		if (message.equals("d")) {
			nextWithOptions(DONATE_PAGE, iOption, "null");
			return;
		}
		goToAndBack(ERROR_PAGE, DETAILED_PROJECT);

	}
}
