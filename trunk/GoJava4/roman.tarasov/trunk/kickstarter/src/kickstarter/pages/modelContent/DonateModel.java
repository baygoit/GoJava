package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;

public class DonateModel extends PageModel {
	public DonateModel(Bank bank, Repository repository, iModel imodel) {
		super(imodel);
		this.bank = bank;
		this.repository = repository;
		this.imodel = imodel;
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
		String resultOfBankOperation = "";
		modelOptions = imodel.getModelOptions();
		if (array.length == 3) {
			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				if (balanceBefore < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}
				getMoney = Double.parseDouble(array[2]);
				if (!bank.getMoney(array[0], array[1], array[2])) {
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
				modelOptions.intOption = intOption;
				modelOptions.resultOfBankOperation = resultOfBankOperation;
				imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, modelOptions);
				return;
			}

			project = repository
					.getProjectById(modelOptions.intSelectedProject);
			project.pledged += getMoney;

			modelOptions.intOption = intOption;
			modelOptions.resultOfBankOperation = "\nbalance before :"
					+ balanceBefore + "\nbalance after :" + balanceAfter;
			imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, modelOptions);
			return;
		}

		imodel.goToAndBack(ERROR_PAGE, DONATE_PAGE);
	}
}
