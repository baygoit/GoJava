package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.Date;

public class CashFlowStatementEntry implements Serializable {

	private static final long serialVersionUID = 4386873221423578793L;
	private long id;
	private Date date;
	private BankAccount bankAccount;
	private String description;
	private Money sum;
	private FinanceDocument doc;
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public Date getDate() {
		
		return date;
		
	}
	
	public void setDate(Date date) {
		
		this.date = date;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public Money getSum() {
		
		return sum;
		
	}
	
	public void setSum(Money sum) {
		
		this.sum = sum;
		
	}
	
	public FinanceDocument getDoc() {
		
		return doc;
		
	}
	
	public void setDoc(FinanceDocument doc) {
		
		this.doc = doc;
		
	}

	public BankAccount getBankAccount() {
		
		return bankAccount;
		
	}

	public void setBankAccount(BankAccount bankAccount) {
		
		this.bankAccount = bankAccount;
		
	}
	
}
