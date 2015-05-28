package kickstarter.pages.viewContent;

import kickstarter.entities.Project;
import kickstarter.repository.facade.RepositoryException;

public class Invest extends PageView {

	public String getHeader() throws RepositoryException {

		Project project = repository
				.getProjectById(imodel.getModelValues().getIntSelectedProject());
		StringBuilder header = new StringBuilder();

		header.append("\n=========================");
		header.append("\n|   invest to project   |");
		header.append("\n=========================");
		header.append("\n");
		header.append("\n  Investment options :");
		int length = project.getInvestmentOptions().length;
		intValues = new int[length];
		strValues = new String[length];
		for (int index = 0; index < length; index++) {
			header.append("\n");
			header.append((index + 1));
			header.append(" -");
			header.append(project.getInvestmentOptions()[index]);
			intValues[index] = index + 1;
			strValues[index] = Integer.toString(index + 1);
		}
		header.append("\n------------------------");
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
