package kickstarter.pages.viewContent;

public class RepositoryMenu extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n      Repository menu          ");
		header.append("\n-------------------------------");
		header.append("\nOptions:  <c> - create Image of Repository and store to File\n          <i> - restore  Repository from Image\n          <d> - connect to Default Repository\n          <p> - previous page\n          <e> - The End");
		return header.toString();
	}
}