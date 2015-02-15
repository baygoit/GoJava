package ua.com.goit.gojava.POM.dataModel.cashSubsystem;

import java.io.Serializable;
import java.util.Currency;

import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.abstraction.DataObject;

public class BankAccount implements DataObject , Serializable {
	
	private static final long serialVersionUID = 3817213953018189950L;
	private long id = 0;
	private String name = "";
	private String bankName = "";
	private Currency currency;
	private CashMovementStatement factTransactions = new CashMovementStatement();
	private CashMovementStatement plannedTransactions = new CashMovementStatement();
	
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
	
	public Currency getCurrency() {

		return currency;
		
	}

	public void setCurrency(Currency currency) {
		
		this.currency = currency;
		
	}

	public CashMovementStatement getPlannedTransactions() {
		
		return plannedTransactions;
		
	}
	
	public CashMovementStatement getFactTransactions() {
		
		return factTransactions;
		
	}
	
	public Money GetTotal() {
		
		return getFactTransactions().getTotal(null, getCurrency());
		
	}
	
}