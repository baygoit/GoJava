package kickstarter.pages.viewContent;

public class RepositoryMenu extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n      MemoryRepository menu          ");
		header.append("\n-------------------------------");
		header.append("\nOptions:  <c> - create Image of current IRepository and store to the File\n          <i> - connect to restored IRepository from Image \n          <d> - connect to Default IRepository\n          <p> - previous page\n          <e> - The End");
		return header.toString();
	}
}