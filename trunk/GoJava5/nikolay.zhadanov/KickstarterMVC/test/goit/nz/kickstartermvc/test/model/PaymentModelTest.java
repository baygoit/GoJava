package goit.nz.kickstartermvc.test.model;

import goit.nz.kickstartermvc.model.PaymentModel;
import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentModelTest {

	@Test
	public void whenModelConstructorThenEmpty() {

		PaymentModel model = new PaymentModel();

		assertTrue(model.isCardHolderNameEmpty());
		assertTrue(model.isCardNumberEmpty());

		int expected = 0;
		int actual = model.getAmountPayed();
		assertEquals(expected, actual);
	}

	@Test
	public void whenClearThenModelDataIsCleared() {

		PaymentModel model = new PaymentModel();
		model.setAmountPayed(100);
		model.setCardHolderName("Test");
		model.setCardNumber("1111");

		assertEquals(100, model.getAmountPayed());
		assertTrue(!model.isCardHolderNameEmpty());
		assertTrue(!model.isCardNumberEmpty());

		model.clear();
		assertEquals(0, model.getAmountPayed());
		assertTrue(model.isCardHolderNameEmpty());
		assertTrue(model.isCardNumberEmpty());
	}
	
	@Test
	public void whenIsCardHolderNameValid() {
		String validTestName = "John Smith";
		String nonValidTestName = "Jfe9843jthdfv";
		
		PaymentModel model = new PaymentModel();
		assertTrue(model.isCardHolderNameValid(validTestName));
		assertTrue(!model.isCardHolderNameValid(nonValidTestName));
	}
	
	@Test
	public void whenIsCardNumberValid() {
		String validTestNumber = "111111111";
		String nonValidTestNumber = "Jfe9843jthdfv";
		
		PaymentModel model = new PaymentModel();
		assertTrue(model.isCardNumberValid(validTestNumber));
		assertTrue(!model.isCardNumberValid(nonValidTestNumber));
	}
	
	@Test
	public void whenGetPaymentData() {
		
		PaymentModel model = new PaymentModel();
		
		int expected = 0;
		int actual = model.getPaymentData().size();
		assertEquals(expected, actual);
		
		expected = 1;
		model.setCardHolderName("Test");
		actual = model.getPaymentData().size();
		assertEquals(expected, actual);
		
		expected = 2;
		model.setCardNumber("1111");
		actual = model.getPaymentData().size();
		assertEquals(expected, actual);
	}

}
