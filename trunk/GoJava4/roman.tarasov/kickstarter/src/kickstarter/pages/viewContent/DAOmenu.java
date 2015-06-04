package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iController;

public class DAOmenu extends PageView {
	private iController icontroller;
	public DAOmenu(iController icontroller) {
		this.icontroller = icontroller;
	}
	@Override
	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n          DAO menu             ");
		header.append("\n-------------------------------");
		header.append("\n Database status: ");
		boolean status =icontroller.getDatabaseService().getDatabaseStatus();
		header.append("\n-------------------------------");
		header.append("\nOptions:   <m> - memory access\n           <d> - database access\n           <p> - previous page\n           <e> - The End");
		return header.toString();
	}
}