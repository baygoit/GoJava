package dao.bank;

public class BankSingleton {
	private volatile static BankSingleton uniqueInstance;
	private static Bank bank;

	private BankSingleton() {
	}

	public static BankSingleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (BankSingleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new BankSingleton();
					bank = new Bank();
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized Bank getBank() {
		return bank;
	}
}