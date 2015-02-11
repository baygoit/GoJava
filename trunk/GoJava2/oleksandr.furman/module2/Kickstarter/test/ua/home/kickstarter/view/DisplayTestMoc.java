package ua.home.kickstarter.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ua.home.kickstarter.content.Project;
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

		Map<Integer, Category> categories = new HashMap<Integer, Category>();
		categories.put(1, new Category("FakeGames"));
		categories.put(2, new Category("FakeTechnology"));
		categories.put(3, new Category("FakeDesign"));
		StringBuilder categoriesContent = new StringBuilder();
		for (Map.Entry<Integer, Category> pair : categories.entrySet()) {
			categoriesContent.append(pair.getKey()).append(" - ").append(pair.getValue().getName()).append("\n");
		}
		Display display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);

		when(categoriesController.passContentToView()).thenReturn(categoriesContent.toString());
		when(categoriesController.passCategoriesSizeToView()).thenReturn(categories.size());
		display.displayCategories();
		verify(consoleOutput)
				.output("Выберите категорию :\n1 - FakeGames\n2 - FakeTechnology\n3 - FakeDesign\n[Выберите категорию от 1 до 3 или нажмите 0 для выхода из программы]\n ");
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

		CategoriesController categoriesController = mock(CategoriesController.class);
		QuotationsController quotationsController = mock(QuotationsController.class);
		ProjectsController projectsController = mock(ProjectsController.class);
		ConsoleOutput consoleOutput = mock(ConsoleOutput.class);

		Display display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);
		
		Map<Category, List<Project>> projects = new HashMap<Category, List<Project>>();
		Project project1 = new Project("FakeName1", "Fakedescription1", 34534, 34, "linksToVideo1");
		Project project2 = new Project("FakeName2", "Fakedescription1", 23123, 345, "linksToVideo1");
		Project project3 = new Project("FakeName3", "Fakedescription1", 34534, 67, "linksToVideo1");
		Project project4 = new Project("FakeName4", "Fakedescription1", 6765, 78, "linksToVideo1");
		Project project5 = new Project("FakeName5", "Fakedescription1", 345, 345, "linksToVideo1");
		Project project6 = new Project("FakeName6", "Fakedescription1", 7645, 676, "linksToVideo1");

		Map<Integer, Category> categories = new HashMap<Integer, Category>();
		categories.put(1, new Category("FakeGames"));
		categories.put(2, new Category("FakeTechnology"));
		categories.put(3, new Category("FakeDesign"));

		project1.setCategory(categories.get(1));
		project2.setCategory(categories.get(1));
		project3.setCategory(categories.get(1));
		project4.setCategory(categories.get(2));
		project5.setCategory(categories.get(2));
		project6.setCategory(categories.get(2));
		// when


		when(projectsController.passContentToView()).thenReturn(null);

		display.displayCategories();
		verify(consoleOutput).output("Выберите категорию :\n 1 - FakeGames\n 2 - FakeTechnology\n 3 - FakeDesign");
	}
}
