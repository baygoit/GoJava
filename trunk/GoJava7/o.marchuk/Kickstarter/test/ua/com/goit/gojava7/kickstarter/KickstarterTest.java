package ua.com.goit.gojava7.kickstarter;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {
	
	@Mock
	private ConsolePrinter consolePrinter;
	@Mock
	private ConsoleScanner consoleScanner;
	private QuoteStorage quoteStorage;
	@Mock
	private CategoryStorage categoryStorage;
	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteStorage, categoryStorage);

	@Test
	public void testShowCategoriesMenuEntered0SaysBye() {
		kickstarter.showCategoriesMenu();

		verify(consolePrinter).print(contains("Bye"));
	}

	@Test
	public void testShowCategoriesMenuEnter1NoCategoriesAtAll() {
		when(consoleScanner.getInt()).thenReturn(1, 0);

		kickstarter.showCategoriesMenu();

		verify(consolePrinter).print(contains("Bye"));
	}

	@Test
	public void testShowCategoriesMenuEnter1Has1Category() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("category name"));

		when(categoryStorage.getAllCategories()).thenReturn(categories);
		when(consoleScanner.getInt()).thenReturn(1, 0);

		kickstarter.showCategoriesMenu();

		verify(consolePrinter).printCategoryWithProjects(any(Category.class));
		verify(consolePrinter).print(contains("Bye"));
	}

}
