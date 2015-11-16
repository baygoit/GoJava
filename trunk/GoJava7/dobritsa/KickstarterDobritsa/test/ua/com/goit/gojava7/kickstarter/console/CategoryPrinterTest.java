package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

@RunWith(MockitoJUnitRunner.class)
public class CategoryPrinterTest {

	private CategoryPrinter categoryPrinter = new CategoryPrinter();
	private PrintStream systemOut;

	@Before
	public void setUp() {
		systemOut = System.out;
	}
	
	@After
	public void tearDown() {
		System.setOut(systemOut);
	}

	
	@Test
	public void testPrint() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("Category1"));
		categoryPrinter.printCategories(categories);
		verify(printSteam).println(contains("Category1"));
	}
	
	@Test
	public void testPrintProjects() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		Category category = new Category("Category1");
		Project project1 = new Project("NameTest", "DescriptionTest", 1000000, 10000, 10, "HistoryTest", "LinkTest", "QuestionsTest");
		category.add(project1);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);

		categoryPrinter.printProjects(categories.get(0).getAll());
		verify(printSteam).println(contains("NameTest"));
		verify(printSteam).println(contains("DescriptionTest"));
		verify(printSteam).println(endsWith("10"));
	}

}
