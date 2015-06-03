package kickstarter.pages.viewContent;

public class DAOmenu extends PageView {

	@Override
	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n          DAO menu             ");
		header.append("\n-------------------------------");
		header.append("\nOptions:   <m> - memory access\n           <d> - database access\n           <p> - previous page\n           <e> - The End");
		return header.toString();
	}
}