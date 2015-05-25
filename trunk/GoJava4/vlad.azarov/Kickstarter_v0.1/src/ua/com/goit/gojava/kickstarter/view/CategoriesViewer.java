package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.model.Repository;
import ua.com.goit.gojava.kickstarter.model.pages.PageId;

public class CategoriesViewer {

	ProjectsViewer projectsViewer;
	Printer printer;
	Repository repository; 

	public CategoriesViewer(Printer printer) {
		projectsViewer = new ProjectsViewer(printer);
		this.printer = printer;
		repository = new ProjectsRepository();
	}

	public void showCategories() {
		
	}

	public void showCategoryMenu() {
		StringBuilder categoryMenu = new StringBuilder();
		categoryMenu.append("====================================================================\n");
		categoryMenu.append("Categories:\n");
		categoryMenu.append(getAllCategories());
		categoryMenu.append("--------------------------------------------------------------------\n");
		printer.println(categoryMenu.toString());
	}
	
	private String getAllCategories(){
		StringBuilder result = new StringBuilder();
		int index = 1;
		for (Category category : Category.values()){
			result.append(" ["+index+"] ");
			result.append(category);
			result.append("\n");
			index++;
		}
		return result.toString();
	}

	public void showCategoryWithProjects(Category category) {
		StringBuilder categoryWithProjects = new StringBuilder();
		categoryWithProjects.append("\nCategory: "+category+" \n");
		categoryWithProjects.append("Projects:\n");
		categoryWithProjects.append(getProjectsOfCategory(category));
		printer.println(categoryWithProjects.toString());
	}
	
	
	public String getProjectsOfCategory(Category category) {
		StringBuilder result = new StringBuilder();
		for (Project project : repository.getProjectsOfCategoryArray(category)){
			result.append("["+project.getId()+"] "+project.getName()+"/n");
			result.append("   "+project.getShortDescription());
		}
		return result.toString();
	}

}
