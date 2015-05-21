package kickstarter.pages.model;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class DonateM extends PageModel {
	public DonateM(Bank bank, ProjectRepository projects, iModel imodel) {
		super(imodel);
		this.bank = bank;
		this.projects = projects;
		this.imodel = imodel;
	}

	public void execute(String message) {
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}

		String[] array = message.split(":");
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		String resultOfBankOperation = "";
		ModelOptions o = imodel.getModelOptions();
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

		imodel.goToAndBack(ERROR_PAGE, DONATE_PAGE);
	}
}
