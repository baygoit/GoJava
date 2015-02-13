package ua.com.goit.gojava.POM.dataModel;

import java.util.Currency;
import java.util.Date;

public class ExchangeRate {
	
	private Date date;
	private Currency fromCurrency;
	private Currency toCurrency;
	private long multiplicity;
	private long rate;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Currency getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(Currency fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public Currency getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(Currency toCurrency) {
		this.toCurrency = toCurrency;
	}
	public long getMultiplicity() {
		return multiplicity;
	}
	public void setMultiplicity(long multiplicity) {
		this.multiplicity = multiplicity;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}

}
