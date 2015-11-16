package ua.com.goit.gojava7.kickstarter.console;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
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

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

	private PrintStream defaultSystemOut;

	@Mock
	private PrintStream printSteam;

	private ConsolePrinter consolePrinter = new ConsolePrinter();

	@Before
	public void setUp() {
		defaultSystemOut = System.out;
		System.setOut(printSteam);

	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
		System.setOut(defaultSystemOut);
	}

	@Test
	public void testPrintString() {
		consolePrinter.print("string");

		verify(printSteam).println("string");
	}

	@Test
	public void testPrintQuote() {
		consolePrinter.print(new Quote("text1", "author"));

		verify(printSteam).println(contains("text"));
		verify(printSteam).println(contains("author"));
		verify(printSteam).println(contains("Quote"));
		verify(printSteam).println();
	}

	@Test
	public void testPrintListCategory() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("category 1"));
		categories.add(new Category("category 2"));
		categories.add(new Category("category 3"));

		consolePrinter.print(categories);

		verify(printSteam).println(contains("category 1"));
		verify(printSteam).println(contains("category 2"));
		verify(printSteam).println(contains("category 3"));
		verify(printSteam).println(contains("All categories:"));
	}

	@Test
	public void testPrintCategory() {
		Category category = new Category("category name");

		consolePrinter.print(category);

		verify(printSteam).println(contains("Category:"));
		verify(printSteam).println(contains("category name"));
	}

	@Test
	public void testPrintProject() {
		Project project = new Project("project name", "short description", 50, 10);
		
		consolePrinter.print(project);
		
		verify(printSteam).println(contains("Project:"));
		verify(printSteam).println(contains("project name"));
		verify(printSteam).println(contains("Short description:"));
		verify(printSteam).println(contains("short description"));
		verify(printSteam).println(contains("Required amount:"));
		verify(printSteam).println(contains("0.5"));
		verify(printSteam).println(contains("Gathered amount:"));
		verify(printSteam).println(contains("Days left:"));
		verify(printSteam).println(contains("10"));
		verify(printSteam).println(contains("History:"));
		verify(printSteam).println(contains("Video:"));
		verify(printSteam).println(contains("Q&As:"));
	}

	@Test
	public void testFormatMoney() {
		assertThat(consolePrinter.formatMoney(0), is("0.00"));
		assertThat(consolePrinter.formatMoney(1), is("0.01"));
		assertThat(consolePrinter.formatMoney(100), is("1.00"));
	}
}
