package kickstarter.pages.viewContent;

public class FileError extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-------------------------------");
		header.append("\n File System Repository error  ");
		header.append("\n-------------------------------");
		header.append("\nOptions:  <c> - copy InMemoryRepository to FileSystemRepository\n          <e> - The End\n          <i> - connect to InMemoryRepository");
		return header.toString();
	}
}