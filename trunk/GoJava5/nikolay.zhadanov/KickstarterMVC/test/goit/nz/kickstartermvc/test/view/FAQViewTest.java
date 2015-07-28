package goit.nz.kickstartermvc.test.view;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import goit.nz.kickstartermvc.output.Output;
import goit.nz.kickstartermvc.view.FAQView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FAQViewTest {
	@Mock
	private Output output;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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

		FAQView faqView = new FAQView(output);
		faqView.showMsg("Test");

		String[] expectedResult = { "", "Test" };
		assertArrayEquals("Wrong msg printed", expectedResult, view.toArray());
	}

	@Test
	public void whenUpdateThenViewUpdated() {

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

		FAQView faqView = new FAQView(output);
		faqView.update();
		String[] expectedResult = { "", "Enter your question:", "(0 - back)" };
		assertArrayEquals("Wrong FAQ view render", expectedResult,
				view.toArray());
	}

}
