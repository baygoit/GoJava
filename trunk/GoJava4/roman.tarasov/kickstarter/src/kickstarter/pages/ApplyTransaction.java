package kickstarter.pages;

import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class ApplyTransaction extends PageView {

	public ApplyTransaction(Bank bank, ProjectRepository projects) {
		this.bank = bank;
		this.projects = projects;
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
}
