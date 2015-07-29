package goit.nz.kickstartermvc.test.model;

import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.test.MockStorage;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectModelTest {

	@Test
	public void whenUpdateThenModelIsUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		ProjectModel model = new ProjectModel(storage);
		String testCategoryName = storage.getCategories().get(1).getName();
		int testProjectIndex = 1;
		model.update(testCategoryName, testProjectIndex);
		String expected = "name1";
		String actual = model.getProject().getName();
		assertEquals(expected, actual);
	}

	@Test
	public void whenAddPledgedAmountThenAmountAddedToProject() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		ProjectModel model = new ProjectModel(storage);
		String testCategoryName = storage.getCategories().get(1).getName();
		int testProjectIndex = 1;
		int testAmount = 100;
		model.updatePledgedAmount(testCategoryName, testProjectIndex,
				testAmount);
		int expected = testAmount;
		int actual = storage.getProjects(testCategoryName)
				.get(testProjectIndex - 1).getPledgedAmount();
		assertEquals(expected, actual);
	}

	@Test
	public void whenAddQuestionThenQuestionAddedToProject() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		ProjectModel model = new ProjectModel(storage);
		String testCategoryName = storage.getCategories().get(2).getName();
		int testProjectIndex = 1;
		String testQuestion = "test";
		model.addQuestion(testCategoryName, testProjectIndex, testQuestion);
		String expected = testQuestion;
		String actual = storage.getProjects(testCategoryName)
				.get(testProjectIndex - 1).getFAQ().get(0).getQuestion();
		assertEquals(expected, actual);
	}

}
