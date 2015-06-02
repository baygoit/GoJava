package com.go_java4.alex_mirn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.FileRepository;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.data_containers.TestRepository;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.CategoriesLogic;
import com.go_java4.alex_mirn.logic.ILogic;
import com.go_java4.alex_mirn.logic.ProjectsLogic;
import com.go_java4.alex_mirn.logic.OneProjectLogic;
import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
import com.go_java4.alex_mirn.input_output.pages.PageDispatcher;
import com.go_java4.alex_mirn.input_output.pages.ProjectsPage;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;


public class Launcher {
	public static void main(String[] args) throws IOException {	
		Repository repository = new FileRepository();
//		Repository repository = new TestRepository();
		PageDispatcher pageDispatcher = new PageDispatcher(new ConsolePrinter(),
				new ConsoleReader(), repository);
		pageDispatcher.run();
		
	}

}
