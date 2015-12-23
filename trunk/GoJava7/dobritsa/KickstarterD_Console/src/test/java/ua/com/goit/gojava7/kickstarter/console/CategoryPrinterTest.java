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
	List<Category> categories = new ArrayList<Category>();
	
	
	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {
		Category category = new Category();
		category.setName("TestName");
		categories.add(category);
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);		
	}

	@Test
	public void testPrint() {				
		categoryPrinter.printCategories(categories);
		verify(printSteam).println(contains("TestName"));
	}
}
