package goit.nz.kickstartermvc.test.view;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import goit.nz.kickstartermvc.output.Output;
import goit.nz.kickstartermvc.view.PaymentView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class PaymentViewTest {
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
		}).when(output).println(anyString());

		PaymentView paymentView = new PaymentView(output);
		paymentView.showMsg("Test");

		String[] expectedResult = { "", "Test" };
		assertArrayEquals("Wrong msg printed", expectedResult, view.toArray());
	}

	@Test
	public void whenUpdateThenViewUpdated() {
		Map<String, String> testData = new LinkedHashMap<>();
		testData.put("Title 1", "Value 1");
		testData.put("Title 2", "Value 2");

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

		PaymentView paymentView = new PaymentView(output);
		paymentView.update(testData, "Test prompt");
		String[] expectedResult = { "", "Title 1: Value 1", "Title 2: Value 2",
				"", "Test prompt", "(0 - back)" };
		assertArrayEquals("Wrong payment view render", expectedResult,
				view.toArray());
	}

}
