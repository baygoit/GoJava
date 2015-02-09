package ua.home.kickstarter.view;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.model.CategoryStorage;
import ua.home.kickstarter.model.ProjectStorage;

public class DisplayTest {
	FakeConsoleOutput fakeConsoleOutput;
	FakeCategoryStorage categoryStorage = new FakeCategoryStorage();
	FakeCategoriesController categories;
	CategoriesController categories2 = new CategoriesController();
	Category category;
	FakeProjectStorage projectStorage;
	FakeProjectsController fakeProjectsController;

	@Test
	public void ShouldDisplaySpecificProject() {
		Display display = new Display(new QuotationsController(), categories = new FakeCategoriesController(),
				fakeProjectsController = new FakeProjectsController(), fakeConsoleOutput = new FakeConsoleOutput());
		display.displayCategories();

		category = categories.passSpecificContentToView(1);
		display.displayProjects(category);
		// System.out.println(fakeConsoleOutput.getOutput().toString());
		assertEquals(
				"[Выберите категорию :, 1 - FakeGames, 2 - FakeTechnology, 3 - FakeDesign, [Выберите категорию от 1 до 3 или нажмите 0 для выхода из программы]\n"
						+ " , 1 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n"
						+ "Название проекта: FakeName1\n"
						+ "Описание проекта: Fakedescription1\n"
						+ "Необходимая сумма: 34534$\n"
						+ "Собранная сумма: 0$\n"
						+ "До окончания сбора средств: 34 дней, 2 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n"
						+ "Название проекта: FakeName2\n"
						+ "Описание проекта: Fakedescription1\n"
						+ "Необходимая сумма: 23123$\n"
						+ "Собранная сумма: 0$\n"
						+ "До окончания сбора средств: 345 дней, 3 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n"
						+ "Название проекта: FakeName3\n"
						+ "Описание проекта: Fakedescription1\n"
						+ "Необходимая сумма: 34534$\n"
						+ "Собранная сумма: 0$\n"
						+ "До окончания сбора средств: 67 дней, [Выберите проект от 1 до 3 или нажмите 0 для возврата к выбору категорий]\n"
						+ " ]", fakeConsoleOutput.getOutput().toString());
	}

	class FakeConsoleOutput extends ConsoleOutput {
		private List<String> output = new ArrayList<String>();

		@Override
		public void output(String s) {
			output.add(s);
		}

		public List<String> getOutput() {
			return output;
		}
	}

	class FakeProjectStorage extends ProjectStorage {
		private List<Project> projectList;
		private Map<Category, List<Project>> projects;
 
		public FakeProjectStorage() {
			jsonProjectsToList();
			setProjectsCategories();
			putProjectsToMap();
		}

		private void jsonProjectsToList() {
			projectList = new ArrayList<Project>();
			Project project1 = new Project("FakeName1", "Fakedescription1", 34534, 34, "linksToVideo1");
			Project project2 = new Project("FakeName2", "Fakedescription1", 23123, 345, "linksToVideo1");
			Project project3 = new Project("FakeName3", "Fakedescription1", 34534, 67, "linksToVideo1");
			Project project4 = new Project("FakeName4", "Fakedescription1", 6765, 78, "linksToVideo1");
			Project project5 = new Project("FakeName5", "Fakedescription1", 345, 345, "linksToVideo1");
			Project project6 = new Project("FakeName6", "Fakedescription1", 7645, 676, "linksToVideo1");
			projectList.add(project1);
			projectList.add(project2);
			projectList.add(project3);
			projectList.add(project4);
			projectList.add(project5);
			projectList.add(project6);
		}

		private void setProjectsCategories() {
			projects = new HashMap<Category, List<Project>>();
			projectList.get(0).setCategory(categoryStorage.getSpecificContent(1));
			projectList.get(1).setCategory(categoryStorage.getSpecificContent(1));
			projectList.get(2).setCategory(categoryStorage.getSpecificContent(1));
			projectList.get(3).setCategory(categoryStorage.getSpecificContent(2));
			projectList.get(4).setCategory(categoryStorage.getSpecificContent(2));
			projectList.get(5).setCategory(categoryStorage.getSpecificContent(2));
		}

		private void putProjectsToMap() {
			for (int i = 0; i < projectList.size(); i++) {
				if (projects.containsKey(projectList.get(i).getCategory())) {
					projects.get(projectList.get(i).getCategory()).add(projectList.get(i));
				} else {
					ArrayList<Project> projectsList = new ArrayList<Project>();
					projectsList.add(projectList.get(i));
					projects.put(projectList.get(i).getCategory(), projectsList);
				}
			}
		}

		public Map<Category, List<Project>> getContent() {
			return projects;
		}

		public List<Project> getSpecificContent(Category category) {
			return projects.get(category);
		}
	}

	class FakeProjectsController extends ProjectsController {

		public FakeProjectsController() {
			projectStorage = new FakeProjectStorage();
		}

		public Map<Category, List<Project>> passContentToView() {
			return projectStorage.getContent();
		}

		public List<Project> passSpecificContentToView(Category category) {
			return projectStorage.getSpecificContent(category);
		}
	} 

	class FakeCategoryStorage extends CategoryStorage {
		private Map<Integer, Category> categories;

		public FakeCategoryStorage() {
			categories = new HashMap<Integer, Category>();
			categories.put(1, new Category("FakeGames"));
			categories.put(2, new Category("FakeTechnology"));
			categories.put(3, new Category("FakeDesign"));
		}

		public Map<Integer, Category> getContent() {
			return categories;
		}

		public Category getSpecificContent(Integer i) {
			return categories.get(i);
		}
	}

	class FakeCategoriesController extends CategoriesController {

		public Map<Integer, Category> passContentToView() {
			return categoryStorage.getContent();
		}

		public Category passSpecificContentToView(Integer i) {
			return categoryStorage.getSpecificContent(i);
		}
	}
}
