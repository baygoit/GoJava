package kickstarter.pages.viewContent;

public class TheEnd extends PageView {

	@Override
	public String getHeader() {

		StringBuilder header = new StringBuilder();
		header.append("\n=========================");
		header.append("\n|     The End           |");
		header.append("\n=========================");
		return header.toString();
	}
}
