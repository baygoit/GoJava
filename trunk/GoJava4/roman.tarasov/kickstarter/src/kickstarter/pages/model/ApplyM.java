package kickstarter.pages.model;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class ApplyM extends PageModel {
	public ApplyM(Bank bank, ProjectRepository projects, iModel imodel) {
		super(imodel);
		this.bank=bank;
		this.projects=projects;
	}
	@Override
	public void execute(String message) {
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		String[] array = message.split(":");
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		ModelOptions o =imodel.getModelOptions();
		strOption=o.strOption;
		String resultOfBankOperation = "";
		if (array.length == 2) {
			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				if (balanceBefore < 0) {
					resultOfBankOperation = "\nbalance error\n";
					throw new NullPointerException("balance error");
				}
				getMoney = Double.parseDouble(strOption);
				if (!bank.getMoney(array[0], array[1], strOption)) {
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
				o =imodel.getModelOptions();
				o.intOption = intOption;
				o.strOption = resultOfBankOperation;
				imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, o);
				return;
			}

			int projectID = o.intSelectedProject;
			Project project = projects.getProjectById(projectID);
			project.pledged += getMoney;

			String setOption = "\nbalance before :" + balanceBefore
					+ "\nbalance after :" + balanceAfter;
		
			o.intOption = intOption;
			o.strOption = setOption;
			imodel.nextWithOptions(BANK_OPERATION_RESULT_PAGE, o);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, APPLY_TRANSACTION_PAGE);
	}
}
