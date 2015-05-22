package org.dens.kikstarter.face;

import java.util.List;

import org.dens.kikstarter.data.Category;
import org.dens.kikstarter.data.Project;

public class ProjectsView implements View {

	private Category choosenCategory;
	private ConsoleScanner scanner = new ConsoleScanner();

	

	public ProjectsView(Category choosenProject) {
		this.choosenCategory = choosenProject;
	}

	@Override
	public void printInfo() {
		List<Project> projets = choosenCategory.getProjets();
		for (int index = 0; index < projets.size(); index++) {
			scanner.printOption(index + 1, projets.get(index).getName());
		}
	}

	@Override
	public void action(ViewState viewState) {
		// 1. choose project
		// 2. if fail print error
		// 3. if 0 go to CategoryView
		// 4. if chosen print project details

		scanner.printLine("Select Project by ID:", false);
		String indexString = scanner.read();
		int input;
		Category category;
		try {
			input = parseInput(indexString);
			if(input == 0){
				viewState.setView(new CategoryView());
				return;
			}
			Project project = choosenCategory.getProjets().get(input - 1);
			scanner.printHeader(project.getName());
			scanner.printLine(project.getDescription(), false);
			
		} catch (Exception ex) {
			scanner.printLine("Incorrect input: " + indexString, false);
		}
	}
	
	private int parseInput(String input) {
		return Integer.valueOf(input);
	}

}
