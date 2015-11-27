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
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryPrinterTest {

	private CategoryPrinter categoryPrinter = new CategoryPrinter();

	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testPrint() {		
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("Category1"));
		categoryPrinter.printCategories(categories);
		verify(printSteam).println(contains("Category1"));
	}
}
