package kickstarter.pages.view;


import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;

public class ResultOfBankOperation extends PageView {

	public ResultOfBankOperation(iModel imodel) {
		this.imodel=imodel;
	}

	public String getHeader() {
		String header = "";
		header += "\n============================";
		header += "\n| Result of Bank operation |";
		header += "\n============================";
		header += "\n";
		header += "\n------------------------";
		ModelOptions o = imodel.getModelOptions();
		header += o.strOption;
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
