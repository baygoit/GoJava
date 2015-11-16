package ua.com.goit.gojava7.kickstarter.console;

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

}
