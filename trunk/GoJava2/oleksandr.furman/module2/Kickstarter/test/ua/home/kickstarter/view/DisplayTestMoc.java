package ua.home.kickstarter.view;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import static org.mockito.Mockito.*;

public class DisplayTestMoc {
	@Test
	public void ShouldDisplayCategories() {

		CategoriesController categoriesController = mock(CategoriesController.class);
		QuotationsController quotationsController = mock(QuotationsController.class);
		ProjectsController projectsController = mock(ProjectsController.class);
		ConsoleOutput consoleOutput = mock(ConsoleOutput.class);

		Display display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);

		Map<Integer, Category> categories = new HashMap<Integer, Category>();
		categories.put(1, new Category("FakeGames"));
		categories.put(2, new Category("FakeTechnology"));
		categories.put(3, new Category("FakeDesign"));

		when(categoriesController.passContentToView()).thenReturn(categories);

		display.displayCategories();
		verify(consoleOutput).output("Выберите категорию :\n 1 - FakeGames\n 2 - FakeTechnology\n 3 - FakeDesign");
	}

	@Test
	public void ShouldDisplayQuote() {

		CategoriesController categoriesController = mock(CategoriesController.class);
		QuotationsController quotationsController = mock(QuotationsController.class);
		ProjectsController projectsController = mock(ProjectsController.class);
		ConsoleOutput consoleOutput = mock(ConsoleOutput.class);

		Quote quote = new Quote("someQuote");
		Display display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);

		// when
		when(quotationsController.passRandomQuoteToView()).thenReturn(quote);

		display.displayQuote();
		verify(consoleOutput).output("someQuote");
	}

	@Test
	public void ShouldDisplayProjects() {

	}
}
