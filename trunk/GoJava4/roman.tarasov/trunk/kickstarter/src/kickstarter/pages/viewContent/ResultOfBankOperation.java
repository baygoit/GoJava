package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;

public class ResultOfBankOperation extends PageView {

	public ResultOfBankOperation(iModel imodel) {
		this.imodel = imodel;
	}

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n============================");
		header.append("\n| Result of Bank operation |");
		header.append("\n============================");
		header.append("\n");
		header.append("\n------------------------");
		header.append(imodel.getModelOptions().resultOfBankOperation);
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
