package goit.nz.kickstartermvc.test.view;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Matchers.anyString;
import goit.nz.kickstartermvc.model.MainPageModel;
import goit.nz.kickstartermvc.output.Output;
import goit.nz.kickstartermvc.test.MockStorage;
import goit.nz.kickstartermvc.view.MainPageView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MainPageViewTest {

	@Mock
	private MainPageModel model;
	@Mock
	private Output output;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenPrintHelloMsgThenHelloMsgPrinted() {
		when(model.getRandomQuote()).thenReturn("Test quote");

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				view.add(str);
				return null;
			}
		}).when(output).write(anyString());

		MainPageView mainPageView = new MainPageView(output);
		mainPageView.printHelloMsg(model);
		String expectedResult = "Test quote";
		assertEquals("Wrong quote output", expectedResult, view.get(0));
	}

	@Test
	public void whenPrintCategoriesThenCategoriesPrinted() {
		MockStorage storage = new MockStorage();
		storage.initStorage();

		when(model.getCategories()).thenReturn(storage.getCategories());
		when(model.size()).thenReturn(storage.getCategories().size());

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				view.add(str);
				return null;
			}
		}).when(output).write(anyString());

		MainPageView mainPageView = new MainPageView(output);
		mainPageView.printCategories(model);
		String[] expectedResult = { "", "List of categories:",
				"-------------------", "(1). Arts", "(2). Comics",
				"(3). Crafts", "(4). Games", "",
				"Choose your option [1 - 4] (0 - exit)" };
		assertArrayEquals("Wrong categories render", expectedResult,
				view.toArray());
	}
	
	@Test
	public void whenCategoriesAreNotRecievedFromStorageThenWarningPrinted() {
		MockStorage storage = new MockStorage();

		when(model.getCategories()).thenReturn(storage.getCategories());
		when(model.size()).thenReturn(storage.getCategories().size());

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				view.add(str);
				return null;
			}
		}).when(output).write(anyString());

		MainPageView mainPageView = new MainPageView(output);
		mainPageView.printCategories(model);
		String[] expectedResult = {"", "Categories are not found!", "", "(0 - exit)"};
		assertArrayEquals("Wrong categories render", expectedResult,view.toArray());
	}

	@Test
	public void whenShowMsgThenMsgPrinted() {

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				view.add(str);
				return null;
			}
		}).when(output).write(anyString());

		MainPageView mainPageView = new MainPageView(output);
		mainPageView.showMsg("Test");
		
		String[] expectedResult = {"", "Test"};
		assertArrayEquals("Wrong msg printed", expectedResult, view.toArray());
	}

}
