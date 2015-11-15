package ua.com.goit.gojava7.kickstarter.payment;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class CreditCardSystemTest{
	CreditCardSystem creditCard = new CreditCardSystem();

	@Test
	public void testSetGetName() {
		String name = "Name";
		creditCard.setHolderName(name);
		assertThat(creditCard.getHolderName(), is(name));
	}

	@Test
	public void testSetGetCardNumber() {
		int cardnumber = 1234567;
		creditCard.setCardNumber(cardnumber);
		assertThat(creditCard.getCreditCardNumber(), is(cardnumber));
	}

}
