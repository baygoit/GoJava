package kickstarter.pages.viewContent;

public class RepositoryMenu extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n      Repository menu          ");
		header.append("\n-------------------------------");
		header.append("\nOptions:  <c> - copy MemoryRepository to FileRepository\n          <e> - The End\n          <m> - connect to MemoryRepository\n          <f> - copy  FileRepository to MemoryRepository\n          <p> - previous page");
		return header.toString();
	}
}