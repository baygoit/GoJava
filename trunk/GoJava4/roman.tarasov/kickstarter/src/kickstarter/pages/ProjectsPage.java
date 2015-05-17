package kickstarter.pages;

import kickstarter.mvc.Model;
import kickstarter.mvc.iNavigator;
import kickstarter.repository.ProjectRepository;

public class ProjectsPage extends Page {
	ProjectRepository projects;
	int targetCategoryID;
	
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	iNavigator navigator;
	final int THIS_PAGE=1;    //projects
	final int NEXT_PAGE=2;    //detailed project
	final int PREVIOUS_PAGE=0;//categories
	final int ERROR_PAGE = 3; //error page

	public ProjectsPage(ProjectRepository projects, Model model) {
		this.projects = projects;
		navigator=model;
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
		if (message.equals("p")) {
			navigator.pageWillBe(PREVIOUS_PAGE);

			return;
		}
		options = projects.getStringOptions();
		optionsInt = projects.getIntOptions();
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					navigator.pageWillBe(NEXT_PAGE);
					
					navigator.setOption(optionsInt[index],options[index]);
					return;
				}
			}
		}
		navigator.pageWillBe(ERROR_PAGE);
	}
}
/*
 * public Storage<Project> sortProjectsByCategory() { Storage<Project>
 * sortedProjects = new EntityStorage<Project>(); int pointer =
 * projects.length(); for (int index = 0; index < pointer; index++) { if
 * (projects.getEntity(index).categoryID == targetCategoryID) {
 * sortedProjects.add(projects.getEntity(index)); } } return sortedProjects; }
 */
/*
 * void printProjectsInfo(Storage<Project> sortedToSelect) { options = new
 * String[sortedToSelect.length()]; optionsInt=new int[sortedToSelect.length()];
 * for (int index = 0; index < sortedToSelect.length(); index++) { Project
 * project = sortedToSelect.getEntity(index); options[index] =
 * Integer.toString(project.ID); optionsInt[index]=project.ID; ui.display("ID:<"
 * + project.ID + "> name:<" + project.name + "> short desc.:<" +
 * project.shortDescription + "> goal:<" + project.goal + "> pledged:<" +
 * project.pledged + "> days to go:<" + project.daysToGo + ">"); } }
 */
/*
 * public void selectProject() { Storage<Project> sortedToSelect =
 * sortProjectsByCategory(); printProjectsInfo(sortedToSelect); }
 */