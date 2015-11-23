package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;


@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

	private PrintStream defaultSystemOut;
	
	@Mock
	private PrintStream printStream;
	
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	
	@Before
	public void setup() {
		defaultSystemOut = System.out;
		System.setOut(printStream);
	}
	
	/*
	@After
	public void teardown() {
		verifyNoMoreInteractions(printStream);
		System.setOut(defaultSystemOut);
	}
	*/
	
	@Test
	public void testPrintString() {
		consolePrinter.print("string");
	}

	@Test
	public void testPrintQuote() {
		consolePrinter.print(new Quote("quote", "author"));
	}
	
	@Test
	public void testPrintListCategories() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category("1"));
		categories.add(new Category("2"));
		categories.add(new Category("3"));
		
		consolePrinter.printCategories(categories);
		
		verify(printStream).println(contains("1"));
	}
	
	@Test
	public void testPrintCategory() {
		Category category = new Category("category");
		consolePrinter.print(category);
		verify(printStream).println(contains("Category: "));
		verify(printStream).println(contains("category"));
	}
	
	@Test
	public void testPrintProject() {
		Project project = new Project("name", "summary", 40L, 35);
		
		consolePrinter.print(project);
		
		verify(printStream).println(contains("Project: "));
		verify(printStream).println(contains("\t Info: "));
		verify(printStream).println(contains("\t Goal: "));
		verify(printStream).println(contains("\t Pledged: "));
		verify(printStream).println(contains("\t Days to go: "));
		verify(printStream).println(contains("\t History of the project: "));
		verify(printStream).println(contains("\t Video link: "));
		verify(printStream).println(contains("\t Q&A: "));
	}
	
	@Test
	public void testPrintProjectsInCategory() {
		Category category = new Category("category");
		List<Project> projectsInCategory = new ArrayList<>();
		projectsInCategory.add(new Project("project", "summary", 14L, 99));
		
		consolePrinter.print(category, projectsInCategory);
		
		verify(printStream).println(contains("Projects in category:"));
		verify(printStream).println(contains("1. project"));
		verify(printStream).println(contains("\t Summary: summary"));
		verify(printStream).println(contains("\t Goal: " + 14L));
		verify(printStream).println(contains("\t Pledged: "));
		verify(printStream).println(contains("\t Days to go: " + 99));
	}
}