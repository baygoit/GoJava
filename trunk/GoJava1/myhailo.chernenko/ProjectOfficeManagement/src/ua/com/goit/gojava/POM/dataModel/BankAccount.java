package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.Currency;
//import java.util.List;
//import ua.com.goit.gojava.POM.persistence.DataManager;



import ua.com.goit.gojava.POM.persistence.DataObject;

public class BankAccount implements DataObject , Serializable {
	
	private static final long serialVersionUID = 3817213953018189950L;
	private long id = 0;
	private String name = "";
	private String bankName = "";
	private Currency currency;
	//private List<CashFlowStatementEntry> transactions = new ArrayList<CashFlowStatementEntry>();
	
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
	
	/*public List<CashFlowStatementEntry> getTransactions() {
		
		return transactions;
		
	}
	
	public CashFlowStatementEntry addTransaction() {
		
		CashFlowStatementEntry transaction = new CashFlowStatementEntry();
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
	
	public Money getTotal() {

		long result = 0;
		for (CashFlowStatementEntry transaction:getTransactions()) {
			
			result += transaction.getSum();
			
		}
		
		return result;
		
	}
	*/
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}