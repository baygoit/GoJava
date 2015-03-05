package ua.com.goit.gojava.POM.dataModel.common;

import java.io.Serializable;
import java.util.Date;

public abstract class FinancialEntry implements Serializable {

	private static final long serialVersionUID = 4386873221423578793L;
	private long id;
	private Date date;
	//private FinancialCharacteristic characteristic;
	private String description;
	private Money sum;
	//private FinancialDocument doc;
	
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
	
	/*public FinancialDocument getDoc() {
		
		return doc;
		
	}
	
	public void setDoc(FinancialDocument doc) {
		
		this.doc = doc;
		
	}

	public FinancialCharacteristic getCharacteristic() {
		
		return characteristic;
		
	}

	public void setCharacteristic(FinancialCharacteristic characteristic) {
		
		this.characteristic = characteristic;
		
	}*/
	
}
