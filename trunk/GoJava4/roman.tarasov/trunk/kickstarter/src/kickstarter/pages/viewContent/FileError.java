package kickstarter.pages.viewContent;


public class FileError extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n-----------------------------");
		header.append("\n     Ready to repair         ");
		header.append("\n-----------------------------");
		header.append("\nOptions:  <w> - write InMemoryRepository to FileSystemRepository");
		return header.toString();
	}
}