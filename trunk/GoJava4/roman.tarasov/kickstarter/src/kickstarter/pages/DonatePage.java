package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class DonatePage extends Page {
	Bank bank;

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

	public String[] getOptions() {
		return options;
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
		if (array.length == 3) {
			try {
				balanceBefore = bank.getBalance(array[0], array[1]);
				if (balanceBefore < 0) {
					throw new NullPointerException("balance error");
				}
				getMoney = Double.parseDouble(array[2]);
				if (!bank.getMoney(array[0], array[1], array[2])) {
					throw new NullPointerException("bank operation error");
				}
				balanceAfter = bank.getBalance(array[0], array[1]);
				if (balanceAfter < 0) {
					throw new NullPointerException("balance error");
				}

			} catch (NumberFormatException | NullPointerException e) {
				navigator.savePageBeforeError(DONATE_PAGE);
				navigator.pageWillBe(ERROR_PAGE);
				return;
			}

			int projectID = parameterForPage;
			Project project = projects.getProjectById(projectID);
			project.pledged += getMoney;

			navigator.pageWillBe(BANK_OPERATION_RESULT_PAGE);
			String setOption="\nbalance before :" + balanceBefore+"\nbalance after :" + balanceAfter;
			navigator.setOption(parameterForPage,setOption);
			return;

		}
		navigator.savePageBeforeError(DONATE_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
