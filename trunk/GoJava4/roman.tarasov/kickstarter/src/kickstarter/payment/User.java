package kickstarter.payment;

public class User {
	private String name;
	Account account;

	public User(String name) {
		this.name = name;
		account=new Account();
	}

	String getName() {
		return name;
	}

	void setName(String name) {

	}
}
