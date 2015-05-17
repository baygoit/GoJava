package kickstarter.pages;

public class TheEndPage extends Page {
	public void viewWorkedStatus(int status) {
		System.exit(0);
	}

	public String getHeader() {

		String header = "";
		header += "\n=========================";
		header += "\n|     The End           |";
		header += "\n=========================";
		return header;
	}
	
}
