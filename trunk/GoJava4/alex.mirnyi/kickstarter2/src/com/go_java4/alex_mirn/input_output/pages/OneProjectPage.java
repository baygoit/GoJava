package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.input_output.io.IO;
import com.go_java4.alex_mirn.input_output.io.InputData;
import com.go_java4.alex_mirn.logic.OneProjectLogic;
import com.go_java4.alex_mirn.input_output.pages.State;

public class OneProjectPage extends AbstractPage{
	private OneProjectLogic oneProjectLogic;
	
	public OneProjectPage(IO io, Dao repository) {
		super(io, repository);
		this.io = io;
		this.oneProjectLogic = new OneProjectLogic(repository);
		header = "You have chosen ";
		exit = "To go back to the list of projects press \"0\"";
	}
	
	public void run(Map<String, String> choice) throws IOException, SQLException{
		if (data == "") {
			int categoryChoice = Integer.parseInt(choice.get("categoryChoice"));
			int projectChoice = Integer.parseInt(choice.get("projectChoice"));
			Project project = repository.getProjectIndex(projectChoice);
			showFooter();
			addData(project.fullInfo());
			showData();
			showExit();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}

	public State makeChoice(Map<String, String> choice) throws IOException{
		int goToProjectLIst = new InputData(io)
		.inputData(1);
		if (goToProjectLIst != 0) {
			restartProject();
			makeChoice(choice);
		} else {
			showFooter(); 
		}
		return State.PROJECTS_PAGE;
	}
	
	private void showHeader() {
		io.println(header);
	}

	private void addData(String project) {
		data += project + "\n";
	}

	private void showData() {
		io.println(data);
	}

	private void showFooter() {
		io.println(footer);
	}

	private void showExit() {
		io.println(exit);
	}

	private void showError() {
		io.println(error);
	}
	
	private void restartProject() {
		showError();
		showFooter();
		showData();
		showExit();
		showFooter();
	}
}
