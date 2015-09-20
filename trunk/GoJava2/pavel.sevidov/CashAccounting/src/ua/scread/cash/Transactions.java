package ua.scread.cash;

import java.util.ArrayList;

public final class Transactions {
	private static volatile Transactions instance;
	private ArrayList<Transaction> transactionList;
	private double balance = 0;
	
	private Transactions() {
		transactionList = new ArrayList<Transaction>();
	}
	
	public static Transactions getInstance() {
		if ( instance == null ) {
			synchronized (Transactions.class) {
				if (instance == null)
					instance = new Transactions();
			}
		}
		return instance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
		
		if (transaction.getType()) {
			balance += transaction.getCheck().getTotal();
		} else {
			balance -= transaction.getCheck().getTotal();
		}
	}
}
