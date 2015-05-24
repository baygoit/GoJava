package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.repository.facade.Repository;

public class Invest extends PageView {

	public Invest(Repository repository, iModel imodel) {
		this.repository = repository;
		this.imodel = imodel;
	}

	public String getHeader() {

		project = repository.getProjectById(imodel.getModelOptions().intSelectedProject);
		String header = "";
		header += "\n=========================";
		header += "\n|   invest to project   |";
		header += "\n=========================";
		header += "\n";
		header += "\n  Investment options :";
		int length = project.investmentOptions.length;
		intOptions = new int[length];
		strOptions = new String[length];
		for (int index = 0; index < length; index++) {
			header += "\n" + (index + 1) + " -" +  project.investmentOptions[index];
			intOptions[index] = index + 1;
			strOptions[index] = Integer.toString(index + 1);
		}
		header += "\n------------------------";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
