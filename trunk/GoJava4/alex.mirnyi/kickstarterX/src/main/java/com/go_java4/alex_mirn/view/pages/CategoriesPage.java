package com.go_java4.alex_mirn.view.pages;

import java.io.IOException;




import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.logic.CategoriesLogic;
import com.go_java4.alex_mirn.view.io.IO;
import com.go_java4.alex_mirn.view.io.InputData;
import com.go_java4.alex_mirn.view.pages.AbstractPage;


public class CategoriesPage extends AbstractPage{
	private CategoriesLogic categoriesLogic;
	private Dao repository;

	public CategoriesPage(IO io, Dao repository) {
		super(io, repository);
		this.repository = repository;
		this.categoriesLogic = new CategoriesLogic(repository);
		this.header = "Please enter the number of the category you want to choose"
				+ " or press \"0\" to leave the programm:\n";
		this.exit = "Bye";
	}
	
	public void run(Map<String, String> choice) throws IOException, SQLException{
		if (data == "") {
			addQuote();
			showHeader();
			addData();
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}
	
	@Override
	public State makeChoice(Map<String, String> choice) throws IOException, SQLException{
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

	public void addQuote() throws SQLException {
		header = categoriesLogic.getQuote() + "\n\n" + header;
	}
	
	private void showHeader() throws SQLException {
		io.println(header);
	}
	
	private void addData() throws SQLException {
		List<Category> categories = categoriesLogic.getAll();
		StringBuilder categoryBuilder = new StringBuilder();
		for (Category category : categories) {
			categoryBuilder.append(category.getId() + ". " + category.toString() + "\n");
		}
		String categoriesAll = categoryBuilder.toString().trim();
		data += categoriesAll;
	}

	
	private void showData() throws SQLException {
		io.println(data);
	}

	private void showFooter() {
		io.println(footer);
	}

	private void showExit() {
		io.println(exit);
	}
}
