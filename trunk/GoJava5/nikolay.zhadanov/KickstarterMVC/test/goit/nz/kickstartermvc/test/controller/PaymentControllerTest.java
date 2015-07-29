package goit.nz.kickstartermvc.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import goit.nz.kickstartermvc.controller.ControllerMessages;
import goit.nz.kickstartermvc.controller.PaymentController;
import goit.nz.kickstartermvc.controller.ProjectController;
import goit.nz.kickstartermvc.model.PaymentModel;
import goit.nz.kickstartermvc.view.PaymentView;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class PaymentControllerTest {
	@Mock
	PaymentModel model;
	@Mock
	PaymentView view;
	@Mock
	ProjectController parentController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenOnInputThenBack() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);

		int expected = -1;
		int actual = paymentController.onInput("0");
		assertEquals(expected, actual);
	}

	@Test
	public void whenOnInputAndCardHolderNameIsEmptyThenReturnZero() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);
		when(model.isCardHolderNameEmpty()).thenReturn(true);
		when(model.isCardHolderNameValid(anyString())).thenReturn(false);
		when(model.getChosenRewardOptionIndex()).thenReturn(1);

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

		int expected = 0;
		int actual = paymentController.onInput("test");
		assertEquals(expected, actual);
		assertEquals(ControllerMessages.INPUT_WRONG_CARDHOLDER_NAME,
				message.get(0));

		when(model.isCardHolderNameEmpty()).thenReturn(true);
		when(model.isCardHolderNameValid(anyString())).thenReturn(true);

		actual = paymentController.onInput("test");
		assertEquals(expected, actual);
	}

	@Test
	public void whenOnInputAndCardNumberIsEmptyThenReturnZero() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);
		when(model.isCardHolderNameEmpty()).thenReturn(false);
		when(model.isCardNumberEmpty()).thenReturn(true);
		when(model.isCardNumberValid(anyString())).thenReturn(false);
		when(model.getChosenRewardOptionIndex()).thenReturn(1);

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

		int expected = 0;
		int actual = paymentController.onInput("test");
		assertEquals(expected, actual);
		assertEquals(ControllerMessages.INPUT_WRONG_CARD_NUMBER, message.get(0));

		when(model.isCardHolderNameEmpty()).thenReturn(false);
		when(model.isCardNumberEmpty()).thenReturn(true);
		when(model.isCardNumberValid(anyString())).thenReturn(true);

		actual = paymentController.onInput("test");
		assertEquals(expected, actual);
	}

	@Test
	public void whenOnInputWrongPaymentThenReturnZero() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);
		when(model.isCardHolderNameEmpty()).thenReturn(false);
		when(model.isCardNumberEmpty()).thenReturn(false);
		when(model.isPaymentComplete()).thenReturn(false);
		when(model.getChosenRewardOptionIndex()).thenReturn(1);

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
		int messageIndex = 0;

		int expected = 0;
		int actual = paymentController.onInput("test");
		assertEquals(expected, actual);
		assertEquals(ControllerMessages.INPUT_NOT_INTEGER_WARNING,
				message.get(messageIndex++));

		actual = paymentController.onInput("-100");
		assertEquals(expected, actual);
		assertEquals(ControllerMessages.INPUT_WRONG_PLEDGE_AMOUNT,
				message.get(messageIndex));
	}

	@Test
	public void whenOnInputCorrectPaymentThenPrintThanksAndUpdateProject() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);
		when(model.isCardHolderNameEmpty()).thenReturn(false);
		when(model.isCardNumberEmpty()).thenReturn(true);
		when(model.getChosenRewardOptionIndex()).thenReturn(1);
		when(model.isPaymentComplete()).thenReturn(true);

		int expected = 0;
		int actual = paymentController.onInput("100139688596");
		assertEquals(expected, actual);
		verify(parentController, times(1)).addPayment(anyInt());
		verify(view, times(1)).update(model);
	}

	@Test
	public void whenOnTakeControlThenViewUpdated() {

		PaymentController paymentController = new PaymentController(model,
				view, parentController);

		paymentController.onTakeControl();
		verify(view, times(1)).update(model);
	}

}
