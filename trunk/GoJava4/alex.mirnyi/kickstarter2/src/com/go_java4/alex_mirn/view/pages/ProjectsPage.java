package com.go_java4.alex_mirn.view.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.logic.ProjectsLogic;
import com.go_java4.alex_mirn.view.io.IO;
import com.go_java4.alex_mirn.view.io.InputData;
import com.go_java4.alex_mirn.view.pages.State;

public class ProjectsPage extends AbstractPage{
	private static List<Integer> inputCheck = new ArrayList<Integer>();
	private ProjectsLogic projectsLogic;

	
	public ProjectsPage(IO io, Dao repository) {
		super(io, repository);
		this.projectsLogic = new ProjectsLogic(repository);
		header = "Please enter a number of project for more information"
				+ " or press \"0\" to see project menu:\n\n"
				+ "You have chosen category ";
		exit = "";
	}
	
	public void run(Map<String, String> choice) throws SQLException{
		if (data == "") {
			int categoryChoice = Integer.parseInt(choice.get("categoryChoice"));
			addHeader(projectsLogic.getCategoriesIndex(categoryChoice));
			
			showHeader();
			
			List <Project> projects = projectsLogic.getProjectsInCategory(categoryChoice);
			StringBuilder categoryBuilder = new StringBuilder();
			for (Project project : projects) {
				categoryBuilder.append(project.toString() + "\n");
				inputCheck.add(project.getProjectId());
			}
			String projectsInCategory = (categoryBuilder.toString().trim());
			data += projectsInCategory;
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}
	
	public State makeChoice(Map<String, String> choice) throws IOException, SQLException{
		int projectChoice = new InputData(io).inputData(projectsLogic
				.getProjectsSize());
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

