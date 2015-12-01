package ua.com.goit.gojava7.kickstarter.model;

import static org.junit.Assert.*;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class PaymentBonusTest {
	private PaymentBonus paymentBonus = new PaymentBonus();
	private HashMap<Integer, String> bonuses = new HashMap<>();
	@Test
	public void testPaymentBonus() {
		assertNotNull(paymentBonus);
	}

	@Test
	public void testSetBonuses() {
		paymentBonus.setBonuses(bonuses);
		assertThat(paymentBonus.getBonuses(),is(bonuses));
	}

}
