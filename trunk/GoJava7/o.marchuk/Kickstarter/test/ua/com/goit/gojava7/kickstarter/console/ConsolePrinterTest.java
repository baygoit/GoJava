package ua.com.goit.gojava7.kickstarter.console;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

	private ConsolePrinter consolePrinter = new ConsolePrinter();
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
	public void testPrintString() {
		PrintStream printSteam = mock(PrintStream.class);

		System.setOut(printSteam);

		consolePrinter.print("string");

		verify(printSteam).println("string");
	}

	@Test
	public void testPrintQuote() {
		PrintStream printSteam = mock(PrintStream.class);

		System.setOut(printSteam);

		consolePrinter.print(new Quote("text1", "author"));

		verify(printSteam).println(contains("text"));
		verify(printSteam).println(contains("author"));
		verify(printSteam).println(contains("Quote"));
	}

	@Test
	public void testPrintListCategory() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("category 1"));
		categories.add(new Category("category 2"));
		categories.add(new Category("category 3"));

		PrintStream printSteam = mock(PrintStream.class);

		System.setOut(printSteam);

		consolePrinter.print(categories);

		verify(printSteam).println(contains("category 1"));
		verify(printSteam).println(contains("category 2"));
		verify(printSteam).println(contains("All categories:"));

		verifyNoMoreInteractions(printSteam);
	}

}
