package ua.home.kickstarter.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Project;

public class ProjectsControllerTest {
	ProjectsController projectsController;
	List<Project> list;
	private Project project1;
	private Project project2;

	@Before
	public void setUp() {
		projectsController = new ProjectsController();
		list = new ArrayList<Project>();
		project1 = new Project();
		project1.setId(1);
		project1.setName("TestProject1");
		project1.setDescription("TestDescription1");
		project1.setGoal(70000);
		project1.setPledged(5);
		project1.setDaysLeft(45);
		project1.setLinksToVideo("SomeLinks1");
		project1.setHistory("history1");
		project1.setQuestionAnswers("questionAnswers1");
		project2 = new Project();
		project2.setId(1);
		project2.setName("TestProject2");
		project2.setDescription("TestDescription2");
		project2.setGoal(706890);
		project2.setPledged(435);
		project2.setDaysLeft(23);
		project2.setLinksToVideo("SomeLinks2");
		project2.setHistory("history2");
		project2.setQuestionAnswers("questionAnswers2");
		list.add(project1);
		list.add(project2);
	}

	@Test
	public void shouldReturnProjectsInString_whenCallGetProjectsContent() {
		String expected = "1 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\nНазвание проекта: TestProject1"
				+ "\nОписание проекта: TestDescription1\nНеобходимая сумма: 70000$\nУже собрали: 5$"
				+ "\nДо окончания сбора средств: 45 дней\n2 - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓"
				+ "\nНазвание проекта: TestProject2\nОписание проекта: TestDescription2"
				+ "\nНеобходимая сумма: 706890$\nУже собрали: 435$\nДо окончания сбора средств: 23 дней\n";
		assertEquals(expected, projectsController.getProjectsContent(list));
	}

	@Test
	public void shouldReturnProjectInString_whenCallGetSpecificProjectContent() {
		String expected = " - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\nНазвание проекта: TestProject1"
				+ "\nОписание проекта: TestDescription1\nНеобходимая сумма: 70000$\nУже собрали: 5$"
				+ "\nДо окончания сбора средств: 45 дней\nИстория проекта: history1\nЛинки на видео с демо: SomeLinks1"
				+ "\nВопросы/ответы: questionAnswers1";
		assertEquals(expected, projectsController.getSpecificProjectContent(project1));
	}
}
