package kickstarter.pages.view;


public class WrongChoice extends PageView {

	public String getHeader() {
		String header = "";
		header += "\n----- Wrong Choice ----------";
		header += "\ninput correct command, please";
		header += "\n-----------------------------";
		header += "\nOptions:  <p> - previous page";
		return header;
	}
}
