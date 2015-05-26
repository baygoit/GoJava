package kickstarter.pages.viewContent;

import kickstarter.payment.Bank;

public class Donate extends PageView {

	public Donate(Bank bank) {
		this.bank = bank;		
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
