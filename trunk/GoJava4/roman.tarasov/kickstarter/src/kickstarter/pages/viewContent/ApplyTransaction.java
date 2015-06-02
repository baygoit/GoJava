package kickstarter.pages.viewContent;

public class ApplyTransaction extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();

		header.append("\n=========================");
		header.append("\n|   apply transaction   |");
		header.append("\n=========================");
		header.append("\n");
		header.append("\n------------------------");
		header.append("\nOptions: apply  in format <bankir:777> where login -bankir-, cardnumber -777-  \n<p>- previous page  ");

		return header.toString();
	}
}
