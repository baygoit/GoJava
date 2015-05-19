package kickstarter.payment;

import java.util.HashMap;

public class AccountRepository {
	HashMap<User, BankAccount> bankAccount;

	public void addUser(User user, BankAccount account) {
		bankAccount.put(user, account);
	}
}
