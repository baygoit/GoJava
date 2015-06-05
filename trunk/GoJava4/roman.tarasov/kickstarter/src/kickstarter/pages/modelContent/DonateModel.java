package kickstarter.pages.modelContent;

import java.sql.SQLException;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.Project;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.payment.Bank;
import kickstarter.payment.BankException;

public class DonateModel extends PageModel {
	private Bank bank;

	public DonateModel(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void updateStateOfPageModel(String message)
			throws ServiceException {
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
				Project project = idao.getProjectService().getProjectById(modelValues
						.getIntSelectedProject());
				project.setPledged(project.getPledged() + getMoney);
				idao.getProjectService().updateProject(project);
				modelValues.setResultOfBankOperation("\nbalance before :"
						+ balanceBefore + "\nbalance after :" + balanceAfter);
				imodel.next(IndexOfPage.BANK_OPERATION_RESULT_PAGE.ordinal());
			} catch (NumberFormatException | NullPointerException
					| BankException | SQLException e) {
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
