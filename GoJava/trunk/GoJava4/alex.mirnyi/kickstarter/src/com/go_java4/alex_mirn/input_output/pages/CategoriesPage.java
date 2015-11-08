package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;




import java.util.Map;

import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.input_output.io.IO;
import com.go_java4.alex_mirn.input_output.io.InputData;
import com.go_java4.alex_mirn.input_output.pages.AbstractPage;
import com.go_java4.alex_mirn.logic.CategoriesLogic;


public class CategoriesPage extends AbstractPage{
	private CategoriesLogic categoriesLogic;

	public CategoriesPage(IO io, 
			Repository repository) {
		super(io, repository);
		this.categoriesLogic = new CategoriesLogic(repository);
		this.header = "Please enter the number of the category you want to choose"
				+ " or press \"0\" to leave the programm:\n";
		this.exit = "Bye";
	}
	
	public void run(Map<String, String> choice) throws IOException{
		if (data == "") {
			addQuote();
			showHeader();
			for (int index = 0; index < categoriesLogic.getSize(); index++) {
				addData(index, categoriesLogic.getIndex(index));
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
		int categoryChoice = new InputData(io).inputData(categoriesLogic.getSize());
		choice.put("categoryChoice", Integer.toString(categoryChoice));
		
		if (categoryChoice == 0) {
			showExit();
			System.exit(0);
			return State.CATEGORIES_PAGE;
		} else {
			return State.PROJECTS_PAGE;
		}
	}

	private void addQuote() {
		header = categoriesLogic.getQuote() + "\n\n" + header;
	}
	
	private void showHeader() {
		io.println(header);
	}

	private void addData(int index, String category) {
		data += Integer.toString(index + 1) + ". " + category + "\n";
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
	
}
