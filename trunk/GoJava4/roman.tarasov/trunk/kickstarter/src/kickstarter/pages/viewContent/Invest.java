package kickstarter.pages.viewContent;

import kickstarter.repository.facade.RepositoryException;

public class Invest extends PageView {

	public String getHeader() throws RepositoryException {

		project = repository
				.getProjectById(imodel.getModelOptions().intSelectedProject);
		StringBuilder header = new StringBuilder();

		header.append("\n=========================");
		header.append("\n|   invest to project   |");
		header.append("\n=========================");
		header.append("\n");
		header.append("\n  Investment options :");
		int length = project.investmentOptions.length;
		intOptions = new int[length];
		strOptions = new String[length];
		for (int index = 0; index < length; index++) {
			header.append("\n");
			header.append((index + 1));
			header.append(" -");
			header.append(project.investmentOptions[index]);
			intOptions[index] = index + 1;
			strOptions[index] = Integer.toString(index + 1);
		}
		header.append("\n------------------------");
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
