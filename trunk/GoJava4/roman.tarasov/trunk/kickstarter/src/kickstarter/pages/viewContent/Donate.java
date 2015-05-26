package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.iRepository;

public class Donate extends PageView {

	public Donate(Bank bank, iRepository repository, iModel imodel) {
		this.bank = bank;
		this.repository = repository;
		this.imodel = imodel;
	}

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n=========================");
		header.append("\n|       donate          |");
		header.append("\n=========================");
		header.append("\n");
		header.append("\n------------------------");
		header.append("\nOptions: donate in format <bankir:777:20> where login -bankir-, cardnumber -777-, pay -20- \n<p>- previous page  ");
		return header.toString();
	}
}
