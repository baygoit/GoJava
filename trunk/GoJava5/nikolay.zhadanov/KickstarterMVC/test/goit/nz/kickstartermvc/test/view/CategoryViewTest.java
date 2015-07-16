package goit.nz.kickstartermvc.test.view;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.output.Output;
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

public class CategoryViewTest {
	@Mock
	private CategoryModel model;
	@Mock
	private Output output;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenPrintProjectsThenProjectsPrinted() {
		MockStorage storage = new MockStorage();
		storage.init();
		String testCategoryName = "Crafts";
		int testModelSize = storage.getProjects(testCategoryName).size();

		when(model.size()).thenReturn(testModelSize);
		when(model.getCategoryName()).thenReturn(testCategoryName);
		when(model.getProjects()).thenReturn(
				storage.getProjects(testCategoryName));

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				System.out.println(str);
				view.add(str);
				return null;
			}
		}).when(output).println(anyString());

		CategoryView categoryView = new CategoryView(output);
		categoryView.printProjects(model);
		String[] expectedResult = {
				"",
				"Projects in category: \"CRAFTS\"",
				"-------------------",
				"(1). name3",
				"     Description: desc3",
				"     Goal: 100",
				"     Pledged: 90",
				"     Days to go: 15",
				"",
				String.format("Choose your option [1 - %d] (0 - back)",
						testModelSize) };
		assertArrayEquals("Wrong projects layout", expectedResult,
				view.toArray());
	}
	
	@Test
	public void whenCategoryHasNoProjectsThenWarningPrinted() {
		MockStorage storage = new MockStorage();
		storage.init();
		String testCategoryName = "Art";
		int testModelSize = storage.getProjects(testCategoryName).size();

		when(model.size()).thenReturn(testModelSize);
		when(model.getCategoryName()).thenReturn(testCategoryName);
		when(model.getProjects()).thenReturn(
				storage.getProjects(testCategoryName));

		final List<String> view = new ArrayList<>();

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String str = (String) arguments[0];
				System.out.println(str);
				view.add(str);
				return null;
			}
		}).when(output).println(anyString());

		CategoryView categoryView = new CategoryView(output);
		categoryView.printProjects(model);
		String[] expectedResult = {
				"",
				"There are no projects of category \"ART\"",
				"",
				"(0 - back)" };
		assertArrayEquals("Wrong empty project list warning", expectedResult,
				view.toArray());
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
		}).when(output).println(anyString());

		CategoryView categoryView = new CategoryView(output);
		categoryView.showMsg("Test");
		
		String[] expectedResult = {"", "Test"};
		assertArrayEquals("Wrong msg printed", expectedResult, view.toArray());
	}

}
