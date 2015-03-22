package ua.com.goit.gojava.POM.dataModel.cash;

import java.util.Currency;
import java.util.Date;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;

public class CashMovementEntry {

	private long id;
	private Date date;
	private BankAccount bankAccount;
	private Money sum;
	private FinancialDocument doc;
	
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
	
	public Money getSum() {
		
		return sum;
		
	}
	
	public void setSum(Money sum) {
		
		this.sum = sum;
		
	}

	public BankAccount getBankAccount() {
		
		return bankAccount;
		
	}

	public void setBankAccount(BankAccount bankAccount) {
		
		this.bankAccount = bankAccount;
		
	}
	
	public Currency getCurrency() {
		
		Currency currency = null;
		if(bankAccount != null) {
			currency = bankAccount.getCurrency();
		}
		return currency;
		
	}

	public void setDoc(FinancialDocument doc) {
		this.doc = doc;
	}

	public FinancialDocument getDoc() {
		return this.doc;
	}
}
