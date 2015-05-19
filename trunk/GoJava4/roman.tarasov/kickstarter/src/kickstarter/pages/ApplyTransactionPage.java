package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class ApplyTransactionPage extends Page {

	public ApplyTransactionPage(Model model, Bank bank,
			ProjectRepository projects) {
		this.navigator = model;
		this.bank = bank;
		this.projects = projects;
	}

	public void viewWorkedStatus(int status) {
	}

	public String getHeader() {
		String header = "";
		header += "\n=========================";
		header += "\n|   apply transaction   |";
		header += "\n=========================";
		header += "\n";
		header += "\n------------------------";
		header += "\nOptions: apply  in format <bankir:777> where login -bankir-, cardnumber -777-  \n<p>- previous page  ";
		return header;
	}

	public String[] getOptions() {
		return null;
	}

	public void execute(String message) {

		navigator.saveProject(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(DETAILED_PROJECT);
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
				getMoney = Double.parseDouble(stringParameterForPage);
				if (!bank.getMoney(array[0], array[1], stringParameterForPage)) {
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
				navigator.setOption(parameterForPage, resultOfBankOperation);
				navigator.pageWillBe(BANK_OPERATION_RESULT_PAGE);
				return;
			}

			int projectID = parameterForPage;
			Project project = projects.getProjectById(projectID);
			project.pledged += getMoney;

			navigator.pageWillBe(BANK_OPERATION_RESULT_PAGE);
			String setOption = "\nbalance before :" + balanceBefore
					+ "\nbalance after :" + balanceAfter;
			navigator.setOption(parameterForPage, setOption);
			return;

		}
		navigator.savePageBeforeError(APPLY_TRANSACTION_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
