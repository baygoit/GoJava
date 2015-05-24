package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Category;

public class CategoriesViewer {

	ProjectsViewer projectsViewer;
	Printer printer;
	ConsoleInputReader reader = new ConsoleInputReader();

	public CategoriesViewer(Printer printer) {
		projectsViewer = new ProjectsViewer(printer);
		this.printer = printer;
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

}
