package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

public class PaymentTest {

	private String userName = "Anton";
	private long creditCardNumber = 123456789;
	private int donatingSum = 1_000_000;
	private int projectID = 1;
	private Payment payment = new Payment();
	
	@Before
	public void setUp() throws Exception {
		payment.setUserName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setDonatingSum(donatingSum);
		payment.setProjectID(projectID);
	}

	@Test
	public void testPayment() {
		Payment myPayment = new Payment();
		assertThat(myPayment.getUserName().length(), is(0));
		assertThat(myPayment.getCreditCardNumber(), is(0));
		assertThat(myPayment.getDonatingSum(), is(0));
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
		assertThat(payment.getProjectID(), is(projectID));
	}

	@Test
	public void testSetProjectID() {
		int newProjectID = 2;
		payment.setProjectID(newProjectID);
		assertThat(payment.getProjectID(), is(newProjectID));
	}

}
