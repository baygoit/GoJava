package ua.com.goit.gojava.POM.dataModel.common;

import java.util.Currency;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
	@Column(name = "from_currency")
	private Currency fromCurrency;
	
	@Column(name = "to_currency")
	private Currency toCurrency;
	
	@Column
	private long multiplicity;
	
	@Column
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
	public void setId(long id) {
		this.id = id;	
	}
	public long getId() {
		return id;
	}

}
