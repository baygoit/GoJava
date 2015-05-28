package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.RepositoryException;

public class ApplyTransactionModel extends PageModel {
	Bank bank;
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
		modelValues = imodel.getModelValues();
		String amountToInvest = modelValues.getAmountToInvest();
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
				modelValues = imodel.getModelValues();
				modelValues.setResultOfBankOperation(resultOfBankOperation); 
				imodel.nextWithValues(
						IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal(),
						modelValues);
				return;
			}

			Project project = repository.getProjectById(modelValues.getIntSelectedProject());
			project.setPledged(project.getPledged()+ getMoney);

			modelValues.setResultOfBankOperation ("\nbalance before :"
					+ balanceBefore + "\nbalance after :" + balanceAfter);
			imodel.nextWithValues(
					IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal(),
					modelValues);
			return;

		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.APPLY_TRANSACTION_PAGE.ordinal());
	}

}
