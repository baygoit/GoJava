package kickstarter.pages.view;


import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class ApplyTransaction extends PageView {

	public ApplyTransaction(Bank bank, ProjectRepository projects, iModel imodel) {
		this.bank = bank;
		this.projects = projects;
		this.imodel=imodel;
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
