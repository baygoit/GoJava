package kickstarter.pages.view;


import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.ProjectRepository;

public class Donate extends PageView {

	public Donate(Bank bank, ProjectRepository projects, iModel imodel) {
		this.bank = bank;
		this.projects = projects;
		this.imodel=imodel;
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
}
