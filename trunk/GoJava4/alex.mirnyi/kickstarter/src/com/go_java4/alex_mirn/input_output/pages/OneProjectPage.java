package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.Map;

import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.OneProjectLogic;
import com.go_java4.alex_mirn.input_output.pages.State;

public class OneProjectPage extends AbstractPage{

	private OneProjectLogic oneProjectLogic;
	
	public OneProjectPage(Printer printer, Reader reader, Repository repository) {
		super(printer, reader, repository);
		this.printer = printer;
		this.reader = reader;
		this.oneProjectLogic = new OneProjectLogic(repository);
		header = "You have chosen ";
		exit = "To go back to the list of projects press \"0\"";
	}
	
	public void run(Map<String, String> choice) throws IOException{
		if (data == "") {
			int categoryChoice = Integer.parseInt(choice.get("categoryChoice"));
			int projectChoice = Integer.parseInt(choice.get("projectChoice"));
			for (int index = 0; index < oneProjectLogic.getSize(); index++) {
				if (categoryChoice == oneProjectLogic.getProject(index).getCategory().getId()
						&& projectChoice == oneProjectLogic.getProject(index).getProjectId()) {
					showFooter();
					addData(oneProjectLogic.getProjectFullInfo(index));
					showData();
					showExit();
					showFooter();
				}
			}
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}

	public State makeChoice(Map<String, String> choice) throws IOException{
		int goToProjectLIst = new InputData(printer, reader)
		.inputData(oneProjectLogic.getSize());
		if (goToProjectLIst != 0) {
			restartProject();
			makeChoice(choice);
		} else {
			showFooter(); 
		}
		return State.PROJECTS_PAGE;
	}
	
	private void showHeader() {
		printer.println(header);
	}

	private void addData(String project) {
		data += project + "\n";
	}

	private void showData() {
		printer.println(data);
	}

	private void showFooter() {
		printer.println(footer);
	}

	private void showExit() {
		printer.println(exit);
	}

	private void showError() {
		printer.println(error);
	}
	
	private void restartProject() {
		showError();
		showFooter();
		showData();
		showExit();
		showFooter();
	}
}
