package kickstarter.pages;

public class ResultOfBankOperation extends PageView {

	public String getHeader() {
		String header = "";
		header += "\n============================";
		header += "\n| Result of Bank operation |";
		header += "\n============================";
		header += "\n";
		header += "\n------------------------";
		header += sOption;
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
