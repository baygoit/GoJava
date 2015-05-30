package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.payment.Bank;
import kickstarter.payment.BankException;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.Project;

public class DonateModel extends PageModel {
	private Bank bank;

	public DonateModel(Bank bank) {
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
		if (array.length == 3) {
			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				getMoney = Double.parseDouble(array[2]);
				bank.getMoney(array[0], array[1], array[2]);
				balanceAfter = bank.getBalance(array[0], array[1]);
				Project project = repository.getProjectById(modelValues
						.getIntSelectedProject());
				project.setPledged(project.getPledged() + getMoney);

				modelValues.setResultOfBankOperation("\nbalance before :"
						+ balanceBefore + "\nbalance after :" + balanceAfter);
				imodel.next(IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal());
			} catch (NumberFormatException | NullPointerException
					| BankException e) {
				imodel.savePageBeforeError(IndexOfPage.DONATE_PAGE.ordinal());
				modelValues.setResultOfBankOperation(e.toString());
				imodel.next(IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal());
			}
			return;
		}

		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DONATE_PAGE.ordinal());
	}
}
