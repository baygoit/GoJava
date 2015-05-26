package com.go_java4.alex_mirn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.CategoriesLogic;

public class CategoriesLogicTest {
	private List<String> input = new ArrayList<String>();
	private List<String> output = new ArrayList<String>();
	
	public class FakeReader implements Reader {
		@Override
		public String readline() throws IOException {
			return input.remove(0);
		}
		
	}
	
	public class FakePrinter implements Printer {
		@Override
		public void print(String string) {
			output.add(string);
		}
		
		@Override
		public void println(String string) {
			output.add(string);
		}
	}
	
	@Test
//	public void ExitProgramm_whenInputEquals0() {
	public void TestGettingQuote_whenStartCategoriesLogic() {
		QuotesContainer quotes = new QuotesContainer();
		quotes.add(new Quote("Impossible is nothing"));

//		Category medicine = new Category("Medicine");
//		CategoriesContainer categories = new CategoriesContainer();
//		categories.add(medicine);
//
//		Project alcoTester = new Project(medicine, "Alco Tester",
//				"Phenomenal alco test just by scanning your eyes", 50000,
//				23000, 15);
//		alcoTester.setHistory("Far-far away...");
//		alcoTester.setVideoLink("verbohlest.narod.ru");
//		alcoTester.setQuestions("what?");
//		
//		Project eyes = new Project(medicine, "Eyes training device",
//				"Get 100% sight", 100000, 15000, 24);
//		ProjectsContainer projects = new ProjectsContainer();
//		projects.add(eyes);
		CategoriesLogic logic = new CategoriesLogic(new FakePrinter(), 
				new FakeReader(), quotes, 
				new CategoriesContainer(), 
				new ProjectsContainer());
		
		
	}
}
