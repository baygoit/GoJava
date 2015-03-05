package ua.com.goit.gojava.POM.dataModel.cash;

import java.util.Currency;
import ua.com.goit.gojava.POM.dataModel.common.Money;

public class BankAccount {
	
	private long id = 0;
	private String name = "";
	private String bankName = "";
	private Currency currency;
	
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

	public Money GetTotal() {
		
		Money total;
		
		// TODO rewrite with CashMovementDAO 
		//try {	
		//	total = getFactTransactions().getTotal(null, getCurrency());
		//} catch (POMDataModelException e) {
			total = new Money(getCurrency()); 
		//}
		return total;
		
	}
	
}