package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.payment.Bank;

import org.junit.Test;

public class test_bank {
	Bank bank = new Bank();

	@Test
	public void test_get_correct_lot_of_money() {
		assertTrue(bank.getMoney("bankir", "777", "2000"));
	}

	@Test
	public void test_get_null_lot_of_money() {
		assertFalse(bank.getMoney("bankir", "777", "0"));
	}

	@Test
	public void test_get_incorrect_lot_of_money() {
		assertFalse(bank.getMoney("bankir", "777", "-1"));
	}

	@Test
	public void test_get_too_many_money() {
		assertFalse(bank.getMoney("bankir", "777", "5001"));
	}

	@Test
	public void test_null_login() {
		assertFalse(bank.getMoney(null, "777", "5"));
	}

	@Test
	public void test__empty_login() {
		assertFalse(bank.getMoney("", "777", "20"));
	}
	@Test
	public void test__incorrect_login() {
		assertFalse(bank.getMoney("a", "777", "20"));
	}
	@Test
	public void test__incorrect_cardnumber() {
		assertFalse(bank.getMoney("a", "77", "20"));
	}

}
