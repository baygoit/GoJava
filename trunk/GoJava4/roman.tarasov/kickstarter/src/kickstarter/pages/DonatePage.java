package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class DonatePage extends Page {

	public DonatePage(Model model, Bank bank, ProjectRepository projects) {
		navigator = model;
		this.bank = bank;
		this.projects = projects;
	}

	public String getHeader() {
		String header = "";
		header += "\n=========================";
		header += "\n|       donate          |";
		header += "\n=========================";
		header += "\n";
		header += "\n------------------------";
		header += "\nOptions: donate in format <bankir:777:20> where login -bankir-, cardnumber -777-, pay -20- \n<p>- previous page  ";
		return header;
	}

	public void execute(String message) {
		//navigator.saveProject(iOption);
		if (message.equals("p")) {
			navigator.next(DETAILED_PROJECT);
			return;
		}

		String[] array = message.split(":");
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		String resultOfBankOperation = "";
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
				navigator.savePageBeforeError(DONATE_PAGE);
				navigator.nextWithOptions(BANK_OPERATION_RESULT_PAGE,iOption, resultOfBankOperation);
				return;
			}

			int projectID = iOption;
			Project project = projects.getProjectById(projectID);
			project.pledged += getMoney;
			String setOption = "\nbalance before :" + balanceBefore
					+ "\nbalance after :" + balanceAfter;
			navigator.nextWithOptions(BANK_OPERATION_RESULT_PAGE, iOption,
					setOption);
			return;
		}

		navigator.goToAndBack(ERROR_PAGE, DONATE_PAGE);
	}
}
