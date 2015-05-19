package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.payment.AccountRepository;
import kickstarter.payment.User;

import org.junit.Test;

public class testAccountRepository {

	@Test
	public void test() {
		testRepository();
	}

	void testRepository() {
		User newUser = new User("Andy");
		
AccountRepository accountRepo= new AccountRepository();

	}
}
