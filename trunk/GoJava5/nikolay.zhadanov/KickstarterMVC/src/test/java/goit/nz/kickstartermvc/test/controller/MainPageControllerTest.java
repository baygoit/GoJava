package goit.nz.kickstartermvc.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import goit.nz.kickstartermvc.controller.ControllerMessages;
import goit.nz.kickstartermvc.controller.MainPageController;
import goit.nz.kickstartermvc.model.MainPageModel;
import goit.nz.kickstartermvc.test.MockStorage;
import goit.nz.kickstartermvc.view.MainPageView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MainPageControllerTest {

	@Mock
	MainPageModel model;
	@Mock
	MainPageView view;

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

		MainPageController mainPageController = new MainPageController(model,
				view);
		int expected = 0;
		int actual = mainPageController.onInput("test");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.INPUT_NOT_INTEGER_WARNING, message.get(0));
	}

	@Test
	public void whenOnInputZeroThenNegativeMoveAndExitMessage() {

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

		MainPageController mainPageController = new MainPageController(model,
				view);
		int expected = -1;
		int actual = mainPageController.onInput("0");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong exit message", ControllerMessages.EXIT_MESSAGE,
				message.get(0));
	}

	@Test
	public void whenOnInputCorrectChoiceThenPositiveMove() {
		when(model.size()).thenReturn(2);

		MainPageController mainPageController = new MainPageController(model,
				view);
		int expected = 1;
		int actual = mainPageController.onInput("1");

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

		MainPageController mainPageController = new MainPageController(model,
				view);
		int messageIndex = 0;
		int expected = 0;
		int actual = mainPageController.onInput("-3");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.WRONG_USER_CHOICE_WARNING,
				message.get(messageIndex++));

		expected = 0;
		actual = mainPageController.onInput("5");

		assertEquals("Illegal move returned", expected, actual);
		assertEquals("Wrong warning message",
				ControllerMessages.WRONG_USER_CHOICE_WARNING,
				message.get(messageIndex++));
	}

	@Test
	public void whenOnTakeControlThenModelAndViewUpdated() {

		MainPageController mainPageController = new MainPageController(model,
				view);
		mainPageController.onTakeControl();

		verify(view, times(1)).printCategories(model);
		verify(model, times(1)).update();
	}

	@Test
	public void whenGetChosenCategoryName() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		MainPageModel mainPageModel = new MainPageModel(storage);
		MainPageController mainPageController = new MainPageController(
				mainPageModel, view);
		mainPageController.onTakeControl();
		mainPageController.onInput("1");

		String expected = storage.getCategories().get(0).getName();
		String actual = mainPageController.getChosenCategoryName();
		assertEquals(expected, actual);
	}

	@Test
	public void whenOnAppStartThenPrintHelloAndModelAndViewUpdated() {

		MainPageController mainPageController = new MainPageController(model,
				view);
		mainPageController.onAppStart();

		verify(view, times(1)).printHelloMsg(model);
		verify(view, times(1)).printCategories(model);
		verify(model, times(1)).update();
	}
}
