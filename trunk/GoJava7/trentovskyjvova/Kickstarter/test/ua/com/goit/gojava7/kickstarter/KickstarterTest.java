package ua.com.goit.gojava7.kickstarter;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

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
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;


@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {
	@Mock
	private ConsolePrinter consolePrinter;
	@Mock
	private ConsoleScanner consoleScanner;
	@Mock
	private QuoteStorage quoteStorage;
	@Mock
	private CategoryStorage categoryStorage;
	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteStorage, categoryStorage);
	
	@Test
	public void testShowCategoriesMenuEntered0SaysBye() {
		kickstarter.runKickstarter();

		verify(consolePrinter).print("Goodbye!");
	}

	@Test
	public void testShowCategoriesMenuEnter1NoCategoriesAtAll() {
		when(consoleScanner.scan()).thenReturn(1, 0);

		kickstarter.runKickstarter();

		verify(consolePrinter).print("Goodbye!");
	}

	@Test
	public void testShowCategoriesMenuEnter1Has1Category() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("category name"));
		
		when(categoryStorage.getAllCategories()).thenReturn(categories);
		when(consoleScanner.scan()).thenReturn(1, 0);

		kickstarter.runKickstarter();
		
		verify(consolePrinter, times(2)).print(contains("1 : category name"));
		verify(consolePrinter).print("Goodbye!");
	}
	
	@Test
	public void testShowProjectsMenuEnter1Has1Project() {
		List<Category> categories = new ArrayList<Category>();
		Category category = new Category("category name");
		category.addProject(new Project("project 1"));
		categories.add(category);
		
		when(categoryStorage.getAllCategories()).thenReturn(categories);
		when(consoleScanner.scan()).thenReturn(1, 6, 0, 1, 0);

		kickstarter.runKickstarter();
		
		verify(consolePrinter, times(3)).print(contains("1 : category name"));
		verify(consolePrinter).print(contains("Please, enter the number between 0 and"));
		verify(consolePrinter, times(2)).print(contains("project 1"));
		verify(consolePrinter).print("Goodbye!");
	}
}
