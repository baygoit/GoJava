package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.RepositoryException;

public class ApplyTransactionModel extends PageModel {
	public ApplyTransactionModel(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		String[] array = message.split(":");
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		modelOptions = imodel.getModelOptions();
		String amountToInvest = modelOptions.amountToInvest;
		String resultOfBankOperation = "";
		if (array.length == 2) {

			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				if (balanceBefore < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}
				getMoney = Double.parseDouble(amountToInvest);
				if (!bank.getMoney(array[0], array[1], amountToInvest)) {
					resultOfBankOperation = "\nbank operation error\n";
					throw new NullPointerException("bank operation error");
				}
				balanceAfter = bank.getBalance(array[0], array[1]);
				if (balanceAfter < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}

			} catch (NumberFormatException | NullPointerException e) {
				imodel.savePageBeforeError(IndexOfPage.DONATE_PAGE.ordinal());
				modelOptions = imodel.getModelOptions();
				modelOptions.resultOfBankOperation = resultOfBankOperation;
				imodel.nextWithOptions(IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal(), modelOptions);
				return;
			}

			project = repository
					.getProjectById(modelOptions.intSelectedProject);
			project.pledged += getMoney;

			modelOptions.resultOfBankOperation = "\nbalance before :"
					+ balanceBefore + "\nbalance after :" + balanceAfter;
			imodel.nextWithOptions(IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal(), modelOptions);
			return;

		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal());
	}

}
