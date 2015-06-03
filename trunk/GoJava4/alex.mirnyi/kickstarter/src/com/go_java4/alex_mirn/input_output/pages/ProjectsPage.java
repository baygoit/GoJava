package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.io.IO;
import com.go_java4.alex_mirn.logic.ProjectsLogic;
import com.go_java4.alex_mirn.input_output.pages.State;

public class ProjectsPage extends AbstractPage{
	private static List<Integer> inputCheck = new ArrayList<Integer>();
	private ProjectsLogic projectsLogic;

	
	public ProjectsPage(IO io, Repository repository) {
		super(io, repository);
		this.projectsLogic = new ProjectsLogic(repository);
		header = "Please enter a number of project for more information"
				+ " or press \"0\" to see project menu:\n\n"
				+ "You have chosen category ";
		exit = "";
	}
	
	public void run(Map<String, String> choice){
		if (data == "") {
			int categoryChoice = Integer.parseInt(choice.get("categoryChoice"));
			addHeader(projectsLogic.getCategory(categoryChoice - 1));
			showHeader();
			for (int index = 0; index < projectsLogic.getSize(); index++) {
					if (categoryChoice == projectsLogic.getProject(index).getCategory()
							.getId()) {
					inputCheck.add(index + 1);
					addData(projectsLogic.getProject(index));
				}
			}
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}
	
	public State makeChoice(Map<String, String> choice) throws IOException{
		int projectChoice = new InputData(io).inputData(projectsLogic
				.getSize());
		choice.put("projectChoice", Integer.toString(projectChoice));
		if (projectChoice == 0) {
			showFooter();
			inputCheck.clear();
			return State.CATEGORIES_PAGE;
		} else if (inputCheck.contains(projectChoice)) { 
			return State.ONE_PROJECT_PAGE;
		} else {
			showError();
			showFooter();
			showHeader();
			showData();
			return makeChoice(choice);
		}
	}
	
	private void showHeader() {
		io.println(header);
	}

	private void addHeader(Category category) {
		header += category.toString() + "\n";
	}

	private void addData(Project project) {
		data += project.toString() + "\n";
	}
	
	
	private void showData() {
		io.println(data);
	}

	private void showFooter() {
		io.println(footer);
	}

	private void showError() {
		io.println(error);
	}
}

