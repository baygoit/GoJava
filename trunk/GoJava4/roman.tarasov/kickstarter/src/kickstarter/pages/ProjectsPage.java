package kickstarter.pages;


import kickstarter.repository.ProjectRepository;

import kickstarter.ui.UserInterface;

public class ProjectsPage extends Page {
	private UserInterface ui;
	ProjectRepository projects;
	
	int targetCategoryID;
	final int ERROR_PAGE=3;
	final int PROJECTS=1;
	final int DETAILED_PROJECT=2;
	public ProjectsPage(ProjectRepository projects, UserInterface ui) {
		this.projects = projects;
		this.ui = ui;
	}
public void setParameterForPrint(int parameterForPrint){
	this.parameterForPrint=parameterForPrint;
}
	public void print() {
		
		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");

		ui.display(projects.printProjectsInfo(parameterForPrint));
		ui.display("------------------------");
	}
/*
	public Storage<Project> sortProjectsByCategory() {
		Storage<Project> sortedProjects = new EntityStorage<Project>();
		int pointer = projects.length();
		for (int index = 0; index < pointer; index++) {
			if (projects.getEntity(index).categoryID == targetCategoryID) {
				sortedProjects.add(projects.getEntity(index));
			}
		}
		return sortedProjects;
	}
*/
	/*
	void printProjectsInfo(Storage<Project> sortedToSelect) {
		options = new String[sortedToSelect.length()];
		optionsInt=new int[sortedToSelect.length()];
		for (int index = 0; index < sortedToSelect.length(); index++) {
			Project project = sortedToSelect.getEntity(index);
			options[index] = Integer.toString(project.ID);
			optionsInt[index]=project.ID;
			ui.display("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
	}
*/
	public String[] getOptions() {
		return options;
	}
/*
	public void selectProject() {
		Storage<Project> sortedToSelect = sortProjectsByCategory();
		printProjectsInfo(sortedToSelect);
	}
	*/
	public void execute(String message){
		if(message.equals("p")){
			nextPage=1;
			
			return;
		}
		options=projects.getStringOptions();
		optionsInt=projects.getIntOptions();
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					nextPage=DETAILED_PROJECT;
					parameterForPrint=optionsInt[index];
					
					return;
				}
			}
		}
		nextPage=ERROR_PAGE;
	}
}
