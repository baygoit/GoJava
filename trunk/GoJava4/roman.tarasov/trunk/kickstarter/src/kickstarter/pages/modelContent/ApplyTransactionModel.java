package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;

public class ApplyTransactionModel extends PageModel {
	public ApplyTransactionModel(Bank bank, Repository repository, iModel imodel) {
		super(imodel);
		this.bank = bank;
		this.repository = repository;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
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
				imodel.savePageBeforeError(DONATE_PAGE);
				modelOptions = imodel.getModelOptions();
				modelOptions.resultOfBankOperation = resultOfBankOperation;
				imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, modelOptions);
				return;
			}

			project = repository
					.getProjectById(modelOptions.intSelectedProject);
			project.pledged += getMoney;

			modelOptions.resultOfBankOperation = "\nbalance before :" + balanceBefore
					+ "\nbalance after :" + balanceAfter;
			imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, modelOptions);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, APPLY_TRANSACTION_PAGE);
	}


}
