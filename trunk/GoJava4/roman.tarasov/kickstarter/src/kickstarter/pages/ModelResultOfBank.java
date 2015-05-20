package kickstarter.pages;

public class ModelResultOfBank extends Model2{
	public void execute(String message) {
		
		if (message.equals("p")) {
			next(DETAILED_PROJECT);
			return;
		}
		goToAndBack(ERROR_PAGE,BANK_OPERATION_RESULT_PAGE);

	}
}
