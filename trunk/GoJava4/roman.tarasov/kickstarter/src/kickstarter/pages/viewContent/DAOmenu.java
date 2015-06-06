package kickstarter.pages.viewContent;

import java.sql.SQLException;

import kickstarter.mvc.interfaces.iController;

public class DAOmenu extends PageView {
	private iController icontroller;

	public DAOmenu(iController icontroller) {
		this.icontroller = icontroller;
	}

	@Override
	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n===============================");
		header.append("\n|          DAO menu            |");
		header.append("\n===============================");
		header.append("\n Database status: ");
		boolean isClosed=true;
		try {
			isClosed = icontroller.getDatabaseService().getConnection().isClosed();
		} catch (NullPointerException|SQLException e) {
			isClosed=true;
		}
		if (isClosed) {
			header.append("<disconnected>");
		} else {
			header.append("<connected>");
		}
		header.append("\n Current DAO: ");
		String nameOfDAO=icontroller.getDao().getName();
		header.append(nameOfDAO);
		header.append("\n-------------------------------");
		header.append("\nOptions:   <m> - memory access\n           <d> - database access\n           <c> - copy from memory DAO to database DAO \n           <p> - previous page\n           <e> - The End");
		return header.toString();
	}
}