package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import ua.com.goit.gojava.POM.persistence.DataManager;


import ua.com.goit.gojava.POM.persistence.DataObject;

public class BankAccount implements DataObject , Serializable {
	
	private static final long serialVersionUID = 3817213953018189950L;
	private long id = 0;
	private String name = "";
	private String bankName = "";
	private List<BankAccountTransaction> transactions = new ArrayList<BankAccountTransaction>();
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getBankName() {
		
		return bankName;
		
	}
	
	public void setBankName(String bankName) {
		
		this.bankName = bankName;
		
	}
	
	public List<BankAccountTransaction> getTransactions() {
		
		return transactions;
		
	}
	
	public BankAccountTransaction addTransaction() {
		
		BankAccountTransaction transaction = new BankAccountTransaction();
		transactions.add(transaction);
		return transaction;
		
	}
	
	public void deleteDocTransaction(FinanceDocument doc) {
		
		for (int i = transactions.size() - 1; i >= 0 ; i--) {
			if (transactions.get(i).getDoc() == doc) {
				transactions.remove(i);
			}
		}
		
	}
	
	public long getTotal() {

		long result = 0;
		for (BankAccountTransaction transaction:getTransactions()) {
			
			result += transaction.getSum();
			
		}
		
		return result;
		
	}

}