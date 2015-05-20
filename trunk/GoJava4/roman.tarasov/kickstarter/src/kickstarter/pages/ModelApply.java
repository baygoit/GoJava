package kickstarter.pages;

import kickstarter.entities.Project;

public class ModelApply extends Model2{
	public void execute(String message) {

		if (message.equals("p")) {
			next(DETAILED_PROJECT);
			return;
		}
		String[] array = message.split(":");
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;

		String resultOfBankOperation = "";
		if (array.length == 2) {
			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				if (balanceBefore < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}
				getMoney = Double.parseDouble(sOption);
				if (!bank.getMoney(array[0], array[1], sOption)) {
					resultOfBankOperation = "\nbank operation error\n";
					throw new NullPointerException("bank operation error");
				}
				balanceAfter = bank.getBalance(array[0], array[1]);
				if (balanceAfter < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}

			} catch (NumberFormatException | NullPointerException e) {
				savePageBeforeError(DONATE_PAGE);
				nextWithOptions(BANK_OPERATION_RESULT_PAGE,iOption,resultOfBankOperation);
				return;
			}

			int projectID = iOption;
			Project project = projects.getProjectById(projectID);
			project.pledged += getMoney;

			String setOption = "\nbalance before :" + balanceBefore
					+ "\nbalance after :" + balanceAfter;

			nextWithOptions(BANK_OPERATION_RESULT_PAGE, iOption, setOption);
			return;

		}
		goToAndBack(ERROR_PAGE,APPLY_TRANSACTION_PAGE);
	
	}
}
