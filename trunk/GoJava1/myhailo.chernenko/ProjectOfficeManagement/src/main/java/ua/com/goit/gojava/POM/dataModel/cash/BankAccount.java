package ua.com.goit.gojava.POM.dataModel.cash;

import java.util.Currency;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id = 0;
	
	@Column
	private String name = "";
	
	@Column(name = "bank_name")
	private String bankName = "";
	
	@Column
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
	
}