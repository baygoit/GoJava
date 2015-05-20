package kickstarter.pages;

public class ModelInvestPage extends Model2{
	public void execute(String message) {
		setOption(iOption, "null");
		if (message.equals("p")) {
			next(DETAILED_PROJECT);
			return;
		}
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			goToAndBack(ERROR_PAGE, INVEST_PAGE);
			return;
		}
	
		nextWithOptions(APPLY_TRANSACTION_PAGE, iOption, Double.toString(amount));
	}
}
