package ua.scread.cash;

public class Transaction {

	private Check check;
	private boolean type; // type is type of transaction. Can be incoming(true) or consumption(false).
	
	public Transaction(Check check, boolean type) {
		this.check = check;
		this.type = type;
		send();
	}

	public void send() {
		Transactions.getInstance().addTransaction(this);
	}

	public Check getCheck() {
		return check;
	}

	public boolean getType() {
		return type;
	}


}
