package kickstarter.pages;

public class WrongChoicePage extends Page{

	public void viewWorkedStatus(int status) {
	}
	public String getHeader() {
		
		String header = "";
		header += "\n----- Wrong Choice ----------";
		header += "\ninput correct command, please";
		header += "\n-----------------------------";
		return header;
	}

	public String[] getOptions() {
		return null;
	}
}
