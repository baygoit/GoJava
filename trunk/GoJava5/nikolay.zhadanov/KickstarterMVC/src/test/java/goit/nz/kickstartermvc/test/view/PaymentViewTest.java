package goit.nz.kickstartermvc.test.view;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import goit.nz.kickstartermvc.model.PaymentModel;
import goit.nz.kickstartermvc.output.Output;
import goit.nz.kickstartermvc.test.MockStorage;
import goit.nz.kickstartermvc.view.PaymentView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class PaymentViewTest {
	@Mock
	private Output output;
	@Mock
	private PaymentModel model;

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

		PaymentView paymentView = new PaymentView(output);
		paymentView.showMsg("Test");

		String[] expectedResult = { "", "Test" };
		assertArrayEquals("Wrong msg printed", expectedResult, view.toArray());
	}

	@Test
	public void whenUpdateThenViewUpdated() {
		MockStorage storage = new MockStorage();
		storage.initStorage();
		PaymentModel testModel = new PaymentModel();
		String testCategoryName = storage.getCategories().get(1).getName();
		testModel.update(storage.getProjects(testCategoryName).get(0)
				.getRewardOptions());

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

		PaymentView paymentView = new PaymentView(output);
		paymentView.update(testModel);
		String[] expectedResult = { "", "You can choose such payment options:",
				"-------------------", "[1 - 10 : Cool T-shirt]",
				"[2 - 50 : free beta testing]",
				"[3 - 100 : lifelong title of founder]",
				"[4 - Any other amount]", "(0 - back)" };
		assertArrayEquals("Wrong payment view render", expectedResult,
				view.toArray());
	}

}
