package goit.nz.kickstartermvc.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import goit.nz.kickstartermvc.controller.CategoryController;
import goit.nz.kickstartermvc.controller.ControllerMessages;
import goit.nz.kickstartermvc.controller.ProjectController;
import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.test.MockStorage;
import goit.nz.kickstartermvc.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ProjectControllerTest {
	@Mock
	ProjectModel model;
	@Mock
	ProjectView view;
	@Mock
	CategoryController parentController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenOnInputThenInputParsingWarning() {

		final List<String> message = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				message.add(str);
				return null;
			}
		}).when(view).showMsg(anyString());

		ProjectController projectController = new ProjectController(model,
				view, parentController);
		int expected = 0;
		int actual = projectController.onInput("test");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.INPUT_NOT_INTEGER_WARNING, message.get(0));
	}

	@Test
	public void whenOnInputZeroThenNegativeMove() {

		ProjectController projectController = new ProjectController(model,
				view, parentController);
		int expected = -1;
		int actual = projectController.onInput("0");

		assertEquals("Illegal move returned", expected, actual);
		verify(view, times(0)).showMsg(anyString());
	}

	@Test
	public void whenOnInputIncorrectChoiceThenWrongChoiceWarning() {

		final List<String> message = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				message.add(str);
				return null;
			}
		}).when(view).showMsg(anyString());

		ProjectController projectController = new ProjectController(model,
				view, parentController);
		int messageIndex = 0;
		int expected = 0;
		int actual = projectController.onInput("-10");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.WRONG_USER_CHOICE_WARNING,
				message.get(messageIndex++));

		expected = 1;
		actual = projectController.onInput("1");

		assertEquals("Illegal move returned", expected, actual);
	}

	@Test
	public void whenOnTakeControlThenModelAndViewUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		String testCategoryName = storage.getCategories().get(3).getName();
		int testProjectIndex = 1;
		when(parentController.getProjectIndex()).thenReturn(testProjectIndex);
		when(parentController.getProjectCategoryName()).thenReturn(
				testCategoryName);

		ProjectController projectController = new ProjectController(model,
				view, parentController);
		projectController.onTakeControl();

		verify(view, times(1)).printProject(model);
		verify(model, times(1)).update(testCategoryName, testProjectIndex);
	}

	@Test
	public void whenAddPaymentThenAmountAddedToProject() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		String testCategoryName = storage.getCategories().get(1).getName();
		int testProjectIndex = 1;
		when(parentController.getProjectCategoryName()).thenReturn(
				testCategoryName);
		when(parentController.getProjectIndex()).thenReturn(testProjectIndex);

		ProjectModel testModel = new ProjectModel(storage);
		ProjectController projectController = new ProjectController(testModel,
				view, parentController);
		projectController.onTakeControl();

		int testAmount = 100;
		projectController.addPayment(testAmount);
		int actual = storage.getProjects(testCategoryName)
				.get(testProjectIndex - 1).getPledgedAmount();
		assertEquals(testAmount, actual);
	}

	@Test
	public void whenAddQuestionThenQuestionAddedToProject() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		String testCategoryName = storage.getCategories().get(2).getName();
		int testProjectIndex = 1;
		when(parentController.getProjectCategoryName()).thenReturn(
				testCategoryName);
		when(parentController.getProjectIndex()).thenReturn(testProjectIndex);

		ProjectModel testModel = new ProjectModel(storage);
		ProjectController projectController = new ProjectController(testModel,
				view, parentController);
		projectController.onTakeControl();

		String testQuestion = "test";
		projectController.addQuestion(testQuestion);
		String actual = storage.getProjects(testCategoryName)
				.get(testProjectIndex - 1).getFAQ().get(0).getQuestion();
		assertEquals(testQuestion, actual);
	}

}
