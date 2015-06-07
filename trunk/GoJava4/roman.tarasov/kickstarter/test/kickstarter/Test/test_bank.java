package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.payment.Bank;
import kickstarter.payment.BankException;

import org.junit.Test;

public class test_bank {
	Bank bank = new Bank();

	@Test
	public void test_get_correct_lot_of_money() {
		try {
			assertTrue(bank.getMoney("bankir", "777", "2000"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_get_null_lot_of_money() {
		try {
			assertFalse(bank.getMoney("bankir", "777", "0"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_get_incorrect_lot_of_money() {
		try {
			assertFalse(bank.getMoney("bankir", "777", "-1"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_get_too_many_money() {
		try {
			assertFalse(bank.getMoney("bankir", "777", "5001"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_null_login() {
		try {
			assertFalse(bank.getMoney(null, "777", "5"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test__empty_login() {
		try {
			assertFalse(bank.getMoney("", "777", "20"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test__incorrect_login() {
		try {
			assertFalse(bank.getMoney("a", "777", "20"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test__incorrect_cardnumber() {
		try {
			assertFalse(bank.getMoney("a", "77", "20"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test__infinity() {
		try {
			assertFalse(bank.getMoney("bankir", "777", "Infinity"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void test__NaN() {
		try {
			assertFalse(bank.getMoney("bankir", "777", "NaN"));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			
		}
	}

}
