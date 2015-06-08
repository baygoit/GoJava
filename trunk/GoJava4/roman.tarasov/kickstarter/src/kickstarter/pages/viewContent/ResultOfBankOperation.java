package kickstarter.pages.viewContent;

public class ResultOfBankOperation extends PageView {

	@Override
	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n============================");
		header.append("\n| Result of Bank operation |");
		header.append("\n============================");
		header.append("\n");
		header.append(imodel.getModelValues().getResultOfBankOperation());
		header.append("\n------------------------");
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
