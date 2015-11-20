package ua.com.goit.gojava7.kickstarter.console;

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

	

}
