package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

public class PaymentTest {

	private String userName = "Anton";
	private long creditCardNumber = 123456789;
	private int donatingSum = 1000;
	private Payment payment;
	
	@Before
	public void setUp() throws Exception {
		payment = new Payment(userName, creditCardNumber, donatingSum);
	}

	@Test
	public void testPayment() {
		assertThat(payment.getUserName(), is(userName));
		assertThat(payment.getCreditCardNumber(), is(creditCardNumber));
		assertThat(payment.getDonatingSum(), is(donatingSum));
	}

	@Test
	public void testGetUserName() {
		assertThat(payment.getUserName(), is(userName));
	}

	@Test
	public void testSetUserName() {
		String name = "Alex";
		payment.setUserName(name);
		assertThat(payment.getUserName(), is(name));
	}

	@Test
	public void testGetCreditCardNumber() {
		assertThat(payment.getCreditCardNumber(), is(creditCardNumber));
	}

	@Test
	public void testSetCreditCardNumber() {
		long cardNumber = 12345;
		payment.setCreditCardNumber(cardNumber);
		assertThat(payment.getCreditCardNumber(), is(cardNumber));
	}

	@Test
	public void testGetDonatingSum() {
		assertThat(payment.getDonatingSum(), is(donatingSum));
	}

	@Test
	public void testSetDonatingSum() {
		int sum = 100;
		payment.setDonatingSum(sum);
		assertThat(payment.getDonatingSum(), is(sum));
	}

	@Test
	public void testGetProjectID() {
		assertThat(payment.getProjectID(), is(0));
	}

	@Test
	public void testSetProjectID() {
		int projectID = 1;
		payment.setProjectID(projectID);
		assertThat(payment.getProjectID(), is(1));
	}

}
