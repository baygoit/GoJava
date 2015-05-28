package kickstarter.pages.viewContent;

public class RepositoryMenu extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n      MemoryRepository menu          ");
		header.append("\n-------------------------------");
		header.append("\nOptions:  <c> - create Image of current Repository and store to the File\n          <i> - connect to restored Repository from Image \n          <d> - connect to Default Repository\n          <p> - previous page\n          <e> - The End");
		return header.toString();
	}
}