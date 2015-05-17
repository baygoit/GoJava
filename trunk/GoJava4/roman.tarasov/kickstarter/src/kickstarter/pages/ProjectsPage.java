package kickstarter.pages;

import kickstarter.mvc.Model;
import kickstarter.mvc.iNavigator;
import kickstarter.repository.ProjectRepository;

public class ProjectsPage extends Page {
	ProjectRepository projects;
	int targetCategoryID;

	iNavigator navigator;
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int ERROR_PAGE = 3;
	final int END_PAGE = 4;

	public ProjectsPage(ProjectRepository projects, Model model) {
		this.projects = projects;
		navigator = model;
	}

	public void setParameterForPrint(int parameterForPrint) {
		this.parameterForPrint = parameterForPrint;
	}

	public void viewWorkedStatus(int status) {
	}

	public String getHeader() {

		String header = "";
		header += "\n________________________";
		header += "\n|     Projects         |";
		header += "\n|______________________|";
		header += "\n";
		header += projects.printProjectsInfo(parameterForPrint);
		header += "\n------------------------";
		header += "\n  p- previous page";
		return header;
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		navigator.saveCategory(parameterForPrint);
		if (message.equals("p")) {
			navigator.pageWillBe(CATEGORIES);

			return;
		}
		options = projects.getStringOptions();
		optionsInt = projects.getIntOptions();
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					navigator.pageWillBe(DETAILED_PROJECT);

					navigator.setOption(optionsInt[index], options[index]);
					return;
				}
			}
		}
		navigator.savePageBeforeError(PROJECTS);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
