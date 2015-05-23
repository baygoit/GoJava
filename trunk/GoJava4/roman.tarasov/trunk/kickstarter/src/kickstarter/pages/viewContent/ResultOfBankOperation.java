package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;

public class ResultOfBankOperation extends PageView {

	public ResultOfBankOperation(iModel imodel) {
		this.imodel = imodel;
	}

	public String getHeader() {
		String header = "";
		header += "\n============================";
		header += "\n| Result of Bank operation |";
		header += "\n============================";
		header += "\n";
		header += "\n------------------------";
		header += imodel.getModelOptions().strOption;
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
