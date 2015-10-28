package goit.nz.kickstartermvc.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import goit.nz.kickstartermvc.controller.CategoryController;
import goit.nz.kickstartermvc.controller.ControllerMessages;
import goit.nz.kickstartermvc.controller.MainPageController;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.test.MockStorage;
import goit.nz.kickstartermvc.view.CategoryView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CategoryControllerTest {

	@Mock
	CategoryModel model;
	@Mock
	CategoryView view;
	@Mock
	MainPageController parentController;

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

		CategoryController categoryController = new CategoryController(model,
				view, parentController);
		int expected = 0;
		int actual = categoryController.onInput("test");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.INPUT_NOT_INTEGER_WARNING, message.get(0));
	}

	@Test
	public void whenOnInputZeroThenNegativeMove() {

		CategoryController categoryController = new CategoryController(model,
				view, parentController);
		int expected = -1;
		int actual = categoryController.onInput("0");

		assertEquals("Illegal move returned", expected, actual);
		verify(view, times(0)).showMsg(anyString());
	}

	@Test
	public void whenOnInputCorrectChoiceThenPositiveMove() {
		when(model.size()).thenReturn(2);

		CategoryController categoryController = new CategoryController(model,
				view, parentController);
		int expected = 1;
		int actual = categoryController.onInput("1");

		assertEquals("Illegal move returned", expected, actual);
		verify(view, times(0)).showMsg(anyString());
	}

	@Test
	public void whenOnInputIncorrectChoiceThenWrongChoiceWarning() {
		when(model.size()).thenReturn(2);

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

		CategoryController categoryController = new CategoryController(model,
				view, parentController);
		int messageIndex = 0;
		int expected = 0;
		int actual = categoryController.onInput("-3");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.WRONG_USER_CHOICE_WARNING,
				message.get(messageIndex++));

		expected = 0;
		actual = categoryController.onInput("5");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.WRONG_USER_CHOICE_WARNING,
				message.get(messageIndex++));
	}

	@Test
	public void whenOnTakeControlThenModelAndViewUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();
		String testCategoryName = storage.getCategories().get(3).getName();

		when(parentController.getChosenCategoryName()).thenReturn(
				testCategoryName);

		CategoryController categoryController = new CategoryController(model,
				view, parentController);
		categoryController.onTakeControl();

		verify(view, times(1)).printProjects(model, testCategoryName);
		verify(model, times(1)).update(anyString());
		assertEquals(testCategoryName, categoryController.getProjectCategoryName());
	}

	@Test
	public void whenGetChosenProject() {
		MockStorage storage = new MockStorage();
		storage.initStorage();
		String testCategoryName = storage.getCategories().get(3).getName();

		when(parentController.getChosenCategoryName()).thenReturn(
				testCategoryName);

		CategoryModel categoryModel = new CategoryModel(storage);
		CategoryController categoryController = new CategoryController(
				categoryModel, view, parentController);
		categoryController.onTakeControl();
		categoryController.onInput("1");

		String expected = storage.getProjects(testCategoryName).get(0)
				.getName();
		String actual = storage.getProjects(testCategoryName)
				.get(categoryController.getProjectIndex() - 1).getName();
		assertEquals(expected, actual);
	}

}
