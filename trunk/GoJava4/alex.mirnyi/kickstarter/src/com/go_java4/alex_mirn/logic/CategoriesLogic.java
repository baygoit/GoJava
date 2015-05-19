package com.go_java4.alex_mirn.logic;

import java.io.IOException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;
import com.go_java4.alex_mirn.input_output.pages.ProjectsPage;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.input_output.InputData;

public class CategoriesLogic {
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	private Printer printer;
	private Reader reader;

	public CategoriesLogic(Printer printer, Reader reader, QuotesContainer quotes,
			CategoriesContainer categories, ProjectsContainer projects) {
		this.printer = printer;
		this.reader = reader;
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
		
	public void run() throws IOException {
		CategoriesPage categoriesPage = new CategoriesPage(printer, reader);

		Quote quote = this.quotes.getRandom();
		categoriesPage.addQuote(quote);
		categoriesPage.showHeader();

		for (int index = 0; index < this.getCategories().size(); index++) {
			categoriesPage.addData(index, this.getCategories().get(index));
		}
		categoriesPage.showData();
		categoriesPage.showFooter();

		int categoryChoice = new InputData(printer, reader).inputData(this
				.getCategories().size());
		if (categoryChoice == 0) {
			categoriesPage.showExit();
		} else {
			ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
					new ConsoleReader(), quotes, categories, projects); 
			projectsLogic.run(categoryChoice);	
		}
	}
	
	public CategoriesContainer getCategories() {
		return categories;
	}

	public void setCategories(CategoriesContainer categories) {
		this.categories = categories;
	}
}