package ua.com.goit.gojava7.kickstarter;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {
	
	@Mock
	private ConsolePrinter consolePrinter;
	@Mock
	private ConsoleScanner consoleScanner;
	private QuoteDao quoteStorage;
	@Mock
	private CategoryStorage categoryStorage;
	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteStorage, categoryStorage);

	@Test
	public void testShutdown() {
		kickstarter.shutdown();

		verify(consoleScanner).close();
	}

	@Test
	public void testShowCategoriesMenuEntered0SaysBye() {
		kickstarter.showCategoriesMenu();

		verify(consolePrinter).print(contains("Bye"));
	}

	@Test
	public void testShowCategoriesMenuEnter1NoCategoriesAtAll() {
		when(consoleScanner.getInt()).thenReturn(1, 0);

		kickstarter.showCategoriesMenu();

		verify(consolePrinter).print(contains("Please, enter the number between"));
		verify(consolePrinter).print(contains("Bye"));
	}

	@Test
	public void testShowCategoriesMenuEnter_1NoCategoriesAtAll() {
		when(consoleScanner.getInt()).thenReturn(-1, 0);

		kickstarter.showCategoriesMenu();

		verify(consolePrinter).print(contains("Please, enter the number between"));
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

	// cut
	@Test
	public void testShowProjectsMenuEntered0SaysBye() {
		Category selectedCategory = new Category("category name");

		kickstarter.showProjectsMenu(selectedCategory);

		verify(consolePrinter).print(contains("Go up"));
	}

	@Test
	public void testShowProjectsMenuEnter1NoProjectsAtAll() {
		Category selectedCategory = new Category("category name");

		when(consoleScanner.getInt()).thenReturn(1, 0);

		kickstarter.showProjectsMenu(selectedCategory);

		verify(consolePrinter).print(contains("Please, enter the number between"));
		verify(consolePrinter).print(contains("Go up"));
	}

	@Test
	public void testShowProjectsMenuEnter_1NoProjectsAtAll() {
		Category selectedCategory = new Category("category name");

		when(consoleScanner.getInt()).thenReturn(-1, 0);

		kickstarter.showProjectsMenu(selectedCategory);

		verify(consolePrinter).print(contains("Please, enter the number between"));
		verify(consolePrinter).print(contains("Go up"));
	}

	@Test
	public void testShowProjectsMenuEnter1Has1Project() {
		Category selectedCategory = new Category("category name");

		Set<Project> projects = new HashSet<Project>();
		projects.add(new Project("project name", "short description", 50, 10));

		selectedCategory.setProjects(projects);

		when(consoleScanner.getInt()).thenReturn(1, 0);

		kickstarter.showProjectsMenu(selectedCategory);

		verify(consolePrinter, times(2)).printCategoryWithProjects(any(Category.class));
		verify(consolePrinter).print(contains("You selected the project number"));
		verify(consolePrinter, times(2)).print(contains("Go up"));
	}

}
