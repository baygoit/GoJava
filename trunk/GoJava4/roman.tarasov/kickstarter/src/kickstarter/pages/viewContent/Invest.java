package kickstarter.pages.viewContent;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.Project;

public class Invest extends PageView {

	public String getHeader() throws ServiceException {

		Project project = idao.getProjectService().getProjectById(
				imodel.getModelValues().getIntSelectedProject());
		StringBuilder header = new StringBuilder();

		header.append("\n=========================");
		header.append("\n|   invest to project   |");
		header.append("\n=========================");
		header.append("\n");
		header.append("\n  Investment options :");
		int length = project.getInvestmentOptions().length;
		for (int index = 0; index < length; index++) {
			header.append("\n");
			header.append((index + 1));
			header.append(" -");
			header.append(project.getInvestmentOptions()[index]);
		}
		header.append("\n------------------------");
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
