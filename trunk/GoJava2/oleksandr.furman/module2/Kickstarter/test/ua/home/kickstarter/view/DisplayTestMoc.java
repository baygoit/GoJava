package ua.home.kickstarter.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.model.ProjectStorage;
import static org.mockito.Mockito.*;

public class DisplayTestMoc {
	private CategoriesController categoriesController;
	private QuotationsController quotationsController;
	private ProjectsController projectsController;
	private ConsoleOutput consoleOutput;
	private Display display;
	private Map<Integer, Category> categories;
	private Map<Category, List<Project>> projects;
	private ProjectStorage projectStorage;

	@Before
	public void initialize() {
		categoriesController = mock(CategoriesController.class);
		quotationsController = mock(QuotationsController.class);
		projectsController = mock(ProjectsController.class); 
		projectStorage = mock(ProjectStorage.class);
		projectsController = new ProjectsController(projectStorage);
		consoleOutput = mock(ConsoleOutput.class);
		display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);
	}

	@Test
	public void ShouldDisplayQuote() {
 
		Quote quote = new Quote("someQuote");

		// when
		when(quotationsController.getRandomQuoteToView()).thenReturn(quote);

		display.displayQuote();
		verify(consoleOutput).output("someQuote");
	}

	@Before
	public void setUp() {
		categories = new HashMap<Integer, Category>();
		Category category1 = new Category("FakeGames");
		categories.put(1, category1);
		Category category2 = new Category("FakeTechnology");
		categories.put(2, category2);
		Category category3 = new Category("FakeDesign");
		categories.put(3, category3);
		List<Project> pr1 = new ArrayList<Project>();
		pr1.add(new Project("FakeName1", "Fakedescription1", 34534, 34, "linksToVideo1", null));
		pr1.add(new Project("FakeName2", "Fakedescription1", 23123, 345, "linksToVideo1", null));
		pr1.add(new Project("FakeName3", "Fakedescription1", 34534, 67, "linksToVideo1", null));
		List<Project> pr2 = new ArrayList<Project>();
		pr2.add(new Project("FakeName4", "Fakedescription1", 6765, 78, "linksToVideo1", null));
		pr2.add(new Project("FakeName5", "Fakedescription1", 345, 345, "linksToVideo1", null));
		pr2.add(new Project("FakeName6", "Fakedescription1", 7645, 676, "linksToVideo1", null));

		projects = new HashMap<Category, List<Project>>();
		projects.put(categories.get(1), pr1);
		projects.put(categories.get(2), pr2);
	}

	@Test
	public void ShouldDisplayCategories() {

		StringBuilder categoriesContent = new StringBuilder();
		for (Map.Entry<Integer, Category> pair : categories.entrySet()) {
			categoriesContent.append(pair.getKey()).append(" - ").append(pair.getValue().getName()).append("\n");
		}
 
		when(categoriesController.getContentToView()).thenReturn(categoriesContent.toString());
		when(categoriesController.getCategoriesSizeToView()).thenReturn(categories.size());
		display.displayCategories();
		verify(consoleOutput)
				.output("Выберите категорию :\n1 - FakeGames\n2 - FakeTechnology\n3 - FakeDesign\n[Выберите категорию от 1 до 3 или нажмите 0 для выхода из программы]\n ");
	}

	@Test
	public void ShouldDisplayProjects() {

		int projectNumber = 1;
		StringBuilder projectsContent = new StringBuilder();
		for (Project project : projects.get(categories.get(1))) {
			projectsContent.append(projectNumber).append(project.getShortInfo()).append("\n");
			projectNumber++;
		}

		when(projectsController.getSpecificContentToView(categories.get(1))).thenReturn(projectsContent.toString());

		//when(projectsController.passSpecificContentToView(categories.get(1))).thenReturn(projectsContent.toString());
		when(projectStorage.getSpecificProjects(1, categories.get(1))).thenReturn(projectsContent.toString());
		display.displayProjects(categories.get(1));

		verify(consoleOutput).output(
				"1 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓" + "\nНазвание проекта: FakeName1"
						+ "\nОписание проекта: Fakedescription1" + "\nНеобходимая сумма: 34534$"
						+ "\nУже собрали: 0$" + "\nДо окончания сбора средств: 34 дней"
						+ "\n2 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓" + "\nНазвание проекта: FakeName2"
						+ "\nОписание проекта: Fakedescription1" + "\nНеобходимая сумма: 23123$"
						+ "\nУже собрали: 0$" + "\nДо окончания сбора средств: 345 дней"
						+ "\n3 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓" + "\nНазвание проекта: FakeName3"
						+ "\nОписание проекта: Fakedescription1" + "\nНеобходимая сумма: 34534$"
						+ "\nУже собрали: 0$" + "\nДо окончания сбора средств: 67 дней"
						+ "\n[Выберите проект от 1 до 0 или нажмите 0 для возврата к выбору категорий]\n ");
	}

	@Test
	public void ShouldDisplaySpecificProject() {

		int projectNumber = 1;
		StringBuilder projectsContent = new StringBuilder();
		for (Project project : projects.get(categories.get(1))) {
			projectsContent.append(projectNumber).append(project.getShortInfo()).append("\n");
			projectNumber++;
		} 

		when(projectsController.getSpecificProjectToView(2, categories.get(1))).thenReturn(
				projects.get(categories.get(1)).get(1).getFullInfo());

		display.displaySpecificProject(2, categories.get(1));

		verify(consoleOutput).output(
				" - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓" + "\nНазвание проекта: FakeName2"
						+ "\nОписание проекта: Fakedescription1" + "\nНеобходимая сумма: 23123$"
						+ "\nУже собрали: 0$" + "\nДо окончания сбора средств: 345 дней"
						+ "\nИстория проекта: null" + "\nЛинки на видео с демо: linksToVideo1"
						+ "\nВопросы/ответы: null" + "\n0 - возврат в категорию FakeGames, 1 - проинвестировать в проект");
	}
}
