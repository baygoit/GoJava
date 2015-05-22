package kickstarter.pages.view;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.repository.fasade.Repository;


public class Invest extends PageView {

	public Invest(Repository repository, iModel imodel) {
		this.repository=repository;
		this.imodel=imodel;
	}

	public String getHeader() {
	
		ModelOptions o = imodel.getModelOptions();
		int projectID=o.intSelectedProject;
		project = repository.getProjectById(projectID);
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
			String option = project.investmentOptions[index];
			header += "\n" + (index + 1) + " -" + option;
			intOptions[index] = index + 1;
			strOptions[index] = Integer.toString(index + 1);
		}
		header += "\n------------------------";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
